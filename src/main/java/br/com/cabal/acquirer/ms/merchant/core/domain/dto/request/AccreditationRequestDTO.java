package br.com.cabal.acquirer.ms.merchant.core.domain.dto.request;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Email;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccreditationRequestDTO {
	
	@Valid
	@NotNull
	private MerchantRequestDTO merchant;
	
	@Valid
	@NotNull
	private AddressRequestDTO address;
	
	@Valid
	@NotEmpty
	private List<DomicileBankRequestDTO> domicileBank;
	
	@Valid
	@NotEmpty
	private List<EmailRequestDTO> emails;
	
	@Valid
	@NotEmpty
	private List<PhoneRequestDTO> phones;
	
}
