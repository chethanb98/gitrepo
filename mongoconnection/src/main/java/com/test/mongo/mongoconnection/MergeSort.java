package com.test.mongo.mongoconnection;

/* Java program for Merge Sort */
public class MergeSort 
{ 
	void merge(int arr[], int l, int m, int r) 
	{ 
		System.out.println("received arr l m r "+l+" "+m+" "+r);
		printArray(arr); 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		int L[] = new int [n1]; 
		int R[] = new int [n2]; 


		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 


		int i = 0, j = 0; 


		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			int m = (l+r)/2; 
			System.out.println("iteration "+l+" iteration m "+m+" iteration r " + r );
			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 
			System.out.println("before merge operation iteration "+l+" iteration m "+m+" iteration r " + r );
			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 

		System.out.println("Given Array"); 
		printArray(arr); 

		MergeSort ob = new MergeSort(); 
		ob.sort(arr, 0, arr.length-1); 

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
} 

