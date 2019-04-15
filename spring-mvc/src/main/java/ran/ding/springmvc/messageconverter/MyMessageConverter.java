package ran.ding.springmvc.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import ran.ding.springmvc.entity.DemoObj;

/**
 * HttpMessageConverter 是 用 来 处 理 request 和 response 里 的 数 据 的。 Spring 为 我 们 内 置
 * 了 大 量 的 HttpMessageConverter， 例 如， MappingJackson2HttpMessageConverter、
 * StringHttpMessage Converter 等。
 * 
 * @author maodou38
 *
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConverter() {//新建一个我们自定义的媒体类型applicaiton/x-wisely
		super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
	}
    //这个Converter只处理DemoObj这个类
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}

	@Override
	protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out="hello:"+obj.getId()+"-"+obj.getName();
		outputMessage.getBody().write(out.getBytes());
	}

}
