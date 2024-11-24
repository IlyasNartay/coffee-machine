package iliyasnartay.coffeemachine.controllers;

import iliyasnartay.coffeemachine.dto.HolidayCacheDTO;
import iliyasnartay.coffeemachine.services.HolidayCacheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/holidays")
public class HolidayCacheController {
    private final HolidayCacheService holidayCacheService;

    public HolidayCacheController(HolidayCacheService holidayCacheService) {
        this.holidayCacheService = holidayCacheService;
    }

    // Fetch holiday by date and country code
    @GetMapping("/date/{date}/country/{countryCode}")
    public ResponseEntity<HolidayCacheDTO> getHolidayByDateAndCountryCode(
            @PathVariable String date,
            @PathVariable String countryCode) {
        Optional<HolidayCacheDTO> holidayCacheDTO = holidayCacheService.getHolidayByDateAndCountryCode(LocalDate.parse(date), countryCode);
        return holidayCacheDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Save a holiday
    @PostMapping
    public ResponseEntity<HolidayCacheDTO> saveHoliday(@RequestBody HolidayCacheDTO holidayCacheDTO) {
        return ResponseEntity.ok(holidayCacheService.saveHoliday(holidayCacheDTO));
    }
}
