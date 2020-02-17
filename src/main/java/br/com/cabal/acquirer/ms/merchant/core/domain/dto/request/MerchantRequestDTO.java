package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantRequestDTO {
	
	@Size(min = 14, max = 14)
	@CNPJ
	@NotBlank
	private String document;
	
	@Pattern(regexp = "[a-zA-Z ]+", message = "Apenas letras e espaços")
	@Size(min = 20, max = 100)
	@NotBlank
	private String companyName;
	
	@Pattern(regexp = "[a-zA-Z ]+", message = "Apenas letras e espaços")
	@Size(min = 20, max = 100)
	@NotBlank
	private String tradingName;
	
}
