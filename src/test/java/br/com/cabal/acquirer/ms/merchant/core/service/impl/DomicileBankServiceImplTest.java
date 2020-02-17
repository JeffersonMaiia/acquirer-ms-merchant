package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.DomicileBank;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.DomicileBankRepository;
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
public class DomicileBankServiceImplTest {
	
	@InjectMocks
	private DomicileBankServiceImpl domicileBankService;
	
	@Mock
	private DomicileBankRepository domicileBankRepository;
	
	@Test
	public void save(){
		this.domicileBankService.save(anyList());
		verify(this.domicileBankRepository).saveAll(anyList());
	}
	
	@Test
	public void update(){
		this.domicileBankService.update(any());
		verify(this.domicileBankRepository).save(any());
	}
	
	@Test
	public void findByMerchantId(){
		when(this.domicileBankRepository.findAllByMerchantId(anyLong())).thenReturn(getDomicileBanks());
		assertThat(this.domicileBankService.findByMerchantId(anyLong())).isNotEmpty();
	}
	
	@Test
	public void remove(){
		this.domicileBankService.remove(anyLong());
		verify(this.domicileBankRepository).deleteById(anyLong());
	}
	
	private List<DomicileBank> getDomicileBanks(){
		List<DomicileBank> domicileBanks = new ArrayList<>();
		domicileBanks.add(new DomicileBank());
		return domicileBanks;
	}
	
}
