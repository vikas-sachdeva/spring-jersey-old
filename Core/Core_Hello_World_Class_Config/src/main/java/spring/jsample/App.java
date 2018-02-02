package spring.jsample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.jsample.beans.HelloWorld;
import spring.jsample.config.ApplicationConfig;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		/*
		 * Parameter passed to context.getBean() method should be same as the name
		 * attribute value in @Bean annotation applied on method in spring class
		 * configuration file.
		 * 
		 */
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		context.close();
	}
}
