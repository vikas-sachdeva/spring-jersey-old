package spring.jsample.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.jsample.util.ProjectConstants;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {

		MultipartConfigElement multiPart = new MultipartConfigElement(ProjectConstants.UPLOAD_DIR_TEMP_PATH,
				1024 * 1024 * 10, 1024 * 1024 * 10, 1024 * 1024 * 3);

		registration.setMultipartConfig(multiPart);
	}

}