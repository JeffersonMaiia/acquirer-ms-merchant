package br.com.cabal.acquirer.ms.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AcquirerMsMerchantApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AcquirerMsMerchantApplication.class, args);
	}
	
}
