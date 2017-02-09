package almond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AlmondApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmondApplication.class, args);
	}
}
