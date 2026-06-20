package pl.app.jaz32941nbp.exchangeRate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.app.jaz32941nbp.nbp.NbpService;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepo exchangeRateRepo;
    private final NbpService nbpService;

    @Override
    public ExchangeRateEntity saveExchangeRate(ExchangeRateEntity e) {
        e.setReturnedvalue(nbpService.getAverageRate(e.getWaluta(), e.getStartdate(), e.getEnddate()).doubleValue());
        e.setDate(new Date());
        return exchangeRateRepo.save(e);
    }
}
