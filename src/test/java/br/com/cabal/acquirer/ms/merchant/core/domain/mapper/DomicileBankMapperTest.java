package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.DomicileBankRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DomicileBankMapperTest {
	
	private DomicileBankMapper domicileBankMapper = Mappers.getMapper(DomicileBankMapper.class);
	
	@Test
	public void request() {
		assertThat(this.domicileBankMapper.request(getDomicileBankRequestDTOS())).isNotEmpty();
	}
	
	private DomicileBankRequestDTO getDomicileBankRequestDTO(){
		DomicileBankRequestDTO domicileBankRequestDTO = new DomicileBankRequestDTO();
		domicileBankRequestDTO.setProduct(1);
		return domicileBankRequestDTO;
	}
	
	private List<DomicileBankRequestDTO> getDomicileBankRequestDTOS(){
		List<DomicileBankRequestDTO> dtos = new ArrayList<>();
		dtos.add(getDomicileBankRequestDTO());
		return dtos;
	}
}
