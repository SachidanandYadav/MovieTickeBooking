package com.v2stech.movieticketbooking.service;

public class test {

	public static void main(String[] args) {

		/*
		 * int a[] = {9,6,7,2,3};
		 * 
		 * 
		 * for(int i = 0; i<a.length;i++) { for(int j=1+i;j<a.length;j++) { int temp =
		 * 0; if(a[i]>a[j]) { temp = a[i]; a[i] = a[j]; a[j] = temp; } }
		 * System.out.println(a[i]); }
		 */
		
//		int a[] = {9,6,7,2,3};
//		int sum = 1;
//		for(int i=0;i<a.length;i++) {
//			sum = sum*a[i];
//		}
//		System.out.println(sum);
		
		int number = 97654; 
		String temp = Integer.toString(number);
		int[] numbers = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
		    numbers[i] = temp.charAt(i) - '0';
		}
		int sum = 1;
		for(int i=0;i<numbers.length;i++) {
			sum = sum* numbers[i];
		}
		System.out.println(sum);
	}

}
