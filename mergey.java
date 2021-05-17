package algos;

import java.util.ArrayList;
import java.util.Arrays;

public class mergey {

	private ArrayList<Integer> arr;
	
	//null constructor
	public mergey() {
		this.arr = null;
	}
	
	//constructor with input arraylist
	public mergey(ArrayList<Integer> al) {
		this.arr = al;
	}
	
	// TODO add merge method which takes two arrays as input and combines in sorted order
	// uses while loops to accomplish this
	// assumes input arrays are sorted
	public ArrayList<Integer> merger(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		int arr1Length = arr1.size();
		int arr2Length = arr2.size();
		int i=0, j=0;
		
		while((i < arr1Length) && (j < arr2Length)) {
			if(arr1.get(i) <= arr2.get(j)) {
				arr3.add(arr1.get(i));
				i++;
			} else {
				arr3.add(arr2.get(j));
				j++;
			}
		}
		
		while(i < arr1Length) {
			arr3.add(arr1.get(i));
			i++;
		}
		
		while(j < arr2Length) {
			arr3.add(arr2.get(j));
			j++;
		}
		
		return arr3;
	}
	
	public void mergerTester() {
		// test case, sorted and same size
		ArrayList<Integer> test1Array1 = new ArrayList<>(Arrays.asList(1,3,5,7));
		ArrayList<Integer> test1Array2 = new ArrayList<>(Arrays.asList(2,4,6,8));
		System.out.println("Test 1");
		System.out.println("array 1: " + test1Array1);
		System.out.println("array 2: " + test1Array2);
		System.out.println("merged array: " + merger(test1Array1, test1Array2)+"\n");
		
		// test case, sorted and different sizes
		ArrayList<Integer> test2Array1 = new ArrayList<>(Arrays.asList(1,3,5,7,9,11,13,15,17));
		ArrayList<Integer> test2Array2 = new ArrayList<>(Arrays.asList(2,9,19));
		System.out.println("Test 2");
		System.out.println("array 1: " + test2Array1);
		System.out.println("array 2: " + test2Array2);
		System.out.println("merged array: " + merger(test2Array1, test2Array2) + "\n");
		
		// test case, one empty array
		ArrayList<Integer> test3Array1 = new ArrayList<>(Arrays.asList(1,3,5,7,9,11,13,15,17));
		ArrayList<Integer> test3Array2 = new ArrayList<>();
		System.out.println("Test 3");
		System.out.println("array 1: " + test3Array1);
		System.out.println("array 2: " + test3Array2);
		System.out.println("merged array: " + merger(test3Array1, test3Array2) + "\n");		
	}
	
	// TODO add mergesort method which:
	// returns array if size is one
	// splits the input array in half and assigns to two new arrays mer1 and mer2
	// call mergesort on each of mer1 and mer2
	// call merger on mer1 and mer2
	public ArrayList<Integer> mergesort(ArrayList<Integer> arr){
		
		if(arr.size() <= 1) {
			return arr;
		}
		
		int mid = arr.size()/2;
		ArrayList<Integer> leftSide = new ArrayList<Integer>();
		ArrayList<Integer> rightSide = new ArrayList<Integer>();
		
		for(int i = 0; i< arr.size(); i++) {
			if(i < mid) {
				leftSide.add(arr.get(i));
			} else {
				rightSide.add(arr.get(i));
			}
		}
		
		leftSide = mergesort(leftSide);
		rightSide = mergesort(rightSide);
		return merger(leftSide,rightSide);
		
	}
	
	
	public static void main(String[] args) {
		
		// merging of sorted lists test, passed initial tests
		//mergey tester = new mergey();
		//tester.mergerTester();
		
		//create arraylist to be sorted
		ArrayList<Integer> arra = new ArrayList<Integer>();
		for(int i = 0; i<10; i++) {
			int p = (i%2)*10 + i;
			arra.add(p);
		}
		
		mergey m = new mergey(arra);
		System.out.println(arra);
		System.out.println(m.mergesort(arra));
	}


	public ArrayList<Integer> getArr() {
		return arr;
	}


	public void setArr(ArrayList<Integer> arr) {
		this.arr = arr;
	}

}
