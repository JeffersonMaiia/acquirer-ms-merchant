package br.com.cabal.acquirer.ms.merchant.core.domain.enums.converter;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.ProductEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class ProductConverter implements AttributeConverter<ProductEnum, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(final ProductEnum productEnum) {
		return productEnum == null ? null : productEnum.getCod();
	}
	
	@Override
	public ProductEnum convertToEntityAttribute(final Integer integer) {
		return ProductEnum.findByCod(integer).orElse(null);
	}
}
