package com.tcc.phishing.analysis.application.interfaces

import com.tcc.phishing.analysis.domain.PhishingRequest
import com.tcc.phishing.analysis.domain.PhishingResponse

interface PhishingStrategy {

    fun getPhishingScore(phishingRequest: PhishingRequest): PhishingResponse
}