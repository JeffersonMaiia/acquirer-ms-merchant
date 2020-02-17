package br.com.cabal.acquirer.ms.merchant.core.service;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.DomicileBank;

import java.util.List;

public interface DomicileBankService {
	
	void save(List<DomicileBank> domicileBanks);
	void update(DomicileBank domicileBank);
	List<DomicileBank> findByMerchantId(Long idMerchant);
	void remove(Long idDomicile);
}
