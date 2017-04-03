package test_smgo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.Date;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.core.Is.is;


import model.Actor;
import repos.RepoActores;

public class TestActor extends TestActores{

	@Test
	public void testCantidadActores() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/actores")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$", hasSize(3)));
	}

	@Test
	public void testListarActores() throws Exception{		
		mockMvc.perform(MockMvcRequestBuilders.get("/actores")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(0)))
				.andExpect(jsonPath("$[0].nombre").value("Tom Cruise"))
				.andExpect(jsonPath("$[0].edad").value(50))
				.andExpect(jsonPath("$[0].lugarNac").value("New York, USA"))
				.andExpect(jsonPath("$[2].id", is(2)))
				.andExpect(jsonPath("$[2].nombre").value("Ricardo Darin"))
				.andExpect(jsonPath("$[2].edad").value(53))
				.andExpect(jsonPath("$[2].lugarNac").value("Buenos Aires, ARG"));
	}

	@Test
	public void testActoresPorId() throws Exception{		
		mockMvc.perform(MockMvcRequestBuilders.get("/actores/0")).andExpect(status().isOk()).andDo(print())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id", is(0)))
				.andExpect(jsonPath("$.nombre").value("Tom Cruise"))
				.andExpect(jsonPath("$.edad").value(50))
				.andExpect(jsonPath("$.lugarNac").value("New York, USA")).andDo(print());
				
	}
	
	@Test
	public void testCrearActor() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders.post("/actores"))
	}
	
}
