package tobySpring.helloSpring.exrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tobySpring.helloSpring.api.ApiExecutor;
import tobySpring.helloSpring.api.ErApiExRateExtractor;
import tobySpring.helloSpring.api.ExRateExtractor;
import tobySpring.helloSpring.api.SimpleApiExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class WebApiExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return runApiForExRate(url, new SimpleApiExecutor(), new ErApiExRateExtractor());
    }

    private static BigDecimal runApiForExRate(String url, ApiExecutor apiExecutor,
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
