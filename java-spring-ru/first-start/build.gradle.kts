import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    // BEGIN
    application
    alias(libs.plugins.freefairLombokPLugin)
    alias(libs.plugins.benManesVersionsPlugin)
    alias(libs.plugins.johnrengelmanShadowPlugin)
    alias(libs.plugins.patrikerdesUseLatestVersionsPlugin)
    alias(libs.plugins.littlerobotsVersionCatalogUpdatePlugin)
    alias(libs.plugins.springFrameworkPlugin)
    alias(libs.plugins.springDependencyManagementPlugin)

    // END
}

group = "exercise"

version = "1.0-SNAPSHOT"

application { mainClass.set("exercise.Application") }

repositories {
    mavenCentral()
}

dependencies {
    // BEGIN
/*    testImplementation(platform(libs.junitBom))
    testImplementation(libs.jupiter)
    testImplementation(libs.spring.boot.starter.test)

    compileOnly(libs.lombok)
    compileOnly(libs.mapstruct)

    annotationProcessor(libs.lombok)
    annotationProcessor(libs.mapstruct.processor)
    annotationProcessor(libs.lombok.mapstruct.binding)

    implementation(libs.bundles.jacksonBundle)
    implementation(libs.bundles.springBundle)
    implementation(libs.springdoc.openapi.starter.webmvc.ui)
    implementation(libs.jackson.databind.nullable)
    implementation(libs.commons.lang3)
    implementation(libs.datafaker)
    implementation(libs.instancio.junit)
    implementation(libs.json.unit.assertj)

    runtimeOnly(libs.h2)

    testRuntimeOnly(libs.junit.platform.launcher)*/

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")

    // END
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}
