plugins {
    id("my-java-library")
}

dependencies {
    implementation(platform("com.mkpassi:platform"))
    implementation(project(":data-model"))
    integrationTestsImplementation(platform("com.mkpassi:platform"))
    implementation(libs.commons.lang)
    // implementation("org.apache.commons:commons-lang3")


    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")


    integrationTestsImplementation("org.junit.jupiter:junit-jupiter-api")
    integrationTestsRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
//    integrationTestsImplementation("...")

}


/*dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

configurations {

}*/
