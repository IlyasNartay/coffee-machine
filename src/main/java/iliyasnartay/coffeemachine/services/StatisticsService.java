package iliyasnartay.coffeemachine.services;

import iliyasnartay.coffeemachine.dto.StatisticsDTO;
import iliyasnartay.coffeemachine.models.Statistics;
import iliyasnartay.coffeemachine.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    // Get statistics for a specific coffee on a specific date
    public Optional<StatisticsDTO> getStatistics(Long coffeeId, LocalDate date) {
        return statisticsRepository.findByCoffeeIdAndDate(coffeeId, date)
                .map(this::mapToDTO);
    }

    // Save statistics
    public StatisticsDTO saveStatistics(StatisticsDTO statisticsDTO) {
        Statistics statistics = mapToEntity(statisticsDTO);
        Statistics savedStatistics = statisticsRepository.save(statistics);
        return mapToDTO(savedStatistics);
    }

    // Mapping methods
    private StatisticsDTO mapToDTO(Statistics statistics) {
        return new StatisticsDTO.Builder()
                .setId(statistics.getId())
                .setCoffeeId(statistics.getCoffee().getId())
                .setDate(statistics.getDate())
                .setCount(statistics.getCount())
                .build();
    }

    private Statistics mapToEntity(StatisticsDTO statisticsDTO) {
        Statistics statistics = new Statistics();
        statistics.setId(statisticsDTO.getId());
        statistics.setDate(statisticsDTO.getDate());
        statistics.setCount(statisticsDTO.getCount());
        return statistics;
    }
}
