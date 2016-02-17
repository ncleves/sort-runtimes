package us.ncleves.sorts;

import java.util.ArrayList;

public class Bubble implements SortingAlgorithm {

	@Override
	public void sortList(ArrayList<Integer> list) {
		boolean swapped = true;
		for(int i = list.size() - 1; i > 0 && swapped; i--){
			swapped = false;
			for(int j = 0; j < i; j++){
				if(list.get(j) > list.get(j + 1)){
					int temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
					swapped = true;
				}
			}
		}

	}

}
