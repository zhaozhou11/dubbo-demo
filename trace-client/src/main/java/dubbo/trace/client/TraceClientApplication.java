package dubbo.trace.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="dubbo.trace.client")
public class TraceClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(TraceClientApplication.class, args);
	}

}

