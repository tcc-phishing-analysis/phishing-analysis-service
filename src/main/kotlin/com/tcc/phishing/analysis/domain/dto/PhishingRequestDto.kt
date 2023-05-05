package com.tcc.phishing.analysis.domain.dto

import com.tcc.phishing.analysis.domain.PhishingRequest
import com.tcc.phishing.analysis.application.web.dto.PhishingRequestDto
import com.tcc.phishing.analysis.domain.enums.PhishingType

fun PhishingRequestDto.toDomain() = PhishingRequest(
        PhishingType.getValue(this.type.name),
        this.content
)
