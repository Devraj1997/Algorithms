package com.fenwick.trees;

public class FenwickTreeTest {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11};
		FenwickTree fenwickTree = new FenwickTree(arr);
		System.out.println(fenwickTree.sumOfRange(0, arr.length-1));
		System.out.println(fenwickTree.sumOfRange(0, arr.length-2));
		System.out.println(fenwickTree.sumOfRange(0, arr.length-3));
		System.out.println(fenwickTree.sumOfRange(0, arr.length-4));
		System.out.println(fenwickTree.sumOfRange(1, arr.length-1));
		System.out.println(fenwickTree.sumOfRange(3, arr.length-1));
	}
}
