package com.arrays.rotate;

public class SortedRotArray {
	public static void main(String[] arg) {
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int key = 6;
		int lo = (key > arr[0]) ? 0 : arr.length - arr[0] + 1;
		int max = (key > arr[0]) ? arr.length - (arr[0] - 2) : arr.length;
		System.out.println(getPosition(arr, key, lo, max));
	}

	public static int getPosition(int[] arr, int key, int lo, int max) {
		if (lo > max) {
			return -1;
		}
		int mid = lo + (max - lo) / 2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] < key) {
			return getPosition(arr, key, mid + 1, max);
		} else {
			return getPosition(arr, key, lo, mid - 1);
		}
	}

}
