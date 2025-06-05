package tobySpring.helloSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tobySpring.helloSpring.api.ApiTemplate;
import tobySpring.helloSpring.api.ErApiExtractor;
import tobySpring.helloSpring.api.SimpleApiExecutor;
import tobySpring.helloSpring.exrate.ExRateProvider;
import tobySpring.helloSpring.exrate.RestTemplateExRateProvider;
import tobySpring.helloSpring.exrate.WebApiExRateProvider;
import tobySpring.helloSpring.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
