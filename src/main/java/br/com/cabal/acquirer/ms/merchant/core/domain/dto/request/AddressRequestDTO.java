package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestDTO {
	
	@Size(min = 8, max = 8)
	@NotBlank
	private String zipCode;
	
	@NotBlank
	private String publicPlace;
	
	@NotBlank
	private String neighborhood;
	
	@NotBlank
	private String city;
	
	private String complement;
	
	@Size(min = 2, max = 2)
	@NotBlank
	private String uf;
}
