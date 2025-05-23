package com.convention.jvm

import com.convention.KotlinBaseConventionPlugin
import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class KotlinJvmBasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("kotlin")
            plugins.apply(KotlinBaseConventionPlugin::class.java)

            val javaTarget = JavaLanguageVersion.of(libs.versions.java.get())
            extensions.configure(KotlinJvmProjectExtension::class.java) { kotlin ->
                kotlin.jvmToolchain {
                    it.languageVersion.set(javaTarget)
                }
            }
        }
    }
}
