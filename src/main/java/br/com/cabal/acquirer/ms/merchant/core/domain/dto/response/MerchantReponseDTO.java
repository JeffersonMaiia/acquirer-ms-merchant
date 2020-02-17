package br.com.cabal.acquirer.ms.merchant.core.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantReponseDTO {
	
	private Long id;
	private String document;
	private String companyName;
	private String tradingName;
}
