// package com.adoptaamor.adoptaamor;

// import java.util.Collections;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.FilterType;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.bean.override.mockito.MockitoBean;
// import org.springframework.test.web.servlet.MockMvc;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import com.adoptaamor.adoptaamor.config.jwt.JwtAuthenticationFilter;
// import com.adoptaamor.adoptaamor.controllers.PetsController;
// import com.adoptaamor.adoptaamor.models.Pets;
// import com.adoptaamor.adoptaamor.services.PetsService;
// import com.adoptaamor.adoptaamor.services.UserService;

// @WebMvcTest(controllers = PetsController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
// 		JwtAuthenticationFilter.class }))
// @AutoConfigureMockMvc(addFilters = false)
// public class PetsControllerTest {

// 	@Autowired
// 	private MockMvc mockMvc;

// 	@MockitoBean
// 	private PetsService petsService;

// 	@MockitoBean
// 	private UserService userService;

// 	@Test
// 	void deberiaDevolverListadoDeMascotas() throws Exception {
// 		Pets pet = new Pets();
// 		pet.setNombre("Max");
// 		pet.setRaza("Golden Retriever");
// 		pet.setTipo("Perro");
// 		pet.setTamano("Grande");
// 		pet.setEdad(5);
// 		pet.setUbicacion("Madrid");

// 		given(petsService.getPets()).willReturn(Collections.singletonList(pet));

// 		mockMvc.perform(get("/pets")
// 				.contentType(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk())
// 				.andExpect(content().json(
// 						"[{\"nombre\":\"Max\", \"raza\":\"Golden Retriever\", \"tipo\":\"Perro\", \"tamano\":\"Grande\", \"edad\":5, \"ubicacion\":\"Madrid\"}]"));
// 	}
// }
