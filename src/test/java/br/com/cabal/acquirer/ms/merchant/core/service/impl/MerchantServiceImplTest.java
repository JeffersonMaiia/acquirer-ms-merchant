package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.MerchantRepository;
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
public class MerchantServiceImplTest {
	
	@InjectMocks
	private MerchantServiceImpl merchantService;
	
	@Mock
	private MerchantRepository merchantRepository;
	
	@Test
	public void save(){
		when(this.merchantRepository.save(any())).thenReturn(getMerchant());
		assertThat(this.merchantService.save(any())).isNotNull();
	}
	
	@Test
	public void update(){
		this.merchantService.update(any());
		verify(this.merchantRepository).save(any());
	}
	
	@Test
	public void findAll(){
		when(this.merchantRepository.findAll()).thenReturn(getMerchants());
		assertThat(this.merchantService.findAll()).isNotEmpty();
	}
	
	@Test
	public void remove(){
		this.merchantService.remove(anyLong());
		verify(this.merchantRepository).deleteById(anyLong());
	}
	
	private List<Merchant> getMerchants(){
		List<Merchant> merchants = new ArrayList<>();
		merchants.add(getMerchant());
		return merchants;
	}
	
	private Merchant getMerchant(){
		Merchant merchant = new Merchant();
		merchant.setId(1L);
		return merchant;
	}
}
