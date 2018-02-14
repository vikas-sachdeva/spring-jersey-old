package spring.jsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import spring.jsample.params.SpringParams;

/**
 * 
 * @Configuration annotation will let spring knows that this class contains bean
 *                definitions.
 */
@Configuration
/**
 * 
 * @EnableWebMvc annotation is the same as <mvc:annotation-driven/>
 *
 */
@EnableWebMvc
/**
 * 
 * @ComponentScan annotation is same is
 *                <context:component-scan base-package="spring.jsample" /> line
 *                in XML configuration.
 */
@ComponentScan("spring.jsample")

/**
 * This annotation is for properties file support.
 */
@PropertySource("classpath:config.properties")
public class SpringConfig {

	@Autowired
	 private SpringParams springParams;

	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(springParams.getPrefix());
		resolver.setSuffix(springParams.getSuffix());
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}