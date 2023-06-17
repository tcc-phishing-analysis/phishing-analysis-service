package com.tcc.phishing.analysis.application.resources.persistence.repository

import com.tcc.phishing.analysis.application.resources.persistence.tables.PhishingClassificationTable
import org.springframework.data.jpa.repository.JpaRepository

interface PhishingClassificationRepository : JpaRepository<PhishingClassificationTable, Int>