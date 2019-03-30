package ran.ding.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Spring 提供的Aware接口 BeanNameAware 获得到容器中Bean的名称 BeanFactoryAware 获得当前bean
 * factory,这样可以调用容器的服务 ApplicationContextAware 获得当前application
 * context,这样可以调用容器的服务 MessageSourceAware 获得message name，这样可以获得文本信息
 * ApplicationEventPublisherAware 应用事件发布器，可以发布事件 ResourceLoaderAware
 * 获得资源加载器，可以获得外部资源文件
 * 
 * @author maodou38
 *
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

	private String beanName;
	private ResourceLoader loader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void outputResult() {
		System.out.println(" Bean 的 名 称 为：" + beanName);
		Resource resource = loader.getResource("classpath:ran/ding/aware/resource.txt");
		try {
			System.out.println(" ResourceLoader 加 载 的 文 件 内 容 为: " + IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
