package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.client.ZipCodeClient;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.ZipCodeResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ZipCodeServiceImplTest {
	
	@InjectMocks
	private ZipCodeServiceImpl zipCodeService;
	
	@Mock
	private ZipCodeClient zipCodeClient;
	
	@Test
	public void find() {
		when(zipCodeClient.find(any())).thenReturn(getZipCodeDTO());
		assertTrue(zipCodeService.find("11111111").getCep().equals(getZipCodeDTO().getCep()));
	}
	
	public ZipCodeResponseDTO getZipCodeDTO(){
		ZipCodeResponseDTO dto = new ZipCodeResponseDTO();
		dto.setCep("11111111");
		dto.setLogradouro("44444444444444444");
		dto.setComplemento("4444444444");
		dto.setBairro("aaaaaaaaaaaaaa");
		dto.setUf("AA");
		return dto;
	}
}
