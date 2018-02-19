package spring.jsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.jsample.beans.CommandHandler;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

	@Autowired
	private CommandHandler commandHandler;

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringBootApp.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandHandler.execute(args);
	}
}