package spring.jsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.jsample.params.JdbcParams;

@Controller
public class ValueController {

	@Autowired
	private JdbcParams jdbcParams;

	@RequestMapping(value = { "/", "/value" })
	public String values(Model model) {

		model.addAttribute("driverClassName", jdbcParams.getDbDriverClassName());
		model.addAttribute("url", jdbcParams.getDbUrl());
		model.addAttribute("username", jdbcParams.getDbUsername());
		model.addAttribute("password", jdbcParams.getDbPassword());

		return "value";

	}
}