package br.com.cabal.acquirer.ms.merchant.core.domain.mapper;

import br.com.cabal.acquirer.ms.merchant.core.domain.dto.request.PhoneRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PhoneMapperTest {
	
	private PhoneMapper phoneMapper = Mappers.getMapper(PhoneMapper.class);
	
	@Test
	public void request() {
		assertThat(phoneMapper.request(getPhoneRequestDTOS())).isNotEmpty();
	}
	
	private PhoneRequestDTO getPhoneRequestDTO(){
		PhoneRequestDTO phoneRequestDTO = new PhoneRequestDTO();
		phoneRequestDTO.setPhone("111");
		phoneRequestDTO.setTypePhone(1);
		return phoneRequestDTO;
	}
	
	private List<PhoneRequestDTO> getPhoneRequestDTOS(){
		List<PhoneRequestDTO> phoneRequestDTOS = new ArrayList<>();
		phoneRequestDTOS.add(getPhoneRequestDTO());
		return phoneRequestDTOS;
	}
}
