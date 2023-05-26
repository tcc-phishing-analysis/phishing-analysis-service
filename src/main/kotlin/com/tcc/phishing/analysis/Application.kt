package com.tcc.phishing.analysis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	val jdbcUrl = "jdbc:postgresql://localhost:5432/example"

	runApplication<Application>(*args)
}
