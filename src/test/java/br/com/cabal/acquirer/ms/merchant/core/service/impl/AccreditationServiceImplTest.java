package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AccreditationRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AddressRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Address;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import br.com.cabal.acquirer.ms.merchant.core.domain.mapper.*;
import br.com.cabal.acquirer.ms.merchant.core.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccreditationServiceImplTest {
	
	@InjectMocks
	private AccreditationServiceImpl accreditationService;
	
	@Mock
	private MerchantService merchantService;
	@Mock
	private AddressService addressService;
	@Mock
	private DomicileBankService domicileBankService;
	@Mock
	private EmailService emailService;
	@Mock
	private PhoneService phoneService;
	
	@Mock
	private AddressMapper addressMapper;
	@Mock
	private MerchantMapper merchantMapper;
	@Mock
	private DomicileBankMapper domicileBankMapper;
	@Mock
	private EmailMapper emailMapper;
	@Mock
	private PhoneMapper phoneMapper;
	
	@Test
	public void register() {
		Merchant merchant = getMerchant();
		when(this.addressMapper.toRequest(any())).thenReturn(new Address());
		when(this.addressService.save(any())).thenReturn(1L);
		
		when(this.merchantMapper.toRequest(any())).thenReturn(merchant);
		when(this.merchantService.save(merchant)).thenReturn(1L);
		
		when(this.domicileBankMapper.request(anyList())).thenReturn(new ArrayList<>());
		when((this.emailMapper.request(anyList()))).thenReturn(new ArrayList<>());
		when(this.phoneMapper.request(anyList())).thenReturn(new ArrayList<>());
		
		this.accreditationService.register(getAccreditatio());
		
		verify(this.merchantService).save(merchant);
	}
	
	@Test
	public void remove() {
	}
	
	private AccreditationRequestDTO getAccreditatio(){
		AccreditationRequestDTO dto = new AccreditationRequestDTO();
		dto.setAddress(getAddress());
		return dto;
	}
	
	private AddressRequestDTO getAddress(){
		AddressRequestDTO dto = new AddressRequestDTO();
		dto.setZipCode("11111111");
		return dto;
	}
	
	private Merchant getMerchant(){
		Merchant merchant = new Merchant();
		merchant.setId(1L);
		merchant.setDocument("11111111111111");
		return merchant;
	}
}
