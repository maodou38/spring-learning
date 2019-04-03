package ran.ding.multithreading;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ran.ding.event.DemoPublisher;
import ran.ding.event.EventConfig;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(TaskExectorConfig.class);
		AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
		for(int i=0;i<10;i++) {
			asyncTaskService.executeAsynTask(i);
			asyncTaskService.executeAsynTaskPlus(i);
		}
		context.close();
	}
}
