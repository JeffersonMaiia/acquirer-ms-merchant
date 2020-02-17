package br.com.cabal.acquirer.ms.merchant.core.exception.resolver;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowerCaseClassNameResolverTest {
	LowerCaseClassNameResolver lowerCaseClassNameResolver = new LowerCaseClassNameResolver();
	
	@Test
	public void idFromValue() {
		assertTrue(lowerCaseClassNameResolver.idFromValue(LowerCaseClassNameResolver.class).equals("class"));
	}
	
	@Test
	public void idFromValueAndType() {
		String string = new String();
		assertTrue(lowerCaseClassNameResolver.idFromValueAndType(string, String.class).equals("string"));
	}
	
	@Test
	public void getMechanism() {
		assertTrue(lowerCaseClassNameResolver.getMechanism().name().equals("CUSTOM"));
	}
}
