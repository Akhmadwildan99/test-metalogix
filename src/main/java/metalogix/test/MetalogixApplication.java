package metalogix.test;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API documentation test metalogix",
				version = "1.0.0",
				description = "Test project documentation"
		)
)
//@EnableSwagger2
public class MetalogixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetalogixApplication.class, args);
	}


}
