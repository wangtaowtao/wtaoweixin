package com.test;

public class Util {

	public static int[] generatorArray (int n,int number) {
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*number);
		}
		return array;
	}
	
}

