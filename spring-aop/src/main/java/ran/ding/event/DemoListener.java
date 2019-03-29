package ran.ding.event;

import org.springframework.context.ApplicationListener;

public class DemoListener implements ApplicationListener<DemoEvent>{

	@Override
	public void onApplicationEvent(DemoEvent event) {
		String msg=event.getMsg();
		System.out.println("我(bean-demoListener)接收到了bean-demoPublisher发布的消息:"+msg);
	}

}
