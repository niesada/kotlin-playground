plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "kotlin-playground"
include("src:main:testtete")
findProject(":src:main:testtete")?.name = "testtete"
