import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// Run application by Gradle
	id("org.springframework.boot") version "2.7.0"
	// Manage dependencies
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	// Kotlin DSL 独自の書き方。
	// id("org.jetbrains.kotlin.jvm") version "1.6.21" と一緒の意味。
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"

	id("com.arenagod.gradle.MybatisGenerator") version "1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_14

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.4.0")
	implementation("mysql:mysql-connector-java:8.0.29")
	mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "14"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

mybatisGenerator {
	verbose = true
	configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
}
