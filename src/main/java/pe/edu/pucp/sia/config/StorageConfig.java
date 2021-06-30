package pe.edu.pucp.sia.config;


import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    public AmazonS3 generateS3client(){
        return AmazonS3ClientBuilder.standard().withCredentials(new InstanceProfileCredentialsProvider(false)).build();
    }
}