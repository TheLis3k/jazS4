package pl.app.jaz32941nbp.exchangeRate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.app.jaz32941nbp.exchangeRate.ExchangeRateEntity;


@Repository
public interface ExchangeRateRepo extends CrudRepository<ExchangeRateEntity, Long> {

}
