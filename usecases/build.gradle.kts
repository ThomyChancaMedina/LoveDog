plugins {
    id ("java-library")
    id ("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
}