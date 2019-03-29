package ran.ding.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * springboot内置事件：
 * ApplicationStartingEvent
 * ApplicationEnvironmentPreparedEvent
 * ApplicationPreparedEvent
 * ApplicationStartedEvent
 * ApplicationReadyEvent
 * ApplicationFailedEvent
 * 
 * 
 * @author maodou38
 *
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(EventConfig.class);
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		demoPublisher.publish("hello application event");
		context.close();
	}
}
