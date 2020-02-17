package br.com.cabal.acquirer.ms.merchant.core.domain.enums.converter;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.TypePhoneEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TypePhoneConverterTest {
	
	@InjectMocks
	private TypePhoneConverter typePhoneConverter;
	
	@Test
	public void convertToDatabaseColumn() {
		assertThat(this.typePhoneConverter.convertToDatabaseColumn(TypePhoneEnum.CELL_PHONE)).isEqualTo(TypePhoneEnum.CELL_PHONE.getCod());
	}
	
	@Test
	public void convertToEntityAttribute() {
		assertThat(this.typePhoneConverter.convertToEntityAttribute(TypePhoneEnum.CELL_PHONE.getCod())).isEqualTo(TypePhoneEnum.CELL_PHONE);
	}
}
