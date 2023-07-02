package com.segment.trees.lazy.propagation;

public class SegmentTree {

	private int[] tree;
	private int[] lazyTree; 
	
	public SegmentTree(int n, int[] nums) {
		int power = (int) Math.ceil(Math.log(n)/Math.log(2));
		int size = 2 * (int)Math.pow(2, power) - 1; 
		tree = new int[size];
		lazyTree = new int[size]; 
		constructSegmentTree(0, n-1, 0, nums);
	}
	
	private int constructSegmentTree(int startIdx, int endIdx, int treeIdx, int[] nums) {
		if(startIdx == endIdx) {
			this.tree[treeIdx] = nums[startIdx];
			return nums[startIdx];
		}
		int mid = startIdx + (endIdx - startIdx)/2; 
		int left = constructSegmentTree(startIdx, mid, treeIdx * 2 + 1, nums);
		int right = constructSegmentTree(mid + 1, endIdx, treeIdx * 2 + 2, nums);
		this.tree[treeIdx] = Math.min(left, right);
		return this.tree[treeIdx]; 
	}
	
	public int updateSegmentTree(int startRange, int endRange, int delta, int low, int high, int pos) {
		if(low > high) return Integer.MAX_VALUE;
		
		if(this.lazyTree[pos] != 0) {
			tree[pos] += lazyTree[pos];
			if(low != high) {
				lazyTree[2 * pos + 1] += lazyTree[pos];
				lazyTree[2 * pos + 2] += lazyTree[pos];
			}
			lazyTree[pos] = 0;
		}
		
		if(startRange > high || endRange < low) return Integer.MAX_VALUE;
		
		if(startRange <= low && endRange >= high) {
			tree[pos] += delta;
			if(low!=high) {
				lazyTree[2 * pos+1] += delta;
				lazyTree[2 * pos+2] += delta;
			}
			return tree[pos];
		}
		
		int mid = low + (high - low)/2;
		int left = updateSegmentTree(startRange, endRange, delta, low, mid, pos*2 + 1);
		int right = updateSegmentTree(startRange, endRange, delta, low, mid, pos*2 + 2);
		this.tree[pos] = Math.min(left, right);
		return this.tree[pos]; 
	}
	
	public int getMin(int startRange, int endRange, int low, int high, int pos) {
		if(low > high) return Integer.MAX_VALUE;
		
		if(this.lazyTree[pos] != 0) {
			tree[pos] += lazyTree[pos];
			if(low != high) {
				lazyTree[2 * pos + 1] += lazyTree[pos];
				lazyTree[2 * pos + 2] += lazyTree[pos];
			}
			lazyTree[pos] = 0;
		}
		
		if(startRange > high || endRange < low) return Integer.MAX_VALUE;
		
		if(startRange <= low && endRange >= high) {
			return tree[pos];
		}
		
		int mid = low + (high - low)/2;
		int left = getMin(startRange, endRange, low, mid, pos*2 + 1);
		int right = getMin(startRange, endRange, low, mid, pos*2 + 2);
		return Math.min(left, right); 
	}
}
