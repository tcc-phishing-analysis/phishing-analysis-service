package com.tcc.phishing.analysis.application.resources.persistence.tables

import com.tcc.phishing.analysis.domain.PhishingResponse
import org.springframework.data.domain.Persistable
import java.time.LocalDateTime
import javax.persistence.*
import kotlin.random.Random

@Entity
@Table(name = "phishing_classification")
data class PhishingClassificationTable(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,
        val phishingScore: Int,
        // TODO: validar como incluir esse campo no BD e como adicionar fk sem que dê esse pra subir a aplicação
        //@OneToOne
        //@JoinColumn(name = "analysis_content_id")
        //val fkAnalysisContent: AnalysisContentTable?,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val updatedAt: LocalDateTime = LocalDateTime.now()
)
