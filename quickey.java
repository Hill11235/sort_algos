package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class quickey {

	//null constructor
	public quickey() {
	}
	
	public Integer parto(List<Integer> a1, int pivot) {
		
		int lefty = 0;
		int righty = a1.size() - 1;
		
		while(lefty < righty) {

			while(a1.get(lefty) < pivot) {
				lefty++;
			}
			while(a1.get(righty) > pivot) {
				righty--;
			}
			if(lefty >= righty) {
				return righty;
			}
			Collections.swap(a1,lefty, righty);
			lefty++;
			
		}
		return righty;
	}
	
	public List<Integer> quickSort(List<Integer> a1) {
		
		if(a1.size() <= 1) {
			return a1;
		}
		
		int mid = a1.size()/2;
		int pivot = a1.get(mid);
		
		int righty = parto(a1, pivot);
		
		List<Integer> leftSide = a1.subList(0, righty);
		List<Integer> rightSide = a1.subList(righty, a1.size());
		
		quickSort(leftSide);
		quickSort(rightSide);
		
		return a1;
	}
	
	public void quickSortTester() {
		
		// test case, easy peasy
		ArrayList<Integer> test1Array1 = new ArrayList<>(Arrays.asList(9,3,1,7));
		System.out.println("Test 1");
		System.out.println("array: " + test1Array1);
		System.out.println("sorted array: " + quickSort(test1Array1)+"\n");
		
		// test case, reverse order
		ArrayList<Integer> test2Array1 = new ArrayList<>(Arrays.asList(9,7,3,2,1));
		System.out.println("Test 2");
		System.out.println("array: " + test2Array1);
		System.out.println("sorted array: " + quickSort(test2Array1) + "\n");
		
		// test case, already sorted
		ArrayList<Integer> test3Array1 = new ArrayList<>(Arrays.asList(1,3,5,7,9,11,13,15,17));
		System.out.println("Test 3");
		System.out.println("array: " + test3Array1);
		System.out.println("sorted array: " + quickSort(test3Array1) + "\n");
		
		// test case, contains some duplicates
		ArrayList<Integer> test4Array1 = new ArrayList<>(Arrays.asList(1,18,5,1,4));
		System.out.println("Test 4");
		System.out.println("array: " + test4Array1);
		System.out.println("sorted array: " + quickSort(test4Array1) + "\n");
		
		// test case, all same
		ArrayList<Integer> test5Array1 = new ArrayList<>(Arrays.asList(1,1,1,1,1));
		System.out.println("Test 5");
		System.out.println("array: " + test5Array1);
		System.out.println("sorted array: " + quickSort(test5Array1) + "\n");	
		
	}
	
	public static void main(String[] args) {
		quickey Quick1 = new quickey();
		Quick1.quickSortTester();
	}
}
