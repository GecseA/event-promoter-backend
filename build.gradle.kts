import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.3.0"
    id("io.ktor.plugin") version "3.4.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.3.0"
    id("org.openapi.generator") version "7.19.0"
}

group = "hu.gecsevar"
version = "0.0.1"

application {
    mainClass = "hu.gecsevar.ApplicationKt"
}

kotlin {
    jvmToolchain(21)

    sourceSets {
        getByName("main").kotlin.srcDirs("${layout.buildDirectory.get()}/generated/hu")
    }
}

dependencies {
    implementation("io.ktor:ktor-server-caching-headers")
    implementation("io.ktor:ktor-server-compression")
    implementation("io.ktor:ktor-server-conditional-headers")
    implementation("io.ktor:ktor-server-cors")
    implementation("io.ktor:ktor-server-default-headers")
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-auth")
    implementation("io.ktor:ktor-server-auth-jwt")
    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-apache")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("io.ktor:ktor-server-sessions")
    implementation("io.ktor:ktor-server-cio")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

buildscript {
    dependencies {
        // OpenAPI
        classpath("hu.gecsevar:gv-openapi:3.0.0")
    }
}

tasks.create("openApiGenerate" + "EventPromoterAPI", GenerateTask::class.java) {
    generatorName.set("gv-ktor-server")
    inputSpec.set("$rootDir/api/EventPromoterAPI.yml")
    outputDir.set("${layout.buildDirectory.get()}/generated/")
    apiPackage.set("hu.gecsevar.plugins.api")
    modelPackage.set("hu.gecsevar.database.view")

    // Add these properties for 3.1.x support
    additionalProperties.put("useOneOfDiscriminatorLookup", true)
    additionalProperties.put("supportUrlQuery", true)
    additionalProperties.put("openApi31", true)
    additionalProperties.put("skipValidateSpec", true)
    // Enable legacy mode if needed
    additionalProperties.put("legacyDiscriminatorBehavior", false)
    // Specify OpenAPI specification version
    additionalProperties.put("openApiNullable", true)
    additionalProperties.put("generateNullableTypes", true)
    // Optional: Configure validation
    validateSpec.set(false)
    skipValidateSpec.set(true)
}

tasks.compileKotlin {
    dependsOn("openApiGenerateEventPromoterAPI")
}