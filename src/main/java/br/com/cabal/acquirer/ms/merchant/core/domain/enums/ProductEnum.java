package br.com.cabal.acquirer.ms.merchant.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum ProductEnum {

	DEBIT(1, "Débito"),
	CREDIT(2, "Crédito"),
	CREDIT_PARCEL(3, "Crédito Parcelado");
	
	private Integer cod;
	private String description;
	
	public static Optional<ProductEnum> findByCod(Integer cod){
		return Stream.of(values())
				.filter(product -> product.getCod().equals(cod))
				.findFirst();
	}
	
}
