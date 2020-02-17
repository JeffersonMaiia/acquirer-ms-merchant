package br.com.cabal.acquirer.ms.merchant.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TypePhoneEnum {
	
	CELL_PHONE(1, "Celular"),
	COMMERCIAL(2, "Comercial"),
	RESIDENTIAL(3, "Residencial");
	
	private Integer cod;
	private String description;
	
	public static Optional<TypePhoneEnum> findByCod(Integer cod){
		return Stream.of(values())
		             .filter(typePhone -> typePhone.getCod().equals(cod))
		             .findFirst();
	}
}
