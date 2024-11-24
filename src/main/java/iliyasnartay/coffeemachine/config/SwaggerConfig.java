package iliyasnartay.coffeemachine.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Coffee Machine API")
                        .version("1.0")
                        .description("API для управления кофемашиной")
                        .contact(new Contact()
                                .name("Iliyas Nartay")
                                .email("iliyas.nartay@example.com")
                                .url("https://example.com")));
    }
}
