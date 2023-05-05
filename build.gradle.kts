import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val basePackage = "com.tcc.phishing.analysis"
val basePath = "com/tcc/phishing/analysis"

plugins {
	id("org.springframework.boot") version "2.7.10"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("org.openapi.generator") version "5.3.0"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.tcc"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	compileOnly("io.swagger:swagger-annotations:1.6.6")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// test
	implementation("junit:junit:4.13.2")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.check { dependsOn("test") }

// openApiGenerate
tasks.compileKotlin { dependsOn("openApiGenerate") }
openApiGenerate {
	generatorName.set("spring")
	inputSpec.set(file("$rootDir/src/main/resources/openapi.yaml").absolutePath)
	outputDir.set(file("$buildDir/generated/openApi").absolutePath)
	modelNameSuffix.set("Dto")
	configOptions.set(
			mapOf(
					"dateLibrary" to "java8",
					"gradleBuildFile" to "false",
					"basePackage" to "$basePackage.application.web.api",
					"apiPackage" to "$basePackage.application.web.api",
					"modelPackage" to "$basePackage.application.web.dto",
					"interfaceOnly" to "true",
					"hideGenerationTimestamp" to "true",
					"openApiNullable" to "false"
			)
	)
}
sourceSets { getByName("main") { java { srcDir("$buildDir/generated/openapi/src/main/java") } } }
