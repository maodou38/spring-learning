package ran.ding.springmvc.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ran.ding.springmvc.MyMvcConfig;
import ran.ding.springmvc.service.test.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MyMvcConfig.class})
@WebAppConfiguration("src/main/resource")
public class TestControllerInegrationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private TestService testService;
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	MockHttpSession session;
	
	@Autowired
	MockHttpServletRequest request;
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void testNormalController() throws Exception{
		mockMvc.perform(get("/normal")) //perform 执行动作
               .andExpect(status().isOk()) //andExpect 定义运行结果期望
               .andExpect(view().name("page"))
               .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
               .andExpect(model().attribute("msg",testService.saySomething()));
	}
	@Test
	public void testRestController() throws Exception{
		mockMvc.perform(get("/testRest"))
		       .andExpect(status().isOk())
		       .andExpect(content().contentType("text/plain;charset=UTF-8"))
		       .andExpect(content().string(testService.saySomething()));
 	}
	
}
