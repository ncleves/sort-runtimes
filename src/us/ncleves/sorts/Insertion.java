package us.ncleves.sorts;

import java.util.ArrayList;

public class Insertion implements SortingAlgorithm {

	@Override
	public void sortList(ArrayList<Integer> list) {
		for(int i = 1; i < list.size(); i++){
			int temp = list.get(i);
			int j = i;
			while(j > 0 && temp < list.get(j - 1)){
				list.set(j, list.get(j - 1));
				j--;
				
			}
			list.set(j, temp);
			
		}

	}

}
