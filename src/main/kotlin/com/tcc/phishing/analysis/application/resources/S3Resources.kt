package com.tcc.phishing.analysis.application.resources

import S3PCAAnalysisProperties
import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.*
import aws.smithy.kotlin.runtime.content.writeToFile
import java.io.File
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

class S3Resources(
        private val bucketProperties: S3PCAAnalysisProperties
) {

     private val bucketName = bucketProperties.bucketName
     private val fileName = bucketProperties.fileName
     fun readFile():Dataset<Row> {

          // Configurar a sessão Spark
          val spark = SparkSession.builder()
                  .appName("S3 to DataFrame Example")
                  .master("local")
                  .getOrCreate();

          // Ler o arquivo CSV do Amazon S3
          var df: Dataset<Row> = spark.read()
                  .option("header", "true")
                  .csv("s3a://" + bucketName + "/" + fileName);

          df.show()

          spark.stop()

          return df
     }
}