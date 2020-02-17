package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.PhoneRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Phone;
import br.com.cabal.acquirer.ms.merchant.core.domain.enums.TypePhoneEnum;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public abstract class PhoneMapper {
	
	@BeforeMapping
	protected void conveter(PhoneRequestDTO dto, @MappingTarget Phone phone){
		phone.setTypePhone(TypePhoneEnum.findByCod(dto.getTypePhone()).orElse(null));
	}
	
	@Mapping(target = "typePhone", ignore = true)
	public abstract Phone request(PhoneRequestDTO dto);
	public abstract List<Phone> request(List<PhoneRequestDTO> dtos);
}
