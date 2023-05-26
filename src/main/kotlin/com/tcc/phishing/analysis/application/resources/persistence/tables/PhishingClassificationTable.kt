package com.tcc.phishing.analysis.application.resources.persistence.tables

import com.tcc.phishing.analysis.domain.PhishingResponse
import org.springframework.data.domain.Persistable
import java.time.LocalDateTime
import javax.persistence.*
import kotlin.random.Random

data class PhishingClassificationTable(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = Random.nextInt(),
        val phishingScore: Float,
        val reasons: List<String>,
        @OneToOne
        val fkAnalysisContent: Int,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val updatedAt: LocalDateTime = LocalDateTime.now()
) : Persistable<Int> {

        override fun getId() = id
        override fun isNew() = true

        constructor(phishingResponse: PhishingResponse, analysisId: Int) : this (
                phishingScore = phishingResponse.phishingScore,
                reasons = phishingResponse.reasons,
                fkAnalysisContent = analysisId
        )

}
