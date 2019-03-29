package ran.ding.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
/**
 * ①通过@Aspect注解声明一个切面
 * ②通过@Component让此切面成为Spring容器管理的Bean
 * ③通过PointCut注解声明切点
 * ④通过@After注解声明一个建言，并使用@PointCut定义的切点
 * ⑤通过反射可获得注解上的属性，然后做日志记录相关的操作，下面的相同
 * ⑥通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数
 * @author maodou38
 *
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(ran.ding.aop.Action)")
	public void annotationPointCut() {};
	
	
	@Before("annotationPointCut()")
	public void after(JoinPoint joinpoint) {
		MethodSignature signature=(MethodSignature)joinpoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截"+action.name());
	}
	
	@After("execution(* ran.ding.aop.DemoMethodService.*(..))")
	public void before(JoinPoint joinpoint) {
		MethodSignature signature=(MethodSignature)joinpoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截,"+method.getName());
	}
}
