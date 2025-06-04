package tobySpring.helloSpring.api;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiTemplate {
    public BigDecimal getExRate(String url, ApiExecutor apiExecutor,
                                ExRateExtractor exRateExtractor) {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String body;
        try {
            body = apiExecutor.execute(uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return exRateExtractor.extract(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
