📌 UserRegistrationLiveDataApp

📝 Description

UserRegistrationLiveDataApp is a simple Android application built using the MVVM architecture with LiveData and ViewModel.
It demonstrates user registration and login functionality with local persistence using Room Database.
The app validates user inputs and provides success/failure feedback via dialogs.

🚀 Features

Splash screen with app logo
Main screen with Register & Login options
Registration form with validation (name, email, mobile, gender, age, password)
Login using email or mobile + password
Data persistence with Room
LiveData-based reactive UI updates
Clean MVVM + Repository pattern

⚙️ Tools & Technologies Used

Language: Kotlin
UI: XML layouts with ViewBinding
Architecture: MVVM (Model-View-ViewModel)
Database: Room (Jetpack)
Coroutines: For background database operations
LiveData & ViewModel: For state management
AndroidX Libraries (AppCompat, Material, Lifecycle, etc.)

📂 Project Structure

              ug.go.ugpass.userregistratiomvvmapp
              ├─ data/
              │   ├─ entity/User.kt
              │   ├─ dao/UserDao.kt
              │   ├─ database/AppDatabase.kt
              ├─ repository/
              │   └─ UserRepository.kt
              ├─ viewmodel/
              │   ├─ RegisterViewModel.kt
              │   ├─ LoginViewModel.kt
              ├─ ui/
              │   ├─ splash/SplashActivity.kt
              │   ├─ main/MainActivity.kt
              │   ├─ register/RegisterActivity.kt
              │   ├─ login/LoginActivity.kt
              ├─ res/layout/ (All XML UI files)
              ├─ AndroidManifest.xml


🎯 Learning Purpose

This project is great for practicing:
MVVM architecture with LiveData
Room database integration
ViewBinding usage
Form validation
Dialogs for user feedback
              