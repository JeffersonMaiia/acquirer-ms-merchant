package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.MerchantRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.dto.response.MerchantReponseDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public abstract class MerchantMapper {
	
	public abstract Merchant toRequest(MerchantRequestDTO dto);
	public abstract MerchantReponseDTO toResponse(Merchant merchant);
	public abstract List<MerchantReponseDTO> toResponse(List<Merchant> merchant);
	
}
