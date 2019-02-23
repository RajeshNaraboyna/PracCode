package com.arrays.rotate;

public class FIndRotationCount {

	public static void main(String[] args) {
		int[] arr = { 15, 18, 19, 3, 6, 12 };
		getRotationCnt(arr);
	}

	public static void getRotationCnt(int[] arr) {
		int keyPrev = -1;
		int i = 0;
		boolean inc = false;
		for (i = 0; i < arr.length; i++) {
			if (keyPrev == -1) {
				keyPrev = arr[i];
				if (keyPrev > arr[i + 1])
					inc = false;
				else
					inc = true;
			} else {
				if ((keyPrev < arr[i] && !inc))
					break;
				else if ((keyPrev > arr[i] && inc))
					break;

				keyPrev = arr[i];
			}
		}
		System.out.println(i - 1);
	}
}
