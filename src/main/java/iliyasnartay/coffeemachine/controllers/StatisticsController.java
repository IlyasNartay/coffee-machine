package iliyasnartay.coffeemachine.controllers;

import iliyasnartay.coffeemachine.dto.StatisticsDTO;
import iliyasnartay.coffeemachine.services.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    // Fetch statistics for a specific coffee on a specific date
    @GetMapping("/coffee/{coffeeId}/date/{date}")
    public ResponseEntity<StatisticsDTO> getStatistics(@PathVariable Long coffeeId, @PathVariable String date) {
        Optional<StatisticsDTO> statisticsDTO = statisticsService.getStatistics(coffeeId, LocalDate.parse(date));
        return statisticsDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Save statistics
    @PostMapping
    public ResponseEntity<StatisticsDTO> saveStatistics(@RequestBody StatisticsDTO statisticsDTO) {
        return ResponseEntity.ok(statisticsService.saveStatistics(statisticsDTO));
    }
}
