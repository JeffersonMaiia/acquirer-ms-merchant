package br.com.cabal.acquirer.ms.merchant.core.domain.enums;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TypePhoneEnumTest {
	
	@Test
	public void findByCod() {
		TypePhoneEnum expected = TypePhoneEnum.CELL_PHONE;
		assertTrue(expected.equals(TypePhoneEnum.findByCod(expected.getCod()).get()));
	}
	
	@Test
	public void getDescription() {
		String expected = TypePhoneEnum.CELL_PHONE.getDescription();
		assertTrue(expected.equals(TypePhoneEnum.CELL_PHONE.getDescription()));
	}
}
