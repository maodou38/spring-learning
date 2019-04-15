package ran.ding.springmvc.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ran.ding.springmvc.service.test.TestService;
@Controller
public class NormalController {
	@Autowired
	TestService testService;
	
	@RequestMapping("/normal")
	public String testPage(Model model) {
		model.addAttribute("msg", testService.saySomething());
		return "page";
	}
}
