# EpzigDesignSystem

Required compileSdk 31
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
    implementation 'com.github.dimas-prasetyo:EpzigDesignSystem:1.0.8'
}
```

# Contents
*   [Icon](assets/icons.md)
*   [Inputs](assets/inputs/inputs.md)
*   [Buttons](assets/button/buttons.md)
*   [Snackbar](assets/snackbar.md)
*   [Dialog/Bottom Sheet](assets/dialog_bottom_sheet.md)
