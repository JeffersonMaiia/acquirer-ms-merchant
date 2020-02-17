package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.EmailRequestDTO;
import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Email;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class EmailMapper {
	
	public abstract Email request(EmailRequestDTO dto);
	public abstract List<Email> request(List<EmailRequestDTO> dtos);
}
