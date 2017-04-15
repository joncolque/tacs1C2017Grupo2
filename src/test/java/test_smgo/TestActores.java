package test_smgo;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import model.Actor;
import repos.RepoActores;
import tacs.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class TestActores {

	@Autowired
	private WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		RepoActores.getInstance().addActor(new Actor("Tom Cruise","Tom Cruise biography", 50, "New York, USA", new Date(30, 10, 1950).toString(), "Tom Cruise Image"));
		RepoActores.getInstance().addActor(new Actor("Jeremy Renner","Jeremy Renner biography", 42, "New Jersey, USA", new Date(15, 8, 1958).toString(), "Jeremy Renner Image"));
		RepoActores.getInstance().addActor(new Actor("Ricardo Darin","Ricardo Darin biography", 53, "Buenos Aires, ARG", new Date(3, 3, 1947).toString(), "Ricardo Darin Image"));
	}

	@After
	public void liberarRecursos(){
		RepoActores.getInstance().getAllActores().clear();
	}
	
}
