package us.ncleves.sorts;

import java.util.ArrayList;

//import java.util.Random;
//import org.apache.log4j.Logger;


public class Quick implements SortingAlgorithm {
	
//	private static Logger LOGGER = Logger.getLogger(Quick.class);
	
	@Override
	public void sortList(ArrayList<Integer> list) {
		
		ArrayList<Integer> sortedList = quickSort(list);
		//LOGGER.info("Here is the sorted list: " + sortedList);
		list.clear();
		for (Integer value : sortedList) {
			list.add(value);
		}
		
	}
	
	public ArrayList<Integer> quickSort(ArrayList<Integer> list){
		
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		if(list.size() <= 1){
			return list;
		}
		
		int pivot = list.size()/2;
		int pivotData = list.get(pivot);
		
		list.remove(pivot);
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) > pivotData)
			{
				right.add(list.get(i));
			}
			else
			{
				left.add(list.get(i));
			}
		}
		sortedList = concatinate(quickSort(left), pivotData, quickSort(right));
		return sortedList;
		
	}
	
	public ArrayList<Integer> concatinate(ArrayList<Integer> left, int pivot, ArrayList<Integer> right)
	{
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for(int i = 0; i < left.size(); i++)
		{
			sortedList.add(left.get(i));
		}
		sortedList.add(pivot);
		for(int i = 0; i < right.size(); i++)
		{
			sortedList.add(right.get(i));
		}
		return sortedList;
	}
	
}
	
