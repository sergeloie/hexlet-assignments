import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    // BEGIN
    application
    checkstyle
    alias(libs.plugins.benManesVersionsPlugin)
    alias(libs.plugins.springFrameworkPlugin)
    alias(libs.plugins.springDependencyManagementPlugin)
    // END


}

group = "exercise"

version = "1.0-SNAPSHOT"

application { mainClass.set("exercise.Application") }

repositories {
    google()
    mavenCentral()
}

dependencies {
    // BEGIN
    implementation(libs.bundles.springStudy)
    testImplementation(libs.bundles.junitBundle)
    testImplementation(platform(libs.junitBom))
    testImplementation("org.hamcrest:hamcrest:2.2")
    // END
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}
