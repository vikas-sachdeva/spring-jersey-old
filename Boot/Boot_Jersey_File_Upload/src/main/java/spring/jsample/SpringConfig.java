package spring.jsample;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@ComponentScan("spring.jsample.resources")
public class SpringConfig {

	@Bean
	public FilterRegistrationBean jerseyServlet() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new ServletContainer());
		bean.addInitParameter("jersey.config.server.provider.packages", "spring.jsample.resources");
		bean.addInitParameter("jersey.config.server.provider.classnames",
				"org.glassfish.jersey.media.multipart.MultiPartFeature");
		bean.addUrlPatterns("/rest/*");
		/**
		 * Set order of Jersey filter to highest value so that Jersey filter would be
		 * processed first for avoiding "missing start boundary" error during file
		 * upload.
		 */
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return bean;
	}
}