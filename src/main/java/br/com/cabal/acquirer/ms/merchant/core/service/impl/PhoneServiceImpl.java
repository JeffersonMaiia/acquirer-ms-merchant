package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Phone;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.PhoneRepository;
import br.com.cabal.acquirer.ms.merchant.core.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	private PhoneRepository phoneRepository;
	
	public PhoneServiceImpl(final PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	
	@Override
	public void saveAll(final List<Phone> phones) {
		this.phoneRepository.saveAll(phones);
	}
	
	@Override
	public void update(final Phone phone) {
		this.phoneRepository.save(phone);
	}
	
	@Override
	public List<Phone> findByMerchantId(final Long idMerchant) {
		return this.phoneRepository.findAllByMerchantId(idMerchant);
	}
	
	@Override
	public void remove(final Long id) {
		this.phoneRepository.deleteById(id);
	}
}
