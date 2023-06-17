package com.tcc.phishing.analysis.application.resources.persistence.tables

import com.tcc.phishing.analysis.domain.PhishingRequest
import com.tcc.phishing.analysis.domain.enums.PhishingType
import java.time.LocalDateTime

import kotlin.random.Random

data class AnalysisContentTable(
        val id: Int = Random.nextInt(),
        val type: PhishingType,
        val content: Map<String, Any>,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val updatedAt: LocalDateTime = LocalDateTime.now()
) {

        constructor(phishingRequest: PhishingRequest) : this (
                type = phishingRequest.type,
                content = phishingRequest.content as Map<String, Any>
        )
}
