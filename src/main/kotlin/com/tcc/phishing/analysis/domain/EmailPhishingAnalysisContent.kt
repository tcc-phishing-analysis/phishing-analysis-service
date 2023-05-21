package com.tcc.phishing.analysis.domain

import java.time.LocalDateTime

data class EmailPhishingAnalysisContent(
        val id: String,
        val from: String,
        //Criar objeto com nome de usuário e email
        val cc: List<String>,
        val subject: String,
        val body: String,
        val hasAttachment: Boolean,
        val dateTime: LocalDateTime,
        val isSpam: Boolean
): PhishingAnalysisContent