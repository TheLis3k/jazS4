package pl.app.jaz32941nbp.exchangeRate;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExchangeRateController {

    @Autowired private ExchangeRateService exchangeRateService;

    @PostMapping("/exchangeRates")
    public ExchangeRateEntity exchangeRateEntity(
            @Valid @RequestBody ExchangeRateEntity exchangeRateEntity)
    {
        return exchangeRateService.saveExchangeRate(exchangeRateEntity);
    }

}