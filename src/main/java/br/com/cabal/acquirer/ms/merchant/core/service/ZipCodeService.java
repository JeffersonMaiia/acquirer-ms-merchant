package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.ZipCodeResponseDTO;

public interface ZipCodeService {
	
	ZipCodeResponseDTO find(String zipCode);
}
