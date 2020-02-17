package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Phone;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.PhoneRepository;
import br.com.cabal.acquirer.ms.merchant.core.service.PhoneService;
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
public class PhoneServiceImplTest {
	
	@InjectMocks
	private PhoneServiceImpl phoneService;
	
	@Mock
	private PhoneRepository phoneRepository;
	
	@Test
	public void saveAll() {
		this.phoneService.saveAll(anyList());
		verify(this.phoneRepository).saveAll(anyList());
	}
	
	@Test
	public void update() {
		this.phoneService.update(any());
		verify(this.phoneRepository).save(any());
	}
	
	@Test
	public void findByMerchantId() {
		when(this.phoneRepository.findAllByMerchantId(anyLong())).thenReturn(getPhones());
		assertThat(this.phoneService.findByMerchantId(anyLong())).isNotEmpty();
	}
	
	@Test
	public void remove() {
		this.phoneService.remove(anyLong());
		verify(this.phoneRepository).deleteById(anyLong());
	}
	
	private List<Phone> getPhones(){
		List<Phone> phones = new ArrayList<>();
		phones.add(new Phone());
		return phones;
	}
}
