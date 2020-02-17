package br.com.cabal.acquirer.ms.merchant.core.domain.enums.converter;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.TypePhoneEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class TypePhoneConverter implements AttributeConverter<TypePhoneEnum, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(final TypePhoneEnum typePhoneEnum) {
		return typePhoneEnum == null ? null : typePhoneEnum.getCod();
	}
	
	@Override
	public TypePhoneEnum convertToEntityAttribute(final Integer integer) {
		return TypePhoneEnum.findByCod(integer).orElse(null);
	}
}
