package ran.ding.springmvc.service.test;
/**
 * 用于测试的service
 * @author maodou38
 *
 */

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public String saySomething() {
		return "hello";
	}
}
