package ran.ding.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value=Exception.class)//用于全局处理控制器里的异常
	public ModelAndView exception(Exception exception,WebRequest request) {
		ModelAndView modelAndView =new ModelAndView("error");
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
	@ModelAttribute//绑定键值对到Model中
	public void addAttributes(Model model) {
		model.addAttribute("msg","额外信息");
	}
	@InitBinder//设置WebDataBinder ,用于自动绑定前台请求参数到Model中
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
	}
}
