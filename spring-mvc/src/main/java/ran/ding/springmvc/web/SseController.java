package ran.ding.springmvc.web;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SseController {
	/**
	 * 这里使用的媒体类型为text/event-stream,这是服务器端SSE的支持，本例演示每5秒向浏览器推送随机信息
	 * @return
	 */
	@RequestMapping(value="/push",produces="text/event-stream;charset=UTF-8")//默认是ISO-8859-1，需要明确编码格式
	public @ResponseBody String push() {                                     //尝试全局修改StringHttpMessageConverter为UTF-8，无效
		Random r=new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "data:Testng 1,2,3"+r.nextInt()+"\n\n";
	}
}
