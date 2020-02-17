package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AccreditationRequestDTO;

public interface AccreditationService {
	
	Long register(AccreditationRequestDTO dto);
	void remove(Long idMerchant);
}
