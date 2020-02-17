package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.MerchantRepository;
import br.com.cabal.acquirer.ms.merchant.core.service.MerchantService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {
	
	private MerchantRepository merchantRepository;
	
	public MerchantServiceImpl(final MerchantRepository merchantRepository) {
		this.merchantRepository = merchantRepository;
	}
	
	@Override
	public Long save(final Merchant merchant) {
		return this.merchantRepository.save(merchant).getId();
	}
	
	@Override
	public void update(final Merchant merchant) {
		this.merchantRepository.save(merchant);
	}
	
	@Override
	public List<Merchant> findAll() {
		return this.merchantRepository.findAll();
	}
	
	@Override
	public void remove(final Long merchant) {
		this.merchantRepository.deleteById(merchant);
	}
	
	@Override
	public Merchant findById(final Long idMerchant) {
		return this.merchantRepository.findById(idMerchant)
		                              .orElseThrow(() -> new NoResultException("Comércio não encontrado!"));
	}
}
