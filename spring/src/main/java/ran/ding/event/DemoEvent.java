package ran.ding.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
/**
 * 自定义事件
 * @author maodou38
 *
 */
public class DemoEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private String msg;

	public DemoEvent(Object resource, String msg) {
		super(resource);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg() {
		this.msg = msg;
	}

}
