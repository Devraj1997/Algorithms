package com.radix.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSort {

	public RadixSort() {
	}
	
	public void sort(int[] arr) {
		int n = arr.length;
		int k=0;
		while(true) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for(int i=0;i<n;i++) {
				int num = arr[i];
				for(int j=0;j<k;j++) num = num/10;
				int key = num%10; 
				map.putIfAbsent(key, new ArrayList<>());
				map.get(key).add(arr[i]);
			}
			int i=0;
			for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
				for(int ele: entry.getValue()) {
					arr[i++] = ele;
				}
			}
			if(map.size()==1) break;
			k++;
		}
	}
}
