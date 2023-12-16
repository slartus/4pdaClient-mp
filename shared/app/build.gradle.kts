plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("org.jetbrains.compose")
    id("kotlin-parcelize")
}

android {
    namespace = "ru.slartus.forpda.app"
}

kotlin {
    androidTarget()
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)


                implementation(project(":shared:common:common-utils"))
                implementation(project(":shared:news-list:news-list-impl"))
                implementation(project(":shared:news-list:news-list-compose"))
                implementation(libs.decompose)
                implementation(libs.decompose.extensions.experimental)
                implementation(libs.materialKolor)
            }
        }
    }
}