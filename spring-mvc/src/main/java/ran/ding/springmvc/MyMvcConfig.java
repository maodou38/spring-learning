package ran.ding.springmvc;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ran.ding.springmvc.interceptor.DemoInterceptor;
import ran.ding.springmvc.messageconverter.MyMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan("ran.ding.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	//映射静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	//简写实现页面跳转
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");//映射/toUpload到upload页面
		registry.addViewController("/converter").setViewName("/converter");
		registry.addViewController("/sse").setViewName("/sse");
	}
	//确保url中包含.不会产生截取，导致数据断截
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
	
	//文件上传拦截
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}
	/*
	 * 配 置 自 定 义 的 HttpMessageConverter 的 Bean， 在 Spring MVC 里 注 册
	 * HttpMessageConverter 有 两 个 方 法：
	 * configureMessageConverters： 重 载 会 覆 盖 掉 Spring MVC 默 认 注 册 的 多 个 HttpMessageConverter。 
	 * extendMessageConverters： 仅 添 加一 个 自 定 义 的 HttpMessageConverter， 不 覆 盖 默 认 注 册 的 HttpMessageConverter。
	 */
	@Bean
	public MyMessageConverter converter() {
		return new MyMessageConverter();
	}
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		MyMessageConverter converter = converter();
		converters.add(converter);
	}
}
