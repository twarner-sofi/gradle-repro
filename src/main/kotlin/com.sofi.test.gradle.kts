plugins {
    java
}

tasks.register("printHello") {
    doLast {
        println("hello gradle ${gradle.gradleVersion}")
    }
}
