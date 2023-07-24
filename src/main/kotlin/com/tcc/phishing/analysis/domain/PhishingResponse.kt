package com.tcc.phishing.analysis.domain

import com.tcc.phishing.analysis.application.web.dto.PhishingResponseDto

data class PhishingResponse(
        val phishingScore: Float
) {
    fun fromDomain() = PhishingResponseDto()
            .phishingScore(phishingScore)
}
