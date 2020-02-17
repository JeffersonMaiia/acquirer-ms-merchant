package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicileBankRequestDTO {
	
	@Min(1)
	@Max(3)
	@NotNull
	private Integer product;
	
	@Pattern(regexp = "[0-9]+", message = "Apenas numero.")
	@Size(min = 3, max = 3)
	@NotBlank
	private String domicile;
	
	@Pattern(regexp = "[0-9]+", message = "Apenas numero.")
	@Size(min = 4, max = 4)
	@NotBlank
	private String agency;
	
	@Pattern(regexp = "[0-9]+", message = "Apenas numero.")
	@Size(min = 5, max = 10)
	@NotBlank
	private String account;
}
