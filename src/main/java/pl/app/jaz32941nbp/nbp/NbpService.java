package pl.app.jaz32941nbp.nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pl.app.jaz32941nbp.nbp.dto.NbpRatesResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class NbpService {

    private final RestClient client = RestClient.create("http://api.nbp.pl/api");

    public List<NbpRatesResponse.Rate> getRates(String code, LocalDate from, LocalDate to) {
        try {
            NbpRatesResponse response = fetch(code, from, to);
            if (response == null || response.rates() == null) {
                return List.of();
            }
            return response.rates();
        } catch (Exception e) {
            return List.of();
        }
    }

    public BigDecimal getAverageRate(String code, LocalDate from, LocalDate to) {
        try {
            NbpRatesResponse response = fetch(code, from, to);
            if (response == null || response.rates() == null || response.rates().isEmpty()) {
                return BigDecimal.ZERO;
            }
            List<NbpRatesResponse.Rate> rates = response.rates();
            BigDecimal sum = rates.stream().map(NbpRatesResponse.Rate::mid).reduce(BigDecimal.ZERO, BigDecimal::add);
            return sum.divide(BigDecimal.valueOf(rates.size()), 4, RoundingMode.HALF_UP);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    private NbpRatesResponse fetch(String code, LocalDate from, LocalDate to) {
        return client.get()
                .uri("/exchangerates/rates/a/{code}/{from}/{to}/?format=json", code, from, to)
                .retrieve()
                .body(NbpRatesResponse.class);
    }
}
