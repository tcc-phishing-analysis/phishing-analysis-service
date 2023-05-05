package com.tcc.phishing.analysis.application.controller

import com.tcc.phishing.analysis.application.interfaces.PhishingInterface
import com.tcc.phishing.analysis.application.web.api.PhishingApi
import com.tcc.phishing.analysis.application.web.dto.PhishingRequestDto
import com.tcc.phishing.analysis.application.web.dto.PhishingResponseDto
import com.tcc.phishing.analysis.domain.dto.toDomain
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PhishingController(
        private val phishingInterface: PhishingInterface
) : PhishingApi {

    override fun analisePhishing(phishingRequestDto: PhishingRequestDto): ResponseEntity<PhishingResponseDto> {
        val response = phishingInterface.getPhishingScore(phishingRequestDto.toDomain())

        return ResponseEntity
                .ok()
                .body(response.fromDomain())
    }
}