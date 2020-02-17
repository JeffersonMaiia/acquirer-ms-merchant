package br.com.cabal.acquirer.ms.merchant;

import br.com.cabal.acquirer.ms.merchant.controller.MerchantController;
import br.com.cabal.acquirer.ms.merchant.controller.ZipCodeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AcquirerMsMerchantApplicationTests {
	
	@Autowired
	private MerchantController merchantController;
	
	@Autowired
	private ZipCodeController zipCodeController;
	
	
	@Test
	public void testMain(){
		AcquirerMsMerchantApplication.main(new String[]{});
	}
	
	@Test
	void contextLoads() {
		assertThat(merchantController).isNotNull();
		assertThat(zipCodeController).isNotNull();
	}
	
}
