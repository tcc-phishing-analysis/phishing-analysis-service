package com.tcc.phishing.analysis.application.resources.persistence.repository

import com.tcc.phishing.analysis.application.resources.persistence.tables.AnalysisContentTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnalysisContentRepository : JpaRepository<AnalysisContentTable, Int>