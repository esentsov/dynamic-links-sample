import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}
apply(plugin = "androidx.navigation.safeargs.kotlin")

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "com.esentsov.sample.deeplinks"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        addManifestPlaceholders(mapOf("deepLinkHost" to "esentsov.page.link"))
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType < KotlinCompile > {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(kotlin("stdlib-jdk7", kotlinVersion))

    implementation("androidx.appcompat:appcompat:$appcompat")
    implementation("androidx.core:core-ktx:$coreKtx")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayout")
    implementation("androidx.fragment:fragment-ktx:$fragmentKtx")
    implementation("com.google.android.material:material:$materialDesign")

    implementation("androidx.navigation:navigation-fragment-ktx:$navigation")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation")

    implementation ("com.google.firebase:firebase-invites:$firebaseInvites")

    testImplementation("junit:junit:$junit")
    androidTestImplementation("androidx.test:runner:$androidTestRunner")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espresso")
}
apply(plugin = "com.google.gms.google-services")