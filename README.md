# ☕ Coffee Route

**Coffee Route** es una app personal para impulsar la cultura del café: conocer su historia,
sus beneficios y descubrir lugares donde tomar un buen café.

Está construida con **Kotlin Multiplatform** y **Compose Multiplatform**, con un solo código
de interfaz para **Android, iOS y escritorio**.

> 🚧 MVP en desarrollo. La idea es seguir sumando contenido y funcionalidades alrededor del café.

## Secciones del MVP
- **Inicio:** puerta de entrada al mundo del café.
- **Historia:** el origen del café y su cultura.
- **Sitios:** encuentra lugares para tomarte un buen café en un mapa, usando tu ubicación (GPS)
  o buscándolos por nombre o zona.

## Lo que ya está construido
- Navegación inferior con las tres secciones del MVP usando **Navigation 3** y rutas tipadas.
- Historial de navegación independiente por pestaña, que conserva el estado al rotar o volver a la app.
- Tema visual propio en **Material 3**, inspirado en el café (marrones, cremas y verde hoja de café).
- Estructura multiplataforma lista para Android, iOS y escritorio.

## Próximos pasos
- [ ] Contenido de la sección Historia
- [ ] Sección de beneficios del café
- [ ] Mapa de sitios con tu ubicación actual (GPS)
- [ ] Buscador de sitios para encontrar un buen café por nombre o zona
- [ ] Detalle de cada sitio
- [ ] Nuevas funcionalidades para seguir impulsando la cultura del café

## Tecnologías
Kotlin Multiplatform · Compose Multiplatform · Material 3 · Navigation 3 · kotlinx.serialization

## Estructura del proyecto
- `shared/` – código común: interfaz, navegación y tema.
  - `commonMain` – código compartido por todas las plataformas.
  - `androidMain`, `iosMain`, `jvmMain` – código específico de cada plataforma.
- `androidApp/` – punto de entrada de la app Android.
- `iosApp/` – punto de entrada de la app iOS (SwiftUI).
- `desktopApp/` – punto de entrada de la app de escritorio (JVM).

## Cómo ejecutarlo
- **Android:** `./gradlew :androidApp:assembleDebug`
- **Escritorio:** `./gradlew :desktopApp:run`
- **iOS:** abre la carpeta `/iosApp` en Xcode y ejecuta.
