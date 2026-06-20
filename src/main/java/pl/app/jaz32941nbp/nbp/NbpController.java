package pl.app.jaz32941nbp.nbp;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.app.jaz32941nbp.nbp.dto.NbpRatesResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exchange-rates")
public class NbpController {

    private final NbpService service;

    public NbpController(NbpService service) {
        this.service = service;
    }

    @GetMapping("/{code}/average")
    public Map<String, Object> average(
            @PathVariable String code,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return Map.of("code", code.toUpperCase(), "from", from, "to", to,
                "averageMid", service.getAverageRate(code, from, to));
    }
}
