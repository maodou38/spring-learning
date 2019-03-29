package ran.ding.aop;

import org.springframework.stereotype.Service;
/**
 * 使用注解的被拦截类
 * @author maodou38
 *
 */
@Service
public class DemoAnnotationService {
	@Action(name="注解式拦截的add操作")
	public void add() {
		System.out.println("我是注解式拦截的add操作");
	};
	
}
