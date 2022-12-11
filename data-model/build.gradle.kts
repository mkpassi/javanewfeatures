plugins {
    id("my-java-library")
}

dependencies {
    //implementation(project(":business-logic"))
    implementation(platform("com.mkpassi:platform"))
}