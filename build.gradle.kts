plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

group = "com.sofi"
version = "1-SNAPSHOT"

tasks.withType(Test::class.java) {
    useJUnitPlatform()
}
