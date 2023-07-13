import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example.e3fxgaming"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    testImplementation("org.seleniumhq.selenium:htmlunit-driver:4.10.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<ShadowJar>("testJar") {
    archiveClassifier.set("tests")
    from(sourceSets.test.get().output)
    configurations = listOf(project.configurations.testRuntimeClasspath.get())
}

/*
tasks.shadowJar {
    from(sourceSets.test.get().output)
    configurations = configurations.also {
        it.add(project.configurations.testRuntimeClasspath.get())
    }
}
 */