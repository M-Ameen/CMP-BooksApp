# Compose Demo

A Kotlin Multiplatform template application built with Jetpack Compose Multiplatform. This demo currently implements a **Book List** application that fetches data from an API, caches it locally, and displays it in a clean, scrollable list.

## 🚀 What This App Does
This application demonstrates how to build a shared UI and business logic layer using Compose Multiplatform. 
Currently, it fetches a list of books from a remote backend, parses the data, stores it in a local database for offline support, and displays it via Jetpack Compose.

## 📦 Libraries & Tech Stack Used
The project heavily relies on common multiplatform libraries to maximize code sharing:

* **UI Framework:** [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)
* **Architecture / State:** MVI/MVVM pattern with ViewModel & Jetpack Lifecycle
* **Dependency Injection:** [Koin](https://insert-koin.io/)
* **Navigation:** [Voyager](https://voyager.adriel.cafe/)
* **Networking:** [Ktor Client](https://ktor.io/)
* **JSON Parsing:** `kotlinx-serialization`
* **Local Database:** [Room Database (Multiplatform)](https://developer.android.com/training/data-storage/room) & SQLite Bundled
* **Concurrency:** Kotlin Coroutines & Flows
* **Image Loading:** [Coil 3](https://coil-kt.github.io/coil/)
* **Media Playback:** Media3 Exoplayer
* **Date & Time:** `kotlinx-datetime`
* **Logging:** [Kermit](https://github.com/touchlab/Kermit)

## 📱 Platforms Supported
The application is pre-configured for the following platforms:
- ✅ **Android**
- ✅ **iOS** (Arm64, Simulator Arm64)
- ✅ **Desktop (JVM)** (macOS, Windows, Linux)

*(Note: Web target using WasmJS/JS is currently disabled in `composeApp/build.gradle.kts` but can be easily enabled)*

## 🔮 Future Improvements
While the foundation is solid, there are several areas planned for improvement:

- **Writing Test Cases:** Implement comprehensive Unit Tests for shared business logic and UI tests for Composables.
- **Better Error Handling:** Provide a more robust approach to network failures, empty states, and offline feedback.
- **Advanced Features:** Add search, filtering, and a Book Details screen to navigate into.
- **Web Support:** Re-enable and test the Kotlin/Wasm target for modern browser deployment.
- **Improved UI/UX:** Refine the presentation layer with better animations, theming consistency, and responsiveness across varying screen sizes.

---

### Build and Run Android Application
To build and run the development version of the Android app, use the run configuration from the run widget in your IDE’s toolbar or build it directly from the terminal:
```bash
./gradlew :composeApp:assembleDebug
```

### Build and Run iOS Application
To build and run the development version of the iOS app, use the run configuration from the run widget in your IDE’s toolbar or open the `iosApp` directory in Xcode and run it from there.

### Build and Run Desktop Application
Run the Desktop JVM target using:
```bash
./gradlew :composeApp:run
```
