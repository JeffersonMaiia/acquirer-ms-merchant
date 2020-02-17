package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneRequestDTO {
	
	@Size(min = 8, max = 9)
	@NotBlank
	private String phone;
	
	@Min(1)
	@Max(3)
	@NotNull
	private Integer typePhone;
}
