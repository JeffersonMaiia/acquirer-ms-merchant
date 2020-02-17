package br.com.cabal.acquirer.ms.merchant.core.domain.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductEnumTest {
	
	@Test
	public void findByCod() {
		ProductEnum productEnum = ProductEnum.CREDIT;
		assertTrue(productEnum.equals(ProductEnum.findByCod(productEnum.getCod()).get()));
	}
	
	@Test
	public void getDescription() {
		String product = ProductEnum.CREDIT.getDescription();
		assertTrue(product.equals(ProductEnum.CREDIT.getDescription()));
	}
}
