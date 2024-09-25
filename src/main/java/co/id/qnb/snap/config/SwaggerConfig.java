package co.id.qnb.snap.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
            title = "QNB SNAP BI",
            version = "1.0",
            description = "Standar Nasional Open API Pembayaran QNB",
            contact = @Contact(
                name = "QNB Support",
                url = "https://www.qnb.co.id/contact",
                email = "support@qnb.co.id"
            )
    )
)
public class SwaggerConfig {

}
