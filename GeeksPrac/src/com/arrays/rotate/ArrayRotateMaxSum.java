package com.arrays.rotate;

public class ArrayRotateMaxSum {

	public static void main(String[] args) {
		int arr[] = { 1, 20, 2, 10 };
		findMaxSum(arr);
	}

	public static void findMaxSum(int[] arr) {

		int[] sum = new int[arr.length];
		int count = arr.length - 1;
		while (count >= 0) {
			int tempSm = 0;
			for (int i = 0; i < arr.length; i++) {
				int cnt = count - i >= 0 ? count - i : arr.length + count - i;
				System.out.print(cnt + " ");
				tempSm += cnt * arr[i];
			}
			System.out.println();
			sum[count--] = tempSm;
		}
		System.out.println();
		for (int i = 0; i < sum.length; i++) {
			System.out.print(sum[i] + " ");
		}

		int max = 0;
		for (int i = 0; i < sum.length; i++) {
			if (max < sum[i])
				max = sum[i];
		}

		// System.out.println(max);

	}

}
