package com.mp.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class HomeControllerTest {

	@Autowired
	private HomeController homeController;

	@Test
	public void getUsertest() {
		
		String expected = "{\"user\":{\"id\":11569,\"firstName\":\"Jyoti Prakash\",\"age\":23}}";

		String actual = homeController.getUser();

		assertEquals(expected, actual);
	}
	
	
	@Test
	public void loginSuccessProcesstest() {
		
		String expectedloginS="Login Successfully";
		
		String actualloginS = homeController.loginProcess("j@com","12345");
		
		assertEquals(expectedloginS, actualloginS);
		
	}
	
	@Test
	public void loginFailProcesstest() {
		
		String expectedloginF="Use correct Login details";
		
		String actualloginF = homeController.loginProcess("j@com","1");
		assertEquals(expectedloginF, actualloginF);
		
	}


}
