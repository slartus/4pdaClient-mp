plugins {
    id("android-setup")
    id("multiplatform-setup")
}

android {
    namespace = "ru.slartus.forpda.common.utils"
}

kotlin {
    androidTarget()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.napier)
            }
        }
    }
}