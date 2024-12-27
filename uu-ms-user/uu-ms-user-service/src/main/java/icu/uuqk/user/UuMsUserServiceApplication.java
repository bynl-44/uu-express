package icu.uuqk.user;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "用户微服务 API 文档",
                description = "用户微服务 API 文档",
                version = "1.0.0",
                contact = @Contact(
                        name = "gaoshuqing",
                        email = "shuqing.gao@qq.com",
                        url = ""
                )

        ),
        externalDocs = @ExternalDocumentation(
                description = "用户微服务 API 文档",
                url = "http://localhost:8080/swagger-ui.html"
        )
)
public class UuMsUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UuMsUserServiceApplication.class, args);
    }

}
