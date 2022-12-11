plugins{
   id("my-application")
}

application{
   mainClass.set("com.mkpassi.MyApplication")
}


dependencies {
   implementation(platform("com.mkpassi:platform"))
   //ons-lang)
   implementation(project(":data-model"))
   implementation(project(":business-logic"))
}

