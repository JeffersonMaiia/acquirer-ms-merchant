package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Phone;

import java.util.List;

public interface PhoneService {
	
	void saveAll(List<Phone> phones);
	void update(Phone phone);
	List<Phone> findByMerchantId(Long idMerchant);
	void remove(Long id);
}
