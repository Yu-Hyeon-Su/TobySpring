package tobySpring.helloSpring.payment;

import tobySpring.helloSpring.exrate.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

 public class PaymentService {
     private final ExRateProvider exRateProvider;
     private final Clock clock;

     public PaymentService(ExRateProvider exRateProvider, Clock clock) {
         this.exRateProvider = exRateProvider;
         this.clock = clock;
     }

     public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) {
        BigDecimal exRate = exRateProvider.getExRate(currency);

        return Payment.createPrepared(orderId, currency, exRate, foreignCurrencyAmount, LocalDateTime.now(clock));
    }
}
