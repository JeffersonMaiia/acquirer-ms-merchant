package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;

import java.util.List;

public interface MerchantService {
	
	Long save(Merchant merchant);
	void update(Merchant merchant);
	List<Merchant> findAll();
	void remove(Long merchant);
	Merchant findById(Long idMerchant);
}
