// HW 203, QuickSort
// Name :
// Student ID :

import java.util.*;



class QuickSort {
    int[] arr; // array
	int arrSize;  // number of elements in arr

	QuickSort() { 
		arr = new int[1024];  
		arrSize = 0;
	}

	void swap(int i, int j) {
		int temp;
		temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;
	}
	void Show(int s, int e) { 
		// Show all the element in the arr
		if(s > e)
			return ;
		String str = new String();
		str = "arr : ";

		// print all the nodes in the arr
		for(int i = 0; i < arrSize; i++) {
			if(i == s)
				str += "[";
			else
				str += " ";
			str += arr[i];
			if(i == e)
				str += "]";
			else
				str += " ";
		}
		System.out.println( str);
	}

	void  Init(int[] es, int n) {	
		// fill the arr array by the input
		arrSize = n;
		for(int i = 0; i < n; i++)
			arr[i] = es[i];
	}


	void  Sort() {
		// sort arr[0:arrSize-1] into nonincreasing order
		// This is an invoking method to the Partition() and QSort() 
		QSort(0, arrSize - 1);	// quick sort from 0 to n-1
	}
 


	void  QSort(int s, int e) {	
		// sort arr[s:e] into nonincreasing order
		System.out.println("Sort in [" + s + "," + e + "]");
		Show(s, e);

		if(s >= e)
			return;
		int m = (s+e)/2;
		int pivot;
	    int temp;
		

		
       int apos = s;
       int bpos = e+1;
       pivot = arr[apos];
       do {
        	do {
        		apos++;
        	}while(arr[apos]>pivot);
        	do {
        		bpos--;
        	}while(arr[bpos]<pivot );
        	if(apos< bpos) {
        		temp = arr[apos];
        		arr[apos]=arr[bpos];
              arr[bpos] = temp;
        	}
       }while(apos<bpos);

       
       temp = arr[s];
       arr[s]=arr[bpos];
      	arr[bpos]=temp;

       QSort(s, bpos-1);
       QSort(bpos+1, e);
	}
}
