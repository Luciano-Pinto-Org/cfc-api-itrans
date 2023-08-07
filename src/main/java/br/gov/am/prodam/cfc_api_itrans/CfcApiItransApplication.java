package br.gov.am.prodam.cfc_api_itrans;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableConfigurationProperties
//@EnableCaching
//@EnableSwagger2
@EnableAsync
@Log4j2
public class CfcApiItransApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfcApiItransApplication.class, args);
    }

}
