package tobySpring.helloSpring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tobySpring.helloSpring.exrate.WebApiExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가지를 잘 충족했는지 검증")
    void prepare() throws IOException {
        testAmount(valueOf(500), valueOf(5_000));
        testAmount(valueOf(1_000), valueOf(10_000));
        testAmount(valueOf(3_000), valueOf(30_000));

//        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }

    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate));

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
    }
}