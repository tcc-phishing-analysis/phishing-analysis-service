package com.tcc.phishing.analysis.application.services

import com.tcc.phishing.analysis.application.interfaces.PhishingStrategy
import com.tcc.phishing.analysis.domain.PhishingRequest
import com.tcc.phishing.analysis.domain.PhishingResponse

class PhishingEmailService : PhishingStrategy {

    override fun getPhishingScore(phishingRequest: PhishingRequest): PhishingResponse {
        return TODO("Not yet implemented")
    }
}