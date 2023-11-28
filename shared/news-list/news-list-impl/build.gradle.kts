plugins {
    id("android-setup")
    id("multiplatform-setup")
}

android {
    namespace = "ru.slartus.forpda.news_list.impl"
}

kotlin {
    androidTarget()
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:news-list:news-list-api"))
                implementation(libs.decompose)
            }
        }
    }
}