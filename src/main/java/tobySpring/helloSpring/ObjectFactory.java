package tobySpring.helloSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobySpring.helloSpring.exrate.CachedExRateProvider;
import tobySpring.helloSpring.exrate.ExRateProvider;
import tobySpring.helloSpring.exrate.WebApiExRateProvider;
import tobySpring.helloSpring.payment.PaymentService;

@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider());
    }

    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
