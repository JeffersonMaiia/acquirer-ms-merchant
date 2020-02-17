package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AccreditationRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.*;
import br.com.cabal.acquirer.ms.merchant.core.domain.mapper.*;
import br.com.cabal.acquirer.ms.merchant.core.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccreditationServiceImpl implements AccreditationService {
	
	private MerchantService merchantService;
	private AddressService addressService;
	private DomicileBankService domicileBankService;
	private EmailService emailService;
	private PhoneService phoneService;
	
	private AddressMapper addressMapper;
	private MerchantMapper merchantMapper;
	private DomicileBankMapper domicileBankMapper;
	private EmailMapper emailMapper;
	private PhoneMapper phoneMapper;
	
	public AccreditationServiceImpl(final MerchantService merchantService,
	                                final AddressService addressService,
	                                final DomicileBankService domicileBankService,
	                                final EmailService emailService,
	                                final PhoneService phoneService,
	                                final AddressMapper addressMapper,
	                                final MerchantMapper merchantMapper,
	                                final DomicileBankMapper domicileBankMapper,
	                                final EmailMapper emailMapper,
	                                final PhoneMapper phoneMapper) {
		this.merchantService = merchantService;
		this.addressService = addressService;
		this.domicileBankService = domicileBankService;
		this.emailService = emailService;
		this.phoneService = phoneService;
		this.addressMapper = addressMapper;
		this.merchantMapper = merchantMapper;
		this.domicileBankMapper = domicileBankMapper;
		this.emailMapper = emailMapper;
		this.phoneMapper = phoneMapper;
	}
	
	@Override
	@Transactional
	public Long register(AccreditationRequestDTO dto) {
		Long idAddress = saveAddress(dto);
		
		Long idMerchant = saveMerchant(dto, idAddress);
		
		saveDomicileBank(dto, idMerchant);
		saveEmail(dto, idMerchant);
		savePhone(dto, idMerchant);
		
		return idMerchant;
	}
	
	@Override
	@Transactional
	public void remove(Long idMerchant) {
		Merchant merchant = this.merchantService.findById(idMerchant);
		
		removePhones(idMerchant);
		removeEmails(idMerchant);
		removeDomicileBank(idMerchant);
		
		this.merchantService.remove(idMerchant);
		this.addressService.remove(merchant.getAddress().getId());
	}
	
	private void removeDomicileBank(final Long idMerchant) {
		this.domicileBankService.findByMerchantId(idMerchant).stream().forEach(domicileBank -> {
			this.domicileBankService.remove(domicileBank.getId());
		});
	}
	
	private void removeEmails(final Long idMerchant) {
		this.emailService.findByMerchant(idMerchant).stream().forEach(email -> {
			this.emailService.remove(email.getId());
		});
	}
	
	private void removePhones(final Long idMerchant) {
		this.phoneService.findByMerchantId(idMerchant).stream().forEach(phone -> {
			this.phoneService.remove(phone.getId());
		});
	}
	
	private Long saveAddress(final AccreditationRequestDTO dto) {
		return this.addressService.save(addressMapper.toRequest(dto.getAddress()));
	}
	
	private Long saveMerchant(final AccreditationRequestDTO dto, final Long idAddress) {
		Merchant merchant = merchantMapper.toRequest(dto.getMerchant());
		merchant.setAddress(new Address());
		merchant.getAddress().setId(idAddress);
		return this.merchantService.save(merchant);
	}
	
	private void saveDomicileBank(final AccreditationRequestDTO dto, final Long idMerchant) {
		List<DomicileBank> domicileBanks = domicileBankMapper.request(dto.getDomicileBank());
		domicileBanks = domicileBanks.stream()
		                             .map(domicile -> {
			                             domicile.getMerchant().setId(idMerchant);
			                             return domicile;
		                             })
		                             .collect(Collectors.toList());
		
		this.domicileBankService.save(domicileBanks);
	}
	
	private void saveEmail(final AccreditationRequestDTO dto, final Long idMerchant) {
		List<Email> emails = this.emailMapper.request(dto.getEmails());
		emails = emails.stream()
		               .map(email -> {
			               email.setMerchant(new Merchant());
			               email.getMerchant().setId(idMerchant);
			               return email;
		               })
		               .collect(Collectors.toList());
		this.emailService.saveAll(emails);
	}
	
	private void savePhone(final AccreditationRequestDTO dto, final Long idMerchant) {
		List<Phone> phones = this.phoneMapper.request(dto.getPhones());
		phones = phones.stream()
		               .map(phone -> {
			               phone.setMerchant(new Merchant());
			               phone.getMerchant().setId(idMerchant);
			               return phone;
		               })
		               .collect(Collectors.toList());
		this.phoneService.saveAll(phones);
	}
	
}
