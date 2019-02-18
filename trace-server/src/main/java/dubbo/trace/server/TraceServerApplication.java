package dubbo.trace.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dubbo.trace.server.config")
public class TraceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceServerApplication.class, args);
	}

}

