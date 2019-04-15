package ran.ding.springmvc.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ran.ding.springmvc.service.test.TestService;

@RestController
public class MyRestRestController {
	@Autowired
	TestService testService;
	
	@RequestMapping(value="/testRest",produces="text/plain;charset=UTF-8")
	public String testPage(Model model) {
		return testService.saySomething();
	}
}
