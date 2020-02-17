package br.com.cabal.acquirer.ms.merchant.controller;

import br.com.cabal.acquirer.ms.merchant.core.service.AccreditationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccreditationController.class)
public class AccreditationControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccreditationService accreditationService;
	
	@Test
	public void register() throws Exception {
		when(this.accreditationService.register(any())).thenReturn(1L);
		this.mockMvc.perform(post("/v1/accreditation")
				                     .contentType(MediaType.APPLICATION_JSON_VALUE)
				                     .content(json()))
		            .andDo(print())
		            .andExpect(status().isCreated());
	}
	
	private String json() {
		return "{\n" +
		       "  \"address\": {\n" +
		       "    \"city\": \"AAAAAAAAAAAAAAAAAAAAAAAA\",\n" +
		       "    \"complement\": \"AAAAAAAAAAAAAAAAAAAAAAAAA\",\n" +
		       "    \"neighborhood\": \"AAAAAAAAAAAAAAAAAAAAAAA\",\n" +
		       "    \"publicPlace\": \"AAAAAAAAAAAAA\",\n" +
		       "    \"uf\": \"DD\",\n" +
		       "    \"zipCode\": \"71691417\"\n" +
		       "  },\n" +
		       "  \"domicileBank\": [\n" +
		       "    {\n" +
		       "      \"account\": \"00000\",\n" +
		       "      \"agency\": \"0000\",\n" +
		       "      \"domicile\": \"000\",\n" +
		       "      \"product\": 1\n" +
		       "    }\n" +
		       "  ],\n" +
		       "  \"emails\": [\n" +
		       "    {\n" +
		       "      \"email\": \"asas@asas.com\"\n" +
		       "    }\n" +
		       "  ],\n" +
		       "  \"merchant\": {\n" +
		       "    \"companyName\": \"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\",\n" +
		       "    \"document\": \"13347369000117\",\n" +
		       "    \"tradingName\": \"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\"\n" +
		       "  },\n" +
		       "  \"phones\": [\n" +
		       "    {\n" +
		       "      \"phone\": \"999999999\",\n" +
		       "      \"typePhone\": 3\n" +
		       "    }\n" +
		       "  ]\n" +
		       "}";
	}
}
