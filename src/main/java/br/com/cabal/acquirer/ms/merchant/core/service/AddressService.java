package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Address;

public interface AddressService {
	
	Long save(Address address);
	void update(Address address);
	Address findById(Long idAddress);
	void remove(Long idAddress);
}
