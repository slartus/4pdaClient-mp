plugins {
    id("android-setup")
    id("multiplatform-setup")
}

android {
    namespace = "ru.slartus.forpda.news_list.api"
}

kotlin {
    androidTarget()
    sourceSets {
        commonMain {
            dependencies {

            }
        }
    }
}