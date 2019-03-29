package ran.ding.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ran.ding.aop.AopConfig;
import ran.ding.aop.DemoAnnotationService;
import ran.ding.aop.DemoMethodService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		demoPublisher.publish("hello application event");
		context.close();
	}
}
