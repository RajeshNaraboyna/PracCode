package com.arrays.rotate;

public class ArrayRotate {
	// Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
	// elements.
	public static void main(String[] arg) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		rotateArr(arr, 3);
		for (int sys = 0; sys < arr.length; sys++) {
			System.out.println(arr[sys]);
		}
	}

	public static void rotateArr(int[] arr, int r) {
		int[] temp = new int[r];
		for (int i = 0; i < r; i++) {
			temp[i] = arr[i];
		}
		for (int i = 0; i < (arr.length - r); i++) {
			arr[i] = arr[i + r];
			if (i + 1 == arr.length - r) {
				for (int j = 0; j < temp.length; j++) {
					arr[++i] = temp[j];
				}
			}
		}

	}

}
