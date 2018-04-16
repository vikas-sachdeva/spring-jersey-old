package spring.jsample.spark;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spark.Spark;

@Configuration
public class SparkConfiguration {

	@Autowired(required = false)
	private List<SparkResource> sparkResources = new ArrayList<>();

	@Bean
	CommandLineRunner sparkRunner() {
		Spark.staticFileLocation("/webapp");
		Spark.redirect.get("/", "index.html");
		return args -> sparkResources.stream().forEach(spark -> spark.register());
	}
}
