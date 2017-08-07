package com.mp.spring;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mp.spring.model.Customer;
import com.mp.spring.model.User;
import com.mp.spring.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "HomeControllerApi")
@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Gets a User detail", response = User.class)
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getUser() {

		String value = "";

		User u = userService.get();

		ObjectMapper m = new ObjectMapper();
		Map<String, Object> props = m.convertValue(u, Map.class);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement jsonTree = gson.toJsonTree(props, Map.class);
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.add("user", jsonTree);
		value = jsonObject1.toString();
		return value;

	}

	@ApiOperation(value = "Redirect to the Login Page")
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
	public String login(Model model) {
		return "home";

	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "email", value = "User's Email", required = true, dataType = "string"),
			@ApiImplicitParam(name = "password", value = "User's Password", required = true, dataType = "string") })

	@ApiOperation(value = "To Process the login request")
	@ResponseBody
	@RequestMapping(value = "/loginprocess", method = RequestMethod.GET, produces = "application/json")
	public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password) {
		Customer c = userService.login();

		if (email.equals(c.getC_email()) && password.equals(c.getC_password())) {
			return "Login Successfully";
		}

		return "Use correct Login details";

	}

}
