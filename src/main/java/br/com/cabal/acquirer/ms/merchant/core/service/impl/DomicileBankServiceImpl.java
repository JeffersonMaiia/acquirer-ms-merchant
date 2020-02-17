package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.DomicileBank;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.DomicileBankRepository;
import br.com.cabal.acquirer.ms.merchant.core.service.DomicileBankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicileBankServiceImpl implements DomicileBankService {
	
	private DomicileBankRepository domicileBankRepository;
	
	public DomicileBankServiceImpl(final DomicileBankRepository domicileBankRepository) {
		this.domicileBankRepository = domicileBankRepository;
	}
	
	@Override
	public void save(final List<DomicileBank> domicileBanks) {
		this.domicileBankRepository.saveAll(domicileBanks);
	}
	
	@Override
	public void update(final DomicileBank domicileBank) {
		this.domicileBankRepository.save(domicileBank);
	}
	
	@Override
	public List<DomicileBank> findByMerchantId(final Long idMerchant) {
		return this.domicileBankRepository.findAllByMerchantId(idMerchant);
	}
	
	@Override
	public void remove(final Long idDomicile) {
		this.domicileBankRepository.deleteById(idDomicile);
	}
}
