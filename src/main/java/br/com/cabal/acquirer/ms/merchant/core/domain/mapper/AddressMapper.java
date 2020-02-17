package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.AddressRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.ZipCodeResponseDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class AddressMapper {
	
	public abstract Address toRequest(AddressRequestDTO dto);
	
	@Mappings({
		@Mapping(target = "zipCode", source = "cep"),
		@Mapping(target = "publicPlace", source = "logradouro"),
		@Mapping(target = "complement", source = "complemento"),
		@Mapping(target = "neighborhood", source = "bairro"),
		@Mapping(target = "city", source = "localidade"),
		@Mapping(target = "uf", source = "uf"),
	})
	public abstract AddressRequestDTO toZipCode(ZipCodeResponseDTO dto);
}
