package com.dominion.test;

public class Test {

	public static void main(String[] args) {

		int arr[] = { 9, 1, 0, 3, 2 };
		int x = 6;
		System.out.println(checkForSum(arr, x));
	}

	public static String checkForSum(int[] arr, int x) {
		int start = 0, end = 0;
		int sum = 0;
		int startValue = arr[0];
		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];
			if (sum == x) {
				return "output is betwden " + start + "and " + i;
			} else if (sum < x) {
				for (int j = i + 1; j < arr.length; j++) {

					sum += arr[j];
					if (sum == x) {
						return "output is betwden " + start + "and " + j;
					} else if (sum > x) {
						break;
					}

				}
				if (start == arr.length) {
					return "-1";
				}
			} else {
				start++;
				sum = sum - startValue;

				if ((start + 1) < arr.length)
					;
				startValue = arr[start + 1];
			}

		}
		return "-1";
	}

	public static String checkForSumModified(int[] arr, int x) {

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum = arr[i];
			for (int j = i + 1; j <= arr.length; j++) {
				if (sum == x) {
					return "output: between " + i + "and " + (j - 1);
				}
				if (sum > x) {
					break;
				}
				sum += arr[j];
			}

		}
		return "-1";
	}
}