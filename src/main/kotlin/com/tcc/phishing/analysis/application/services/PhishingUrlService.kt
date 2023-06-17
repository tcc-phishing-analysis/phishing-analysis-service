package com.tcc.phishing.analysis.application.services

import com.tcc.phishing.analysis.application.interfaces.PhishingStrategy
import com.tcc.phishing.analysis.application.resources.persistence.repository.AnalysisContentRepository
import com.tcc.phishing.analysis.application.resources.persistence.repository.PhishingClassificationRepository
import com.tcc.phishing.analysis.application.resources.persistence.tables.AnalysisContentTable
import com.tcc.phishing.analysis.application.resources.persistence.tables.PhishingClassificationTable
import com.tcc.phishing.analysis.domain.PhishingRequest
import com.tcc.phishing.analysis.domain.PhishingResponse

class PhishingUrlService (
        private val analysisContentRepository: AnalysisContentRepository,
        private val phishingClassificationRepository: PhishingClassificationRepository,
): PhishingStrategy {

    override fun getPhishingScore(phishingRequest: PhishingRequest): PhishingResponse {
        val analysisContent = analysisContentRepository.save(AnalysisContentTable(phishingRequest))

        return PhishingResponse(0.1.toFloat(), listOf()).also {
            phishingClassificationRepository.save(
                    PhishingClassificationTable(
                            phishingResponse = it,
                            analysisId = analysisContent.id
                    )
            )
        }
    }

    private fun preProcessing() {
        TODO("Limpeza, normalização, etc..")
    }

    private fun applyPca() {
        TODO()
    }

    private fun getUrlClassification() {}
}