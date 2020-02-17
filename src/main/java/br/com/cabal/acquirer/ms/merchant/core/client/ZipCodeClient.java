package br.com.cabal.acquirer.ms.merchant.core.client;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.ZipCodeResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "zipCode", url = "${acquire.url.external.via.cep}")
public interface ZipCodeClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "{zipCode}/json", consumes = "application/json")
	ZipCodeResponseDTO find(@PathVariable("zipCode") String zipCode);
	
}
