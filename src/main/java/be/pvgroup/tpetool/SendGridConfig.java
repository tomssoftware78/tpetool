package be.pvgroup.tpetool;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class SendGridConfig {

    @Value("${spring.sendgrid.api-key}")
    String sendGridAPIKey;

    @Bean
    public SendGrid sendGrid() {
        return new SendGrid(sendGridAPIKey);
    }
}
