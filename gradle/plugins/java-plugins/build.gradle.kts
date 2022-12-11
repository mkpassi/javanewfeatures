
plugins {
    id("java-gradle-plugin")
    //`kotlin-dsl` // id("kotlin-dsl")
}

gradlePlugin {
    plugins.create("MyJavaBase"){
        id = "my-java-base"
        implementationClass = "com.mkpassi.gradle.MyJavaBasePlugin"
    }

    plugins.create("MyJavaLibrary"){
        id ="my-java-library"
        implementationClass = "com.mkpassi.gradle.MyJavaLibraryPlugin"
    }

    plugins.create("MyJavaApplication"){
        id = "my-application"
        implementationClass = "com.mkpassi.gradle.MyJavaApplicationPlugin"
    }
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.8.0")
}
