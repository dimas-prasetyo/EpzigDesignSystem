# EpzigDesignSystem

Required:
compileSdk 34
minSdk 28


# Getting started
Step 1. Add the JitPack repository to your build file. Add it in your root setting.gradle at the end of repositories:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.dimas-prasetyo:EpzigDesignSystem:1.0.9'
}
```

# Contents
*   [Buttons](assets/buttons/buttons.md)
*   [Dialog/Bottom Sheet](assets/dialogs/dialogs.md)
*   [Icon](assets/icons.md)
*   [Inputs](assets/inputs/inputs.md)
*   [Snackbar](assets/snackbars/snackbars.md)
*   [Typography](assets/typography.md)
