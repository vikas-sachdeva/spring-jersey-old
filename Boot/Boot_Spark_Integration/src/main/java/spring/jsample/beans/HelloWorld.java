package spring.jsample.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return "hello " + name;

	}
}
