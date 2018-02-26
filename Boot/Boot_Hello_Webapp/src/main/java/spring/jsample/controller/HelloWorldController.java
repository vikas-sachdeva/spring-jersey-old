package spring.jsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping(value = { "/getIp" }, method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String getIpAddress(HttpServletRequest request) {
		String ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");

		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}
}