package com.radix.sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSortTest {
	public static void main(String[] args) {
		List<Integer>[] listArr = new ArrayList[10];
		int[] arr = {12,11,4,6,8,9,10,14,376,276,874,27832,4257,65,3546,985768,743,3276723,7327,7,90,123,322,874367};
		RadixSort radixSort = new RadixSort();
		radixSort.sort(arr);
		for(int i=0;i<arr.length;i++) System.out.print(arr[i] + ", ");
		System.out.println();
	}
}
