package com.test.mongo.mongoconnection;

import java.util.LinkedList;

public class algorithms {
		  
	     Node head; 
	  
	    static class Node { 
	  
	        int data; 
	        Node next; 
	  
	        Node(int d) { 
	            data = d; 
	            next = null; 
	        } 
	    } 

	public static void main(String []args) {
		
		System.out.println("program for creating my very first few algorithms");
				
        int [] nums = {1,3,4,5,6,2,8,30,40,50,60,70,90,80,20};
                
        int [] result = twosum(nums,28);
        
        System.out.println("the indexes of numbers for target count,first "+result[0]+"second number"+result[1]);
        
        int n =20;
        int desirednum = 6765;
        
        System.out.println("the nth fib num is "+fibnum(n));
        if(desirednum ==1 || desirednum ==0 ) {
        		System.out.println("the fibonacci number indices are 0 or 1");        		
        }		
        else
        {
    		System.out.println("the fibonacci number indices is"+desriredResult(desirednum)[0]);
        }
        
        System.out.println("the "+n+"th fib num is "+recurrsiveFib(n-1));
        
        LinkedListTest();
        algorithms list = new algorithms();
        list.head = new Node(10);
        list.head.next = new Node(15);
        list.head.next.next = new Node(20);
        list.head.next.next.next = new Node(25);
        
	}
	
	public static void PrintList(algorithms list) {
		
	}

	public static int[] desriredResult(int desirednum) {
		
		//for given fibonacci, return index number -- desiredResult
		if(desirednum ==1) {
			return new int[] {0,1};
		}
		else
		{
			int[] num = new int[100];
			num[0]= 1;
			num[1] =1;
			int i =2;
			while (desirednum!=num[i-1]) {
				num[i]=num[i-2]+num[i-1];
				++i;			
			}		
			return new int[] {i};
		}
	}
	
	public static long fibnum(int n) {		
			long [] num = new long[n+1];		
			for (int i=0;i<=n;i++) {
				if(i==0 || i==1) {
					num[0] =1;
					num[1] =1;
				}
				else
				{
				num[i]=num[i-2] +num[i-1]; 
				}
			}
			return num[n-1];
	}
	
	public static long recurrsiveFib(int n) {
		if (n==0)
				return 1;
		else if (n==1)
			return 1;
		else if (n>1)
			return recurrsiveFib(n-1)+recurrsiveFib(n-2);
		else
			throw new IllegalArgumentException("null");
	}
	
	public static void LinkedListTest() {
		
		 LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		 
		   linkedlist.add(1);
	       linkedlist.add(2);
	       linkedlist.add(3);
	       linkedlist.add(4);
	       linkedlist.add(10);
	       	       
	       System.out.println("Linked List Content: " +linkedlist);
	       
	       linkedlist.addFirst(100);
	       linkedlist.addLast(200);
	       
	       System.out.println("LinkedList Content after addition: " +linkedlist);
	       
	       System.out.println("LinkedList next iterator"+linkedlist.listIterator(5).next());

	}
		
	public static int []twosum(int [] a, int b) {
		
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				
				if(b == a[i]+a[j])
					{
						return new int[] {i,j};
					}					
			}
		}
		throw new IllegalArgumentException("number does not exist");
	}
	
}


