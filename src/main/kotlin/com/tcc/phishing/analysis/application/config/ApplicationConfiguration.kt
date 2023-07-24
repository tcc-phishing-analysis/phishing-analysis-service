package com.tcc.phishing.analysis.application.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(
        AwsProperties::class,
        S3PCAAnalysisProperties::class
)
class ApplicationConfiguration

@ConstructorBinding
@ConfigurationProperties(prefix = "aws")
class AwsProperties(
    val accessKeyId: String,
    val secretAccessKey: String
)

@ConstructorBinding
@ConfigurationProperties(prefix = "s3")
class S3PCAAnalysisProperties(
    val fileName: String,
    val bucketName: String
)



