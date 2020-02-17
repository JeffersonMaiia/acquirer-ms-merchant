package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Address;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.AddressRepository;
import br.com.cabal.acquirer.ms.merchant.core.service.AddressService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;
	
	public AddressServiceImpl(final AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@Override
	public Long save(final Address address) {
		return this.addressRepository.save(address).getId();
	}
	
	@Override
	public void update(final Address address) {
		this.addressRepository.save(address);
	}
	
	@Override
	public Address findById(final Long idAddress) {
		return this.addressRepository.findById(idAddress)
		                             .orElseThrow(() -> new NoResultException("Endereço não encontrado."));
	}
	
	@Override
	public void remove(final Long idAddress) {
		this.addressRepository.deleteById(idAddress);
	}
}
