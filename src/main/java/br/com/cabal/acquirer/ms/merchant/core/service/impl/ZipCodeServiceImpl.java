package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.client.ZipCodeClient;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.ZipCodeResponseDTO;
import br.com.cabal.acquirer.ms.merchant.core.service.ZipCodeService;
import org.springframework.stereotype.Service;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {
	
	private ZipCodeClient zipCodeClient;
	
	public ZipCodeServiceImpl(final ZipCodeClient zipCodeClient) {
		this.zipCodeClient = zipCodeClient;
	}
	
	@Override
	public ZipCodeResponseDTO find(final String zipCode) {
		return this.zipCodeClient.find(zipCode);
	}
}
