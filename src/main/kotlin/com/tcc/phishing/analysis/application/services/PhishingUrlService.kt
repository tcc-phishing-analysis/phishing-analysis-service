package com.tcc.phishing.analysis.application.services

import com.tcc.phishing.analysis.application.interfaces.PhishingInterface
import com.tcc.phishing.analysis.domain.PhishingRequest
import com.tcc.phishing.analysis.domain.PhishingResponse
import com.tcc.phishing.analysis.domain.enums.PhishingType

class PhishingUrlService : PhishingInterface{

    override fun getPhishingScore(phishingRequest: PhishingRequest): PhishingResponse {
        TODO("Not yet implemented")
    }
}