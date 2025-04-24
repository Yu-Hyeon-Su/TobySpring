package tobySpring.helloSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobySpring.helloSpring.exrate.ExRateProvider;
import tobySpring.helloSpring.exrate.WebApiExRateProvider;
import tobySpring.helloSpring.payment.ExRateProviderStub;
import tobySpring.helloSpring.payment.PaymentService;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration
public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }

    @Bean
    public Clock clock() {
        return Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }
}
