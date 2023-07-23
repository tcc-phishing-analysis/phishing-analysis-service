import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val basePackage = "com.tcc.phishing.analysis"
val basePath = "com/tcc/phishing/analysis"

plugins {
	id("org.springframework.boot") version "2.7.10"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("org.openapi.generator") version "5.3.0"
	kotlin("jvm") version "1.8.0"

	kotlin("plugin.spring") version "1.8.0"
	kotlin("plugin.jpa") version "1.8.0"
}

group = "com.tcc"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jetty")
	implementation("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springdoc:springdoc-openapi-ui:1.5.9")
	implementation("aws.sdk.kotlin:aws-core-jvm:0.25.0-beta")
	implementation("aws.sdk.kotlin:s3:0.25.0-beta")
	implementation("org.apache.spark:spark-core_2.12:3.2.0")
	implementation("org.apache.spark:spark-sql_2.12:3.2.0")
	compileOnly("io.swagger:swagger-annotations:1.6.6")
	 //implementation("org.postgresql:postgresql:42.3.1")

	// database
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")

	// ML - SingularValueDecomposition
	implementation("org.apache.commons:commons-math3:3.6.1")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("junit:junit:4.13.2")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

configurations {
	runtimeOnly {
		exclude(group = "org.slf4j", module = "slf4j-log4j12")
	}

	compileOnly {
		exclude(group = "org.slf4j", module = "slf4j-log4j12")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
		languageVersion = "1.8"
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

sourceSets {
	getByName("main") {
		java {
			srcDir("$buildDir/generated/openapi/src/main/java")
		}
	}
}
