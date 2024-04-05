plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.coockinglooping"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coockinglooping"
        minSdk = 29
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

    implementation(libs.core.ktx)
    //noinspection UseTomlInstead
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //GLide
    implementation(libs.image.glide)
    //Room
    kapt(libs.room.compiler)
    implementation(libs.room.runtime)
    //Retrofit
    implementation(libs.retrofit2.std)
    implementation(libs.retrofit2.converter)
    implementation(libs.okhhtp.interceptor)
    implementation(libs.okhttp)
    //Coroutines
    implementation(libs.coroutine.core)
    implementation(libs.coroutines.android)
    //GSON
    implementation(libs.gson)
    //Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    //Dagger
    implementation(libs.dagger.std)
    kapt(libs.dagger.compiler)
    implementation(libs.dagger.runtime)
    //Lifecycle
    implementation(libs.lifycycle.runtime)
    implementation(libs.lifecycle.livedata)
    //Serializable
    implementation(libs.sirializable)


}