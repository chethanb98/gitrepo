package com.test.mongo.mongoconnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class helloWorld {
	public static void main(String[] args) {

		System.out.println("this is fibonaci series");
	
        int n = 10;
        long[] fib = generateFibonaccis(n);
        for (int i = 0; i < n; i++) {
            System.out.print(Long.toUnsignedString(fib[i]) + " ");
        }
        int [] nums = {2,8,20,40};
        twosum(nums,28);
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        list.add(3);
        list.add(3);
        list.add(3);
        
        PrintLinkedList(list);
        PrintReverseLinkedList(list);
        SumTwoLinkedList(list, list);
                
        System.out.println("print the highest num\t"+HighestNum(new int[] {4,10,2,22,44,56,8,10,12}));
        
        int [] a = {1,1,2,2,2,4,4,4,5,5,5,6,5,4,7,9,10};
        
        Map<Integer,Integer> count = ArrayMissingNumbs(a);
        for(int i= 1; i<=HighestNum(a);i++) {
        		if(count.containsKey(i)) {
        		System.out.println(i+" -----> "+count.get(i));
        		}
        		else {
        			System.out.println(+i+" -----> "+0);
        		}
        }
        
        String givenString = "This is google";
        
        String [] arr = givenString.split(" ");
        
        System.out.println("arr arr 2 arr 3 "+arr[0]+" "+arr[1]+" "+arr[2]);
        
        StingSplitRecursive(arr);
	}
	
	public static void PrintLinkedList(LinkedList<Integer> list) {
		
		System.out.println("print of list of LinkedList");

		Iterator<Integer> itr = list.iterator();
	
		    while(itr.hasNext())
		    {
		    	System.out.print(itr.next());
		    }    
	}
	
	public static void PrintReverseLinkedList(LinkedList<Integer> list) {
		Iterator<Integer> descItr = list.descendingIterator();
		
		System.out.println("print of list of reversed LinkedList");
		
		 while(descItr.hasNext())
		    {
		    	System.out.print(descItr.next());
		    }  
	}
		
	public static void SumTwoLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		
		if((list1.get(2)+list2.get(2))>9){
			
			int x =(list1.get(2)+list2.get(2))/10;
			int y =(list1.get(2)+list2.get(2))%10;
			
			if((list1.get(1)+list2.get(1)+x)>9) {
				int z = (list1.get(1)+list2.get(1)+x)/10;
				int z1 = (list1.get(1)+list2.get(1)+x)%10;
				list3.add((list1.get(0)+list2.get(0)+z));
				list3.add(z1);
				list3.add(y);
			}
			else
			{
				list3.add((list1.get(0)+list2.get(0)));
				list3.add((list1.get(1)+list2.get(1)+x));
				list3.add(y);
			}
		}
		else {
			if((list1.get(1)+list2.get(1))>9) {
				int z = (list1.get(1)+list2.get(1))/10;
				int z1 = (list1.get(1)+list2.get(1))%10;
				list3.add((list1.get(0)+list2.get(0))+z);
				list3.add(z1);
				list3.add(list1.get(2)+list2.get(2));
			}
			else
			{
				list3.add((list1.get(0)+list2.get(0)));
				list3.add(list1.get(1)+list2.get(1));
				list3.add(list1.get(2)+list2.get(2));
			}
		}
		PrintLinkedList(list3);		
	}

	public static void RecursiveSumLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
	 // yet to implement	
	}

	public static long[] generateFibonaccis(int n) {		
		// fibonacci series for a given number
        long[] fib = new long[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; ++i) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib;
    }
	
	public static int[]twosum(int []nums,int target)
	{
		// Given a array of number and a target (sum of two numbers)
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i=0;i<nums.length;i++)
		{
			int complement = target - nums[i];
			if(map.containsKey(complement))
			{
				System.out.println("the indices for the target number"+i+map.get(complement));
				return new int[] {i,map.get(complement)};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("number does not exist");		
	}
	
	public static int lengthOfLongestSubstring(String s) {
        String [] newString = new String [] {s};
        Character ch = s.charAt(2);
        System.out.println("character of string to index"+ch);
		int count =0;
        for(int i=0;i<s.length();i++)
        {
        		if(newString[i]!=newString[i+1])
        		{
        			count=count+1;
        		}
        }
        return count;
    }

	public static int HighestNum(int[] a) {
		int[] b =a;
		int gr =a[0];
		for(int i=0;i<a.length;i++) {
				if(gr<a[i]) {
					gr =b[i];
				}			
		}
		return gr;
	}

	public static Map<Integer,Integer> ArrayMissingNumbs(int [] a) {
		int count = 0;
		Map<Integer,Integer> mapCount = new HashMap<Integer,Integer>();
		System.out.println("array length is "+HighestNum(a));
		for(int i=0;i<a.length;i++) {
				for(int j=0;j<a.length;j++) {					
					if(a[j]==a[i]) {						
						count++;		
					}	
				}
				if(!mapCount.containsKey(a[i])) {
					mapCount.put(a[i], count);					
				}
				count=0;
		}
		return mapCount;
	}

	public static void StingSplitRecursive(String [] a) {
		
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
			System.out.println("the phrases formed are "+a[i]+" "+a[j]);
			}
		}
		System.out.println("");
	}
	
	public static void recursiveString(String[] a, int length) {
		int count =1;
		String []newarray = new String [10];
		List<Integer> list = new ArrayList<>();
		Set<Character> set = new HashSet<>();
		Map<Integer,Integer> map = new HashMap<>();
		while(count!=length) {
			if(count ==1) {
				for (int i=0;i<a.length;i++)
				System.out.println("the phrases formed are "+a[i]);
			}
			else if(count>1) {

			}
		String total = a[length] +a[length-1];
		}		
	}
}