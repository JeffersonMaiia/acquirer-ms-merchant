package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailRequestDTO {
	
	@Email
	@Size(max = 100)
	@NotBlank
	private String email;
}
