package ran.ding.aop;

import org.springframework.stereotype.Service;
/**
 * 使用方法规则拦截的被拦截类
 * @author maodou38
 *
 */
@Service
public class DemoMethodService {
	public void add() {
		System.out.println("我是使用方法规则拦截的add操作");
	};
	
}
