plugins {
    // Java support
    id("java")
    id("org.jetbrains.intellij") version "1.6.0"
}

group = "org.intellij.sdk"
version = "1.0.0"

// Configure project's dependencies
repositories {
    mavenCentral()
}

dependencies {
    implementation("org.deeplearning4j:deeplearning4j-nlp:1.0.0-M1.1")
    implementation("org.nd4j:nd4j-native-platform:1.0.0-M1.1")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

intellij {
    version.set("2021.2.4")
    plugins.set(listOf("com.intellij.java"))
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("212")
        untilBuild.set("221.*")
    }
}