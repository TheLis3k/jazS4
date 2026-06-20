package pl.app.jaz32941nbp.nbp.dto;

import java.math.BigDecimal;
import java.util.List;

public record NbpRatesResponse(String table, String currency, String code, List<Rate> rates) {
    public record Rate(String no, String effectiveDate, BigDecimal mid) {
    }
}
