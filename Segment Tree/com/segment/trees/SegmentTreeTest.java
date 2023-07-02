package com.segment.trees;

public class SegmentTreeTest {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11};
		SegmentTree segmentTree = new SegmentTree(arr.length, arr);
		System.out.println(segmentTree.fetchValue(0, 10));
		segmentTree.update(1, 13);
		System.out.println(segmentTree.fetchValue(1, 1));
		System.out.println(segmentTree.fetchValue(0, 5));
		System.out.println(segmentTree.fetchValue(0, 2));
		System.out.println(segmentTree.fetchValue(2, 5));
		System.out.println(segmentTree.fetchValue(4, 13));
		segmentTree.update(4, 19);
		System.out.println(segmentTree.fetchValue(4, 4));
		segmentTree.update(5, 21);
		System.out.println(segmentTree.fetchValue(5, 5));
		System.out.println(segmentTree.fetchValue(3, 30));
		System.out.println(segmentTree.fetchValue(10, 6));
		System.out.println(segmentTree.fetchValue(0, 5));
	}
}
