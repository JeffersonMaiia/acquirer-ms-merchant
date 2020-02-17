package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Email;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.EmailRepository;
import br.com.cabal.acquirer.ms.merchant.core.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
	
	private EmailRepository emailRepository;
	
	public EmailServiceImpl(final EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}
	
	@Override
	public void saveAll(List<Email> phones) {
		this.emailRepository.saveAll(phones);
	}
	
	@Override
	public void update(final Email email) {
		this.emailRepository.save(email);
	}
	
	@Override
	public List<Email> findByMerchant(final Long merchant) {
		return this.emailRepository.findAllByMerchantId(merchant);
	}
	
	@Override
	public void remove(Long id) {
		this.emailRepository.deleteById(id);
	}
}
