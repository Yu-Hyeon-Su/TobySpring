package tobySpring.helloSpring.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tobySpring.helloSpring.exrate.ExRateData;

import java.math.BigDecimal;

public class ErApiExtractor implements ExRateExtractor{
    @Override
    public BigDecimal extract(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(body, ExRateData.class);
        return data.rates().get("KRW");
    }
}
