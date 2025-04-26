plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.android.build-logic"

dependencies {
    implementation(projects.kotlin)
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("android-lib") {
            id = "convention.kotlin-android-library"
            implementationClass = "com.convention.AndroidLibraryConventionPlugin"
        }

        create("android-app") {
            id = "convention.kotlin-android-app"
            implementationClass = "com.convention.AndroidApplicationConventionPlugin"
        }

        create("android-compose") {
            id = "convention.android-compose"
            implementationClass = "com.convention.compose.AndroidComposeConventionPlugin"
        }

        create("hilt") {
            id = "convention.hilt"
            implementationClass = "com.convention.HiltConventionPlugin"
        }
    }
}
