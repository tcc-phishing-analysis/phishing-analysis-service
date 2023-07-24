package com.tcc.phishing.analysis.application.resources

import com.tcc.phishing.analysis.application.config.S3PCAAnalysisProperties
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.springframework.stereotype.Service

@Service
class S3Resources(
        private val bucketProperties: S3PCAAnalysisProperties
) {

     fun readFile(): Dataset<Row> {

          val spark = SparkSession.builder()
                  .appName("S3 to DataFrame Example")
                  .master("local")
                  .getOrCreate();

          var df: Dataset<Row> = spark.read()
                  .option("header", "true")
                  .csv("s3a://" + bucketProperties.bucketName + "/" + bucketProperties.fileName)

          df.show()

          spark.stop()

          return df
     }
}