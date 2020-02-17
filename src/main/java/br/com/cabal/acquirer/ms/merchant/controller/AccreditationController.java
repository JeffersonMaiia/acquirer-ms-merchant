package br.com.cabal.acquirer.ms.merchant.controller;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AccreditationRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.exception.ApiError;
import br.com.cabal.acquirer.ms.merchant.core.service.AccreditationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/accreditation")
@CrossOrigin
public class AccreditationController {
	
	private AccreditationService accreditationService;
	
	public AccreditationController(final AccreditationService accreditationService) {
		this.accreditationService = accreditationService;
	}
	
	@ApiOperation(value = "Serviço que cadastra o comércio")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "CREATE", response = Long.class),
			@ApiResponse(code = 400, message = "Validation Error!", response = ApiError.class)
	})
	@PostMapping
	public ResponseEntity<Long> register(@Validated @RequestBody AccreditationRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED)
		                     .body(this.accreditationService.register(dto));
	}
	
	@ApiOperation(value = "Serviço que remove o comércio")
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "ACCEPTED", response = Long.class),
			@ApiResponse(code = 404, message = "Comércio não encontrado!", response = ApiError.class)
	})
	@DeleteMapping("/{idMerchant}")
	public ResponseEntity<?> remove(@PathVariable("idMerchant") Long idMerchant) {
		this.accreditationService.remove(idMerchant);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
