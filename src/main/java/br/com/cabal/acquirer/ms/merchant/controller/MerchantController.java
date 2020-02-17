package br.com.cabal.acquirer.ms.merchant.controller;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.MerchantRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.MerchantReponseDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import br.com.cabal.acquirer.ms.merchant.core.domain.mapper.MerchantMapper;
import br.com.cabal.acquirer.ms.merchant.core.service.MerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/merchant")
@CrossOrigin
public class MerchantController {
	
	private MerchantService merchantService;
	private MerchantMapper merchantMapper;
	
	public MerchantController(final MerchantService merchantService,
	                          final MerchantMapper merchantMapper) {
		this.merchantService = merchantService;
		this.merchantMapper = merchantMapper;
	}
	@ApiOperation(value = "Serviço que retorna todos os comércios")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCESSO", response = MerchantReponseDTO.class)
	})
	@GetMapping
	public ResponseEntity<List<MerchantReponseDTO>> findAll(){
		List<MerchantReponseDTO> dtos = this.merchantMapper.toResponse(this.merchantService.findAll());
		return ResponseEntity.ok(dtos);
	}
	
	@ApiOperation(value = "Serviço que atualizar o comércios")
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "ACCEPTED", response = MerchantReponseDTO.class)
	})
	@PutMapping("/{idMerchant}")
	public ResponseEntity<?> update(@PathVariable("idMerchant") Long idMerchant, @Validated @RequestBody MerchantRequestDTO dto){
		Merchant merchant = this.merchantMapper.toRequest(dto);
		merchant.setId(idMerchant);
		this.merchantService.update(merchant);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
}
