package br.com.cabal.acquirer.ms.merchant.controller;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AddressRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.mapper.AddressMapper;
import br.com.cabal.acquirer.ms.merchant.core.service.ZipCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/zipcode")
@CrossOrigin
public class ZipCodeController {
	
	private ZipCodeService zipCodeService;
	private AddressMapper addressMapper;
	
	public ZipCodeController(final ZipCodeService zipCodeService,
	                         final AddressMapper addressMapper) {
		this.zipCodeService = zipCodeService;
		this.addressMapper = addressMapper;
	}
	
	@GetMapping("/{zipCode}")
	public ResponseEntity<AddressRequestDTO> find(@PathVariable("zipCode") String zipCode) {
		return ResponseEntity.ok(this.addressMapper.toZipCode(this.zipCodeService.find(zipCode)));
	}
}
