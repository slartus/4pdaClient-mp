plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("org.jetbrains.compose")
}

android {
    namespace = "ru.slartus.forpda.news_list.compose"
}

kotlin {
    androidTarget()
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)

                implementation(project(":shared:news-list:news-list-api"))
                implementation(project(":shared:news-list:news-list-impl"))
                implementation(libs.decompose)
                implementation(libs.decompose.extensions.experimental)
            }
        }
    }
}