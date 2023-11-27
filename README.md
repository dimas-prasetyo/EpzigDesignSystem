# EpzigDesignSystem

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
# Input
**Contents**

*   [Input Text Plain](#input-text-plain)
*   [Input Text Affix](#input-text-affix)
*   [Input Text Icon](#input-text-icon)
*   [Input Text Area](#input-text-area)
*   [Input Text Dropdown](#input-text-dropdown)
*   [Input Text Choose](#input-text-choose)
