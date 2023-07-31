package com.tcc.phishing.analysis.application.web.controller

import com.tcc.phishing.analysis.application.interfaces.PhishingStrategy
import com.tcc.phishing.analysis.application.resources.S3Resources
import com.tcc.phishing.analysis.application.web.api.PhishingApi
import com.tcc.phishing.analysis.application.web.dto.PhishingRequestDto
import com.tcc.phishing.analysis.application.web.dto.PhishingResponseDto
import com.tcc.phishing.analysis.domain.dto.toDomain
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PhishingController(
        private val phishingStrategy: PhishingStrategy,
        private val s3Resources: S3Resources
) : PhishingApi {

    override fun analisePhishing(phishingRequestDto: PhishingRequestDto): ResponseEntity<PhishingResponseDto> {
        val response = phishingStrategy.getPhishingScore(phishingRequestDto.toDomain())

        return ResponseEntity
                .ok()
                .body(response.fromDomain())
    }

    @GetMapping("/dataframe")
    fun getDataset(): ResponseEntity<Dataset<Row>>{

        return ResponseEntity.ok().body(s3Resources.readFile())
    }
}