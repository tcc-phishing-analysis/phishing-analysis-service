package com.tcc.phishing.analysis.domain.exception

data class GenericException(
        override val message: String?
) : RuntimeException()
