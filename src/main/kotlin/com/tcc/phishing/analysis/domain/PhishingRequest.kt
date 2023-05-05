package com.tcc.phishing.analysis.domain

import com.tcc.phishing.analysis.domain.enums.PhishingType

data class PhishingRequest(
    val type: PhishingType,
    val content: Any
)