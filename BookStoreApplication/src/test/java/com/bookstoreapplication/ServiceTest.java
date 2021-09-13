package com.bookstoreapplication;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstoreapplication.service.BookStoreServiceImpl;

@SpringBootTest
class ServiceTest {

	@Autowired
	BookStoreServiceImpl svc;
	
	@Test
	public void testCalcDiscountRange1() {
		assertEquals(0,svc.calcDiscount(1000),0.001);
	}

	@Test
	public void testCalcDiscountRange2() {
		assertEquals(600,svc.calcDiscount(3000),0.001);
	}

	@Test
	public void testCalcDiscountRange3() {
		assertEquals(2000,svc.calcDiscount(5000),0.001);
	}

	@Test
	public void testCalcDiscountRange4() {
		assertEquals(3600,svc.calcDiscount(6000),0.001);
	}

	@After
	public void teardown() {
		svc = null;
	}

}
