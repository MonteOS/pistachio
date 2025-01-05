plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.android.build-logic"

dependencies {
    compileOnly(gradleApi())
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}
