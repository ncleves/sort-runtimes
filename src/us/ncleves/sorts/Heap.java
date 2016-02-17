package us.ncleves.sorts;

import java.util.ArrayList;

public class Heap implements SortingAlgorithm {

	@Override
	public void sortList(ArrayList<Integer> list) {
		int count = list.size();
		heapify(list, count);
		int end = count - 1;
		while(end > 0){
			swap(list, end, 0);
			end = end - 1;
			shiftDown(list, 0, end);
		}

	}
	public void heapify(ArrayList<Integer> list, int count){
		int start = count/2 - 1;
		while(start >= 0){
			shiftDown(list, start, count - 1);
			start -= 1;
		}
	}
	public void shiftDown(ArrayList<Integer> list, int start, int end){
		int root = start;
		while(root*2+1 <= end){
			int child = root*2+1;
			int swap = root;
			if(list.get(swap) < list.get(child)){
				swap = child;
			}
			if(child+1 <= end && list.get(swap) < list.get(child+1)){
				swap = child+1;
			}
			if(swap != root){
				swap(list, root, swap);
				root = swap;
			}else{
				return;
			}

		}
		
	}
	public void swap(ArrayList<Integer> list, int swapOne, int swapTwo){
		int holder = list.get(swapOne);
		list.set(swapOne, list.get(swapTwo));
		list.set(swapTwo, holder);
	}

}
