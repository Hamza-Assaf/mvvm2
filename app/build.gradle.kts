plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp") version "2.0.20-1.0.24"


}




android {
    namespace = "com.example.mvvm2"
    compileSdk = 34


    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.mvvm2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //base
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //lottie
    implementation (libs.lottie.v340)

    //coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.rx2)

    //room
    val room_version = "2.6.1"
    annotationProcessor(libs.androidx.room.compiler)
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.common)
    implementation (libs.androidx.room.ktx)
    implementation (libs.androidx.room.rxjava2)
    implementation (libs.androidx.room.rxjava3)
    implementation (libs.androidx.room.guava)
    implementation (libs.androidx.room.testing)
    implementation (libs.androidx.room.paging)
    ksp("androidx.room:room-compiler:$room_version")


    //glide
    implementation (libs.glide)

    //navigation
    implementation (libs.androidx.navigation.ui.ktx)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.dynamic.features.fragment)
    implementation (libs.androidx.navigation.testing)

    //retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.gson)

    val lifecycle_version = "2.8.6"


    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

// LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)








}