package br.ce.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ce.hscastro.util.JPAUtil;

class TestJPAUtil {

	@Test
	void test() {
		JPAUtil.getEntityManager();
		fail("Not yet implemented");
	}

}
