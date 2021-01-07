plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.thomy.lovedog"

        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":usecases"))

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.2.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.0-beta7")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")


    implementation ("androidx.viewpager2:viewpager2:1.0.0")

    implementation ("com.google.android.material:material:1.2.1")


    //Viewmodel
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.2")


    implementation ("androidx.room:room-runtime:2.2.6")
    kapt ("androidx.room:room-compiler:2.2.6")

    implementation ("com.google.dagger:dagger:2.28.1")
    kapt ("com.google.dagger:dagger-compiler:2.28.1")
}