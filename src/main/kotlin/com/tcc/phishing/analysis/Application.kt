package com.tcc.phishing.analysis

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
class Application

fun main(args: Array<String>) {

	runApplication<Application>(*args)
}
