package ran.ding.springmvc.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import ran.ding.springmvc.service.PushService;

@Controller
public class AysncController {
	@Autowired
	PushService pushService;
	
	@RequestMapping("/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall(){
		return pushService.getAsyncUpdate();
	}
}
