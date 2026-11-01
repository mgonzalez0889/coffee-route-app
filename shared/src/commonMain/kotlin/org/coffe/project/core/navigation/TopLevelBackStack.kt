package org.coffe.project.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.json.Json

class TopLevelBackStack(startRoute: NavKey) {
    private val backStacks = mutableMapOf<NavKey, MutableList<NavKey>>()
    var topLevelKey by mutableStateOf(startRoute)
        private set

    init {
        backStacks[startRoute] = mutableStateListOf(startRoute)
    }

    fun addTopLevel(key: NavKey) {
        if (topLevelKey == key) return
        topLevelKey = key
        if (backStacks[key] == null) {
            backStacks[key] = mutableStateListOf(key)
        }
    }

    val flattenedBackStack: List<NavKey>
        get() = backStacks[topLevelKey] ?: emptyList()

    fun removeLastOrNull() {
        val currentStack = backStacks[topLevelKey] ?: return
        if (currentStack.size > 1) {
            currentStack.removeAt(currentStack.lastIndex)
        }
    }
}

@Composable
fun rememberTopLevelBackStack(startRoute: NavKey): TopLevelBackStack {
    return rememberSaveable(
        saver = Saver(
            save = { stack ->
                savedJson.encodeToString(stack.topLevelKey)
            },
            restore = { savedString ->
                val route = savedJson.decodeFromString<NavKey>(savedString)
                TopLevelBackStack(route)
            }
        )
    ) {
        TopLevelBackStack(startRoute)
    }
}