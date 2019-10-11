package com.techprimers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techprimers.controller.UsersController;
import com.techprimers.model.User;
import com.techprimers.repository.UserJpaRespository;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class SpringBootDemoApplicationTests {
	private User user;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserJpaRespository userJpaRespository;
	
	@Before
	public void setUp()
	{
		user = new User();
		user.setId(1l);
		user.setFirstname("Virat");
		user.setLastname("RCB");
		user.setOccupation("Hello");
		user.setProfilepicture("http://sda.asd");
	}

	@Test
	public void findAllUsersTest() throws Exception {
		List<User> users = new ArrayList<>();
		users.add(user);

		when(userJpaRespository.findAll()).thenReturn(users);

		MvcResult result = mockMvc.perform(get("/users/all")).andExpect(status().isOk()).andReturn();
		JSONAssert.assertEquals(new ObjectMapper().writeValueAsString(users),
								result.getResponse().getContentAsString(), false);
	}

}
