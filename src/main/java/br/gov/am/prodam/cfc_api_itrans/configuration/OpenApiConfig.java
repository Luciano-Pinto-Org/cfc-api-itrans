package br.gov.am.prodam.cfc_api_itrans.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class OpenApiConfig {
    @Bean
    public OpenAPI cfcApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CFC API Itrans")
                        .description("CFC API para Itrans")
                        .version("1.0"));

    }
}
