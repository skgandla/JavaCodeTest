package com.java.example.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.java.example.service.ConvertToWord;
import com.java.example.serviceImple.ConvertToWordImple;

public class ConvertToWordTest {
	
	ConvertToWord cw = new ConvertToWordImple();
	
	@Test
	public void firstTest() throws IOException {
		int res =cw.convToWord(3456, 0);
		assertNotNull(res);
		assertEquals(0, res);
	}
	
	
	@Test
	public void secondTest() throws IOException {
		int res =cw.convToWord(0, 0);
		assertNotNull(res);
		assertEquals(0, res);
	}
	
	@Test
	public void negativeTest() throws IOException {
		int res =cw.convToWord(-343, 0);
		//System.out.println(res);
		assertNotNull(res);
		assertEquals(1, res);
	}

}
