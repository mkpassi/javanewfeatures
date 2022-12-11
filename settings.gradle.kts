
    pluginManagement {
        /*repositories.gradlePluginPortal();
        repositories.mavenCentral();
        repositories.google();*/
        includeBuild("gradle/plugins")

    }

    dependencyResolutionManagement {
        repositories.mavenCentral()
        //repositories.google()
        includeBuild("gradle/platform")
    }

    include("app")
    include("business-logic")
    include("data-model")

    rootProject.name = "gradle-my-project"