package us.ncleves.sorts;

import java.util.ArrayList;
//import java.util.Collections;

//import org.apache.log4j.Logger;

public class Merge implements SortingAlgorithm {
	
//private static Logger LOGGER = Logger.getLogger(Merge.class);


	@Override
	public void sortList(ArrayList<Integer> list) {
		if(list.size() > 1){
			int elementsInA1 = list.size()/2;
			int elementsInA2 = list.size() - elementsInA1;
			
			//LOGGER.info("Values of elementsInA1: " + elementsInA1 + " elementsInA2: " + elementsInA2);

			ArrayList<Integer> arr1 = new ArrayList<Integer>(elementsInA1);
			ArrayList<Integer> arr2 = new ArrayList<Integer>(elementsInA2);
			
			//LOGGER.info("Values of arr1: " + arr1);
			
			for(int i = 0; i < elementsInA1; i++){
				//LOGGER.info("Values of i: " + i);
				arr1.add(i, list.get(i)); //this is meant to be equivalent to arr1[i] = array[i];
			}
			
			for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++){
				arr2.add((i - elementsInA1), list.get(i));
			}
			
			sortList(arr1);
			sortList(arr2);
			
			//LOGGER.info("Values of arr1: " + arr1 + "arr2: " + arr2);

			int i = 0, j = 0, k = 0;

			while(arr1.size() != j && arr2.size() != k){
				if(arr1.get(j) < arr2.get(k)){
					list.set(i, arr1.get(j));
					i++;
					j++;
				}else{
					list.set(i, arr2.get(k));
					i++;
					k++;
				}
			}
			while(arr1.size() != j){
				list.set(i, arr1.get(j));
				i++;
				j++;
			}
			while(arr2.size() != k){
				list.set(i, arr2.get(k));
				i++;
				k++;
			}

		}

	}

}
