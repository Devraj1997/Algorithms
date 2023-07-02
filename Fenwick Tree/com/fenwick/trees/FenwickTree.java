package com.fenwick.trees;

public class FenwickTree {

	private int[] fenwickTree;

	public FenwickTree(int[] arr) {
		this.fenwickTree = new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			updateFenwickTree(i+1, arr[i]);
		}
		print();
	}
	 
	private void updateFenwickTree(int idx, int diff) {
		if(idx >= this.fenwickTree.length) return; 
		this.fenwickTree[idx] += diff;
		idx = idx + (idx & (-idx));
		updateFenwickTree(idx, diff);
	}
	
	public int sumOfRange(int left, int right) {
		return sum(right) - sum(left-1);
	}
	
	private int sum(int idx) {
		int sum = 0;
		idx+=1;
		while(idx > 0) {
			sum += this.fenwickTree[idx]; 
			idx = idx - (idx & -idx);
		}
		return sum;
	}
	
	private void print() {
		for(int i=0;i<this.fenwickTree.length;i++) {
			System.out.print(this.fenwickTree[i] + "=>");
		}
		System.out.println();
	}
}
