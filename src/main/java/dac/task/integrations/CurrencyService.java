package dac.task.integrations;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyService {

    final static String NBP_URL = "https://api.nbp.pl";
    final static String RATES_ENDPOINT = "/api/exchangerates/rates/A/EUR";

    public Integer convertToPln(Integer amountInCents) {
        RateResponse rateResponse = WebClient.create(NBP_URL)
                .get()
                .uri(RATES_ENDPOINT)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(RateResponse.class)
                .block();

        if (rateResponse == null) {
            return null;
        }

        return amountInCents * rateResponse.findRate();
    }
}
