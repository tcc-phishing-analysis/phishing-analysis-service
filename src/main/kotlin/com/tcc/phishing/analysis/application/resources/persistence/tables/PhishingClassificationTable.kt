package com.tcc.phishing.analysis.application.resources.persistence.tables

import com.tcc.phishing.analysis.domain.PhishingResponse
import org.springframework.data.domain.Persistable
import java.time.LocalDateTime
import javax.persistence.*
import kotlin.random.Random

@Entity
@Table(name = "phishing_classification")
data class PhishingClassificationTable(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = Random.nextInt(),
        val phishingScore: Float,
        @OneToOne
        @JoinColumn(name = "analysis_content_id")
        val fkAnalysisContent: AnalysisContentTable?,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val updatedAt: LocalDateTime = LocalDateTime.now()
) : Persistable<Int> {

        override fun getId() = id
        override fun isNew() = true

        constructor(phishingResponse: PhishingResponse, analysisContent: AnalysisContentTable) : this (
                phishingScore = phishingResponse.phishingScore,
                fkAnalysisContent = analysisContent
        )

}
