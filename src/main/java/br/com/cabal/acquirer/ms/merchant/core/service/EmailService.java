package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Email;

import java.util.List;

public interface EmailService {
	
	void saveAll(List<Email> emails);
	void update(Email email);
	List<Email> findByMerchant(Long merchant);
	void remove(Long id);
}
