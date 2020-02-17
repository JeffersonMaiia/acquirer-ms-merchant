package br.com.cabal.acquirer.ms.merchant.core.domain.dto.response;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MerchantReponseDTOTest {
	
	@Test
	public void getId() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setId(1L);
		assertThat(dto.getId()).isNotNull();
	}
	
	@Test
	public void getDocument() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setDocument("1L");
		assertThat(dto.getDocument()).isNotNull();
	}
	
	@Test
	public void getCompanyName() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setCompanyName("1L");
		assertThat(dto.getCompanyName()).isNotNull();
	}
	
	@Test
	public void getTradingName() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setTradingName("1L");
		assertThat(dto.getTradingName()).isNotNull();
	}
	
	@Test
	public void setId() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setId(1L);
		assertThat(dto.getId()).isEqualTo(dto.getId());
	}
	
	@Test
	public void setDocument() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setDocument("1L");
		assertThat(dto.getDocument()).isEqualTo(dto.getDocument());
	}
	
	@Test
	public void setCompanyName() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setCompanyName("1L");
		assertThat(dto.getCompanyName()).isEqualTo(dto.getCompanyName());
	}
	
	@Test
	public void setTradingName() {
		MerchantReponseDTO dto = new MerchantReponseDTO();
		dto.setTradingName("1L");
		assertThat(dto.getTradingName()).isEqualTo(dto.getTradingName());
	}
	
}
