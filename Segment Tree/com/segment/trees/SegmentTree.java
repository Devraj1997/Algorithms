package com.segment.trees;

public class SegmentTree {

	private int[] tree;
	private int numsLen;
	
	public SegmentTree(int n, int[] nums) {
		this.numsLen = n;
		int power = (int) Math.ceil(Math.log(n)/Math.log(2));
		int size = 2 * (int)Math.pow(2, power) - 1; 
		tree = new int[size];
		constructSegmentTree(nums, 0, n-1, 0);
		print();
	}
	
	private int constructSegmentTree(int[] nums, int numsStartIdx, int numsEndIdx, int treeIdx) {
		if(numsStartIdx==numsEndIdx) {
			tree[treeIdx] = nums[numsStartIdx];
			return tree[treeIdx];
		}
		int mid = numsStartIdx + (numsEndIdx - numsStartIdx)/2;
		int val = constructSegmentTree(nums, numsStartIdx, mid, treeIdx * 2 + 1) + constructSegmentTree(nums, mid + 1, numsEndIdx, treeIdx * 2 + 2);
		tree[treeIdx] = val;
		return val;
	}
	
	public int fetchValue(int queryStart, int queryEnd) {
		if(queryEnd < queryStart) return 0;
		if(queryEnd < 0) return 0;
		if(queryStart >= this.numsLen) return 0;
		return fetchValue(queryStart, queryEnd, 0, numsLen-1, 0);
	}
	
	private int fetchValue(int queryStart, int queryEnd, int numsStart, int numsEnd, int treeIdx) {
		
		if(numsStart >= queryStart && numsEnd <= queryEnd) return this.tree[treeIdx];
		if(numsStart > queryEnd || numsEnd < queryStart) return 0;
		
		int mid = numsStart + (numsEnd - numsStart)/2;
		return fetchValue(queryStart, queryEnd, numsStart, mid, treeIdx * 2 + 1) + fetchValue(queryStart, queryEnd, mid + 1, numsEnd, treeIdx * 2 + 2);
	}
	
	public void update(int idx, int num) {
		if(idx < 0 || idx >= numsLen) return;
		updateUtil(0, numsLen-1, idx, 0, num);
	}
	
	private int updateUtil(int numsStartIdx, int numsEndIdx, int idx, int treeIdx, int newVal) {
		if(idx < numsStartIdx || idx > numsEndIdx) return 0;
		if(numsStartIdx == numsEndIdx && idx == numsStartIdx) {
			int diff = newVal - tree[treeIdx];
			tree[treeIdx] = newVal;
			return diff;
		}
		int mid = numsStartIdx + (numsEndIdx - numsStartIdx)/2;
		int diff = 0;
		if(idx >= numsStartIdx && idx <= mid) {
			diff = updateUtil(numsStartIdx, mid, idx, treeIdx * 2 + 1, newVal);
		} else {
			diff = updateUtil(mid + 1, numsEndIdx, idx, treeIdx * 2 + 2, newVal);
		}
		tree[treeIdx] += diff;
		return diff;
	}
	
	
	private void print() {
		for(int i=0;i<tree.length;i++)
			System.out.print(tree[i] + "=>");
		System.out.println();
	}
}
