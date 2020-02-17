package br.com.cabal.acquirer.ms.merchant.core.domain.enums.converter;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.ProductEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProductConverterTest {
	
	@InjectMocks
	private ProductConverter productConverter;
	
	@Test
	public void convertToDatabaseColumn() {
		ProductEnum productEnum = ProductEnum.CREDIT;
		assertThat(this.productConverter.convertToDatabaseColumn(productEnum)).isEqualTo(productEnum.getCod());
	}
	
	@Test
	public void convertToEntityAttribute() {
		ProductEnum productEnum = ProductEnum.CREDIT;
		assertThat(this.productConverter.convertToEntityAttribute(productEnum.getCod())).isEqualTo(productEnum);
	}
}
