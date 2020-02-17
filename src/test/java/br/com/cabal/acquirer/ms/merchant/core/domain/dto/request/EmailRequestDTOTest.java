package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailRequestDTOTest {
	
	@Test
	public void getEmail() {
		EmailRequestDTO dto = new EmailRequestDTO();
		dto.setEmail("Aasas@asa.com");
		assertThat(dto.getEmail()).isNotNull();
	}
	
	@Test
	public void setEmail() {
		EmailRequestDTO dto = new EmailRequestDTO();
		dto.setEmail("Aasas@asa.com");
		assertThat(dto.getEmail()).isEqualTo(dto.getEmail());
	}
}
