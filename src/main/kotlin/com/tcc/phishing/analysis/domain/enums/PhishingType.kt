package com.tcc.phishing.analysis.domain.enums

import org.webjars.NotFoundException

enum class PhishingType {
    URL;

    companion object {
        fun getValue(value: String) = values().find { it.name == value }
                ?: throw NotFoundException("Value $value is not a PhishingType")
    }
}