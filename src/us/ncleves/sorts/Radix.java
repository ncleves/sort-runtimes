package us.ncleves.sorts;

import java.util.ArrayList;
import java.util.Collections;

//import org.apache.log4j.Logger;

public class Radix implements SortingAlgorithm {
	
//	private static Logger LOGGER = Logger.getLogger(Quick.class);

	@Override
	public void sortList(ArrayList<Integer> list) {
		int largestNumber = 0;
		int index = 0;
		
		ArrayList<ArrayList<Integer>> storageUnit = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sortedList = new ArrayList<Integer>(list.size());
		
		for(int i = 0; i < list.size(); i++){
			sortedList.add(list.get(i));
		}
		for(int i = 0; i < 10; i++){
			storageUnit.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > largestNumber){
				largestNumber = list.get(i);
			}
			
		}
		for(int i = 0; largestNumber != 0; largestNumber = largestNumber/10, i++){
			for(int j = 0; j < sortedList.size(); j++){
				int key = (int) (sortedList.get(j)/Math.pow(10, i))%10;
				storageUnit.get(key).add(sortedList.get(j));
			}
			
			for(int k = 0; k < storageUnit.size(); k++){
				for(int l = 0; l < storageUnit.get(k).size(); l++){
					sortedList.set(index, storageUnit.get(k).get(l));
					index++;
				}
				storageUnit.get(k).clear();
			}
			index = 0;
		}
		Collections.copy(list, sortedList);
	}

}
