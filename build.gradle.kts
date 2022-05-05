import org.jetbrains.kotlin.konan.target.buildDistribution

plugins {
    kotlin("multiplatform") version "1.6.21"
}

group = "me.zeckson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js(IR) {
        binaries.executable()

        browser {
        }

    }
    sourceSets.all {
        languageSettings.apply {
            optIn("kotlin.RequiresOptIn") // annotation FQ-name
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation(npm("jshashes", "1.0.8"))
            }
        }
        val jsTest by getting
    }
}
