package us.ncleves.sorts;

import java.util.ArrayList;

public class Selection implements SortingAlgorithm {
	
	public Selection(){
		
	}
	
	@Override
	public void sortList(ArrayList<Integer> list) {
		for(int i = 0; i < list.size() - 1; i++)
		{
			int index = i;
			for(int j = i + 1; j < list.size(); j++)
			{
				if(list.get(j) < list.get(index)){
					index = j;
				}
				
			}
			int smallerNumber = list.get(index);
			list.set(index, list.get(i));
			list.set(i, smallerNumber);
		}
	
		
	}

}
