package br.com.cabal.acquirer.ms.merchant.controller;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import br.com.cabal.acquirer.ms.merchant.core.domain.mapper.MerchantMapper;
import br.com.cabal.acquirer.ms.merchant.core.service.MerchantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MerchantController.class)
public class MerchantControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MerchantService merchantService;
	
	@MockBean
	private MerchantMapper merchantMapper;
	
	@Test
	public void findAll() throws Exception {
		when(merchantService.findAll()).thenReturn(new ArrayList<>());
		when(merchantMapper.toResponse(anyList())).thenReturn(new ArrayList<>());
		this.mockMvc.perform(get("/v1/merchant")).andExpect(status().isOk());
	}
	
	@Test
	public void update() throws Exception {
		when(this.merchantMapper.toRequest(any())).thenReturn(new Merchant());
		this.mockMvc.perform(put("/v1/merchant/1")
				                     .contentType(MediaType.APPLICATION_JSON_VALUE)
				                     .content(jsonPut()))
		            .andDo(print())
		            .andExpect(status().isAccepted());
	}
	
	private String json() {
		return "[{\n" +
		       "  \"id\":1,\n" +
		       "    \"companyName\": \"aaaaaaaaaaaa\",\n" +
		       "    \"document\": \"aaaaaaaaaaaaaaaa\",\n" +
		       "    \"tradingName\": \"aaaaaaaa\"\n" +
		       "  }]";
	}
	
	private String jsonPut() {
		return "{\n" +
		       "    \"companyName\": \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\n" +
		       "    \"document\": \"02079600000112\",\n" +
		       "    \"tradingName\": \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"\n" +
		       "  }";
	}
}
