package br.com.cabal.acquirer.ms.merchant.core.domain.entity;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.TypePhoneEnum;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneTest {
	
	@Test
	public void getId() {
		Phone phone = new Phone();
		phone.setId(1L);
		assertThat(phone.getId()).isNotNull();
	}
	
	@Test
	public void getPhone() {
		Phone phone = new Phone();
		phone.setPhone("1L");
		assertThat(phone.getPhone()).isNotNull();
	}
	
	@Test
	public void getTypePhone() {
		Phone phone = new Phone();
		phone.setTypePhone(TypePhoneEnum.CELL_PHONE);
		assertThat(phone.getMerchant()).isNotNull();
	}
	
	@Test
	public void getMerchant() {
		Phone phone = new Phone();
		phone.setMerchant(new Merchant());
		assertThat(phone.getMerchant()).isNotNull();
	}
	
	@Test
	public void setId() {
		Phone phone = new Phone();
		phone.setId(1L);
		assertThat(phone.getId()).isEqualTo(phone.getId());
	}
	
	@Test
	public void setPhone() {
		Phone phone = new Phone();
		phone.setPhone("1L");
		assertThat(phone.getPhone()).isEqualTo(phone.getPhone());
	}
	
	@Test
	public void setTypePhone() {
		Phone phone = new Phone();
		phone.setTypePhone(TypePhoneEnum.CELL_PHONE);
		assertThat(phone.getTypePhone()).isEqualTo(phone.getTypePhone());
	}
	
	@Test
	public void setMerchant() {
		Phone phone = new Phone();
		phone.setMerchant(new Merchant());
		assertThat(phone.getMerchant()).isEqualTo(phone.getMerchant());
	}
}
