package ran.ding.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ran.ding.springmvc.entity.DemoObj;

@Controller
public class AdviceController {
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg,DemoObj obj) {
		throw new IllegalArgumentException("非常抱歉，参数有误/来自@ModelAttribute："+msg);
	}
}
