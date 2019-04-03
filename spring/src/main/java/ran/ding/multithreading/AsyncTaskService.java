package ran.ding.multithreading;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void executeAsynTask(Integer i) {
		System.out.println("执  行 异 步 任 务 :" + i);
	}

	@Async
	public void executeAsynTaskPlus(Integer i) {
		System.out.println("执  行 异 步 任 务+1 :" + (i + 1));
	}
}
