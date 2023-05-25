import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "aws")
class AwsProperties {
    lateinit var accessKeyId: String
    lateinit var secretAccessKey: String
}

@Component
@ConfigurationProperties(prefix = "s3")
class S3PCAAnalysisProperties {
    lateinit var fileName: String
    lateinit var bucketName: String
}



