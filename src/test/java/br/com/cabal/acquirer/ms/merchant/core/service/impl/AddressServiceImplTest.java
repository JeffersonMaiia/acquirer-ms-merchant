package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Address;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceImplTest {
	
	@InjectMocks
	private AddressServiceImpl addressService;
	
	@Mock
	private AddressRepository addressRepository;
	
	@Test
	public void save() {
		when(this.addressRepository.save(any())).thenReturn(getAddress());
		assertThat(this.addressService.save(any())).isNotNull();
	}
	
	@Test
	public void findById() {
		when(this.addressRepository.findById(any())).thenReturn(getAddresses().stream().findFirst());
		assertThat(this.addressService.findById(anyLong())).isNotNull();
	}
	
	@Test
	public void remove() {
		this.addressService.remove(anyLong());
		verify(this.addressRepository).deleteById(anyLong());
	}
	
	@Test
	public void update() {
		this.addressService.update(any());
		verify(this.addressRepository).save(any());
	}
	
	private Address getAddress() {
		Address address = new Address();
		address.setId(1L);
		address.setZipCode("77777777");
		address.setCity("77777777");
		address.setPublicPlace("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		address.setNeighborhood("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		address.setCity("AAAAAAAAAAA");
		address.setUf("FF");
		return address;
	}
	
	private List<Address> getAddresses() {
		List<Address> addresses = new ArrayList<>();
		addresses.add(getAddress());
		return addresses;
	}
	
}
