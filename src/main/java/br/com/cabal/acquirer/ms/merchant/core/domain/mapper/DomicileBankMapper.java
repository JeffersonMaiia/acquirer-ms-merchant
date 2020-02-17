package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.DomicileBankRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.DomicileBank;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import br.com.cabal.acquirer.ms.merchant.core.domain.enums.ProductEnum;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public abstract class DomicileBankMapper {
	
	@BeforeMapping
	protected void converterEnum(DomicileBankRequestDTO dto, @MappingTarget DomicileBank domicileBank){
		domicileBank.setProduct(ProductEnum.findByCod(dto.getProduct()).orElse(null));
		domicileBank.setMerchant(new Merchant());
	}
	
	@Mapping(target = "product", ignore = true)
	public abstract DomicileBank request(DomicileBankRequestDTO dto);
	public abstract List<DomicileBank> request(List<DomicileBankRequestDTO> dtos);
}
