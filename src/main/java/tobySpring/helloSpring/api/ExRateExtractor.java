package tobySpring.helloSpring.api;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

public interface ExRateExtractor {
    BigDecimal extract(String body) throws JsonProcessingException;
}
