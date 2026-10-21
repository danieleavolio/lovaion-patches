group = "app.daniele"

patches {
    about {
        name = "Lovaion Patches"
        description = "Morphe patches for Cinemaniac and Column. " +
            "Patched by Morphe — support the original developers!"
        source = "https://github.com/danieleavolio/lovaion-patches"
        author = "Daniele Avolio"
        contact = "https://github.com/danieleavolio"
        website = "https://github.com/danieleavolio/lovaion-patches"
        license = "GPLv3"
    }
}

val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    // Used by gradle-semantic-release-plugin.
    publish {
        dependsOn("generatePatchesList")
    }
}
