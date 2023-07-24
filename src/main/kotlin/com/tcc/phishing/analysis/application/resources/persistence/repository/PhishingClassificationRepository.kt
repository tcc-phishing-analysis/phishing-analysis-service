package com.tcc.phishing.analysis.application.resources.persistence.repository

import com.tcc.phishing.analysis.application.resources.persistence.tables.PhishingClassificationTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhishingClassificationRepository : JpaRepository<PhishingClassificationTable, Int>