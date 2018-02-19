package spring.jsample;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.jsample.resources")
public class SpringConfig {

	@Bean
	public FilterRegistrationBean jerseyServlet() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new ServletContainer());
		bean.addInitParameter("jersey.config.server.provider.packages", "spring.jsample.resources");
		bean.addUrlPatterns("/rest/*");
		return bean;
	}
}