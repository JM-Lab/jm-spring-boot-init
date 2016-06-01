package kr.jm.springboot;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import kr.jm.springboot.JMSpringBootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JMSpringBootApplication.class)
@WebAppConfiguration
public class JMSpringBootApplicatonTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void test() throws Exception {
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.get("/info");
		ResultActions resultActions = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
		assertTrue(resultActions.andReturn().getResponse().getContentAsString()
				.contains(webApplicationContext.getEnvironment()
						.getProperty("info.app.name")));
	}

	@Test
	public void testErrorList() throws Exception {
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.get("/ops/error");
		ResultActions resultActions = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
		String contentAsString =
				resultActions.andReturn().getResponse().getRedirectedUrl();
		assertTrue(contentAsString.equals("/ops/ErrorMessageView.html"));

		requestBuilder = MockMvcRequestBuilders.get("/ops/error/list");
		resultActions = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk());
		assertTrue(resultActions.andReturn().getResponse().getContentType()
				.equals("application/json;charset=UTF-8"));
		String contentAsString2 =
				resultActions.andReturn().getResponse().getContentAsString();
		assertTrue(contentAsString2.contains("[]"));
	}

}
