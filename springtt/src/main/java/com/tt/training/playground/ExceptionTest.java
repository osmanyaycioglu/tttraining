package com.tt.training.playground;

import java.util.UUID;

public class ExceptionTest {
	public static void main(String[] args) {
		long delta = System.currentTimeMillis();
		for (int i = 0; i < 10_000; i++) {
			UUID.randomUUID().toString();
		}
		System.out.println("Delta : " + (System.currentTimeMillis() -  delta));

		delta = System.currentTimeMillis();
		for (int i = 0; i < 10_000; i++) {
			try {
				UUID.randomUUID().toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Delta : " + (System.currentTimeMillis() -  delta));
	
		delta = System.currentTimeMillis();
		for (int i = 0; i < 10_000; i++) {
			try {
				UUID.randomUUID().toString();
			} catch (Exception e) {
			}
		}
		System.out.println("Try Delta : " + (System.currentTimeMillis() -  delta));

		delta = System.currentTimeMillis();
		for (int i = 0; i < 10_000; i++) {
			try {
				test2();
			} catch (Exception e) {
				//e.getStackTrace();
			}
		}
		System.out.println("Exception Delta : " + (System.currentTimeMillis() -  delta));

	}
	
	public static String test2() throws Exception {
		return test1();
	}

	public static String test1() throws Exception {
		return test();
	}

	public static String test() throws Exception {
		String string = UUID.randomUUID().toString();
		if (string.length() > 4) {
			throw new Exception();
		}
		return string;
	}
}
