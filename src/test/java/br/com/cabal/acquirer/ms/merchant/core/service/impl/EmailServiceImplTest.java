package br.com.cabal.acquirer.ms.merchant.core.service.impl;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Email;
import br.com.cabal.acquirer.ms.merchant.core.domain.repository.EmailRepository;
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
public class EmailServiceImplTest {
	
	@InjectMocks
	private EmailServiceImpl emailService;
	
	@Mock
	private EmailRepository emailRepository;
	
	@Test
	public void saveAll() {
		this.emailService.saveAll(anyList());
		verify(this.emailRepository).saveAll(anyList());
	}
	
	@Test
	public void findByMerchant() {
		when(this.emailRepository.findAllByMerchantId(anyLong())).thenReturn(getEmails());
		assertThat(this.emailService.findByMerchant(anyLong())).isNotEmpty();
	}
	
	@Test
	public void remove(){
		this.emailService.remove(anyLong());
		verify(this.emailRepository).deleteById(anyLong());
	}
	
	@Test
	public void update(){
		this.emailService.update(any());
		verify(this.emailRepository).save(any());
	}
	
	private List<Email> getEmails(){
		List<Email> emails = new ArrayList<>();
		emails.add(new Email());
		return emails;
	}
}
