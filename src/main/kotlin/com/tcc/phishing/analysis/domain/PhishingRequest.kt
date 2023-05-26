package com.tcc.phishing.analysis.domain

import com.tcc.phishing.analysis.domain.enums.PhishingType
import javax.validation.constraints.NotNull

data class PhishingRequest(
        val type: PhishingType,
        val content: @NotNull Any
)