package iliyasnartay.coffeemachine.services;

import iliyasnartay.coffeemachine.dto.HolidayCacheDTO;
import iliyasnartay.coffeemachine.models.HolidayCache;
import iliyasnartay.coffeemachine.repositories.HolidayCacheRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class HolidayCacheService {
    private final HolidayCacheRepository holidayCacheRepository;

    public HolidayCacheService(HolidayCacheRepository holidayCacheRepository) {
        this.holidayCacheRepository = holidayCacheRepository;
    }

    // Fetch holiday by date and country code
    public Optional<HolidayCacheDTO> getHolidayByDateAndCountryCode(LocalDate date, String countryCode) {
        return holidayCacheRepository.findByDateAndCountryCode(date, countryCode)
                .map(this::mapToDTO);
    }

    // Save a holiday
    public HolidayCacheDTO saveHoliday(HolidayCacheDTO holidayCacheDTO) {
        HolidayCache holidayCache = mapToEntity(holidayCacheDTO);
        HolidayCache savedHoliday = holidayCacheRepository.save(holidayCache);
        return mapToDTO(savedHoliday);
    }

    // Mapping methods
    private HolidayCacheDTO mapToDTO(HolidayCache holidayCache) {
        return new HolidayCacheDTO.Builder()
                .setId(holidayCache.getId())
                .setDate(holidayCache.getDate())
                .setCountryCode(holidayCache.getCountryCode())
                .setDescription(holidayCache.getDescription())
                .build();
    }

    private HolidayCache mapToEntity(HolidayCacheDTO holidayCacheDTO) {
        HolidayCache holidayCache = new HolidayCache();
        holidayCache.setId(holidayCacheDTO.getId());
        holidayCache.setDate(holidayCacheDTO.getDate());
        holidayCache.setCountryCode(holidayCacheDTO.getCountryCode());
        holidayCache.setDescription(holidayCacheDTO.getDescription());
        return holidayCache;
    }
}
