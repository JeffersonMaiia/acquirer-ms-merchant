package br.com.cabal.acquirer.ms.merchant.controller;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AddressRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.ZipCodeResponseDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.mapper.AddressMapper;
import br.com.cabal.acquirer.ms.merchant.core.service.ZipCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ZipCodeController.class)
public class ZipCodeControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ZipCodeService zipCodeService;
	
	@MockBean
	private AddressMapper addressMapper;
	
	@Test
	public void find() throws Exception {
		when(this.zipCodeService.find("11111111")).thenReturn(any());
		when(this.addressMapper.toZipCode(new ZipCodeResponseDTO())).thenReturn(addressRequestDTO());
		this.mockMvc.perform(get("/v1/zipcode/11111111"))
		            .andDo(print())
				.andExpect(status().isOk());
	}
	
	private AddressRequestDTO addressRequestDTO(){
		AddressRequestDTO dto = new AddressRequestDTO();
		dto.setZipCode("1111111111");
		dto.setCity("ss");
		dto.setComplement("sssss");
		dto.setNeighborhood("ss");
		dto.setPublicPlace("ss");
		dto.setUf("s");
		return dto;
	}
}
