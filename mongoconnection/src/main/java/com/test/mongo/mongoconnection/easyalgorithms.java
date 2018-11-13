package com.test.mongo.mongoconnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class easyalgorithms {

	public static void main(String []args) {
		
		System.out.println("reverse num of "+reverseInteger(1234));
		
		System.out.println("is polyndrome "+isPolyndrome(101));
		
		System.out.println("is polyndrome without string "+isPolyndromeWithoutString(1221));
		
		System.out.println("roman to integer"+romanToInteger("DM"));
		
		System.out.println("longest common string "+longestCommonPreString("abcxyzji","abcxyzji"));
		
		System.out.println("recursive call of array "+recursiveCall(new String[] {"flower","flow","flight"}));
		
		String s = "abcefg";
		System.out.println("index of string "+s.indexOf("efg")+"test substring "+s.substring(0,1));
		
		System.out.println("isValidParentheses string "+isValidParentheses(""));
		
		System.out.println("reverse of string "+reverseString("god"));
		
		LinkedList<String> list1 =new LinkedList<String>();
		LinkedList<String> list2 =new LinkedList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list2 =list1;
//		list2.add("1");
//		list2.add("2");
//		list2.add("3");
		mergeSortedList(list1,list2);
		
		int [] nums = new int[] {1,1,1,2};
		int len =removeDuplicates(nums);
		System.out.println("remove the duplciates of "+len);
		
		for(int i =0;i<len;i++) {
			System.out.println("the next number is "+nums[i]);
		}
		
		System.out.println("result of pairs"+pairs(new int[] {1,1,2,2}));
		
		System.out.println("count valley String "+countingValleys(4,"DDUU"));
		
		System.out.println("valid bst os given is "+validPreTraversalBST(new int [] {4,3,2,7}, 4));
		
		nextGreaterElement(new int [] {11,13,21,3});
		
		tworepeatingElements(new int [] {4,2,4,5,2,3,1});
		repeatingElements(new int[] {4,2,4,5,2,3,1});
	}
	
	public static int reverseInteger(int n) {	
		int x=n;
		int y=0;
		int reverse = 0;		
		while(x!=0) {
			y =x%10;
			x=x/10;			
			reverse = reverse*10+y;			
		}
		return reverse;
	}
	
	public static boolean isPolyndrome(int x) {
		     
	        String []s = Integer.toString(x).split("");
	        int length = s.length;
	        System.out.println("Given length"+length);
	        int count = 0;
	        if((length)%2 ==0 || x<0)   {
	            return false;
	        }
	        else{
	        		int k =s.length-1;
	            for(int i=0;i<s.length;i++){
	                if(s[i].equals(s[k]))
	                {	                   
	                    count =count+1;
	                }
	                k--;
	            }
	            if(count == length)
	            {
	                return true;
	            }
	        }
	                    return false;
	     }

	public static boolean isPolyndromeWithoutString(int x) {
		
		int halfreverse =0;
		while(x>halfreverse) {
			
			halfreverse = halfreverse*10+x%10;	
			x=x/10;
		}
		System.out.println("is polyndrome "+ halfreverse);
		
		return x== halfreverse || x ==halfreverse/10;
	}

	public static int romanToInteger(String m) {
		
		String []s = m.split("");
		
		Map<String,Integer> mapvalues = new HashMap<String,Integer>();
		mapvalues.put("I", 1);
		mapvalues.put("V", 5);
		mapvalues.put("X", 10);
		mapvalues.put("L", 50);
		mapvalues.put("C", 100);
		mapvalues.put("D", 500);
		mapvalues.put("M", 1000);
		int count =0;
		int i= 0;
		
		for(int j=0;j<m.length()-1;j++) {
			if (m.charAt(i) == 'D' && m.charAt(i+1) =='M') {
				System.out.println("syntax error of input");
				return 0;
			}				
		}
		
		while(i<s.length-1) {
				if(mapvalues.get(s[i])< mapvalues.get(s[i+1])) {
					count = count - mapvalues.get(s[i]);	
				}
				else {
					count = count + mapvalues.get(s[i]);							
				}
				i++;
			}					
		return count = count + mapvalues.get(s[i]);
	}
	
	public static String longestCommonPreString(String arg1, String arg2) {
		
		int max = Math.min(arg1.length(), arg2.length());
		if(!arg1.equals(arg2)) {
			for (int j=0;j<max;j++) {			
				if(arg1.charAt(j)!=arg2.charAt(j)) {
					return arg1.substring(0, j);
				}			
			}
		}
		else if(arg1.equals(arg2)){
			return arg1;
		}
		if(arg1.length() ==max) 
			return arg1;
		else if(arg2.length() ==max) 
			return arg2;
		
		return "";		
	}
	
	public static String recursiveCall(String[] args) {
		String []ar = new String[args.length];
		Map<Integer,String> mapCount = new HashMap<Integer,String>();
		int i=0;
		int count =args[0].length();
		for(i=0;i<args.length-1;i++) {
			ar[i]=longestCommonPreString(args[i],args[i+1]);
			mapCount.put(ar[i].length(), ar[i]);
			System.out.println("the common strings are "+ar[i]);
			if(ar[i].length()<count) {
				count =ar[i].length();
			}
		}
		return mapCount.get(count);
	}

	public static boolean isValidParentheses(String s) {
		
		Map<Character,Character> mappings = new HashMap<Character,Character>();
		Stack<Character> stack = new Stack<Character>();
		
		mappings.put('(', ')');
		mappings.put('{', '}');
		mappings.put('[', ']');
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) =='(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(mappings.get(s.charAt(i)));
			}
			else if (stack.lastElement() == s.charAt(i)){
				stack.pop();
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}
	
	public static String reverseString(String s) {
		Stack<Character> stack = new Stack<Character>();
		//Queue<Character> queue = new LinkedList<Character>();
		String k ="";
		for(int i=0;i<s.length();i++) {
			stack.push(s.charAt(i));			
		}
		for(int j=0;j<s.length();j++) {
			k=k+stack.pop();
		}
		return k;		
	}

	public static void mergeSortedList(LinkedList<String> list1, LinkedList<String> list2) {
		
		LinkedList<String> list3 = new LinkedList<String>();
		Iterator<String> itr1 =list1.iterator();
		Iterator<String> itr2 =list2.iterator();
		while(itr1.hasNext())
		{
			list3.add(itr1.next());
			list3.add(itr2.next());		
		}
		
		System.out.println("LinkedList Content after addition: " +list3);
		//list3.head
	}	

	public static int removeDuplicates(int []nums) {
		
		int i=0;int j=0;
		int length = nums.length;
		while(i!=length-2) {
			j=i+1;
			if(nums[i] ==nums[j]) {
				nums[j]=nums[j+1];
				length--;				
			}
			i++;
		}
		return length;
	}
	
	public static String countAndSay(int n) {       
	    
		String result = "";
	        int i =2;
	        result = "11";
	        System.out.println("print array length" +result);
	        while(i<=n){               
	            String []ResultArray = result.split("");
	            int count =1;int k=0;
	            System.out.println("print array length" +ResultArray.length);
	            for(k=0; k<ResultArray.length-1;k++) {	            	
	                    if(ResultArray[k]!=ResultArray[k+1]) {
	                        result = result + String.valueOf(ResultArray[k]) + (char) count+1;
	                        System.out.println("print result from here" +result);
	                        count =1;
	                        }
	                    count++;
	                }
	            result = result + String.valueOf(ResultArray[k]);
	            i++;               
	        }
	    return result;
	    }

	public static int pairs(int [] ar) {
		int n =ar.length;
		Map<Integer,Integer> mapCount = new HashMap<Integer,Integer>();
		List<Integer> list = new ArrayList<Integer>();

	    for(int i=0; i<n;i++){
	    	if(mapCount.containsKey(ar[i]))
	        mapCount.put(ar[i],mapCount.getOrDefault(ar[i], 1)+1);  
	    }
	    for(int j=0; j<mapCount.size(); j++)
	    {
	    	
	    }
	    
	    int result = 0;
	    return result/2;	    
	}    	

    public static int countingValleys(int n, String s) {
        String []ss = s.split("");
        int count =0;int result=0;
        
        for(int i=0; i<n; i++){
        	System.out.println("value of string"+ss[i]);
            if(ss[i].equals("D")){
                count++;
                System.out.println("incremental of count"+count);                
            }else if(ss[i].equals("U")){
                count--;
                System.out.println("decrement of count"+count);
            }
            if(count==0) {result = result+1;}
        }
        return result;
    }

    public static boolean validPreTraversalBST(int [] nums, int n) {
    	int max =0; int i=0; int j=0;
    	for(i=0;i<n-1;i++) {
    			if(nums[i]<nums[i+1]) {
    				max =nums[i+1];
    				break;
    			}
    		}
    	if(max ==0) return true;
    	for(j=i+1;j<n;j++) {
    		if(nums[j]<max) return false;
    	}    		
    		return true;
    }        

    public static int[] mergeSort(int[] nums,int l,int r){
    	int mid =0;
    	if(r>l) {
    		mid = (r+1)/2;
    		
    	}
    	
    	return new int[] {};
    }

    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(isvalid(s.substring(i,j))){
                   ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }
    
    public boolean isvalid(String s){
        Set<Character> newSet = new HashSet<Character>();
        for(int i=0; i<s.length(); i++){
            if(newSet.contains(s.charAt(i))) return false;
            newSet.add(s.charAt(i));
        }
        return true;
    }

    public static void nextGreaterElement(int []nums) {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(nums[0]);
    	int i=1;
	    	while(!stack.isEmpty()) {
	    		if(nums[i]>stack.peek()) {
	    			System.out.println("the next longest integer of "+stack.peek()+"is "+nums[i]);
	    			stack.pop();
	    		}
    			stack.push(nums[i]);
	    		i++;
	    		while(i>=nums.length && !stack.isEmpty()) {
	    			if(nums[i-1]>stack.peek())
	    			System.out.println("the next longest integer of "+stack.peek()+"is "+nums[i-1]);
	    			else
	    				System.out.println("the next longest integer of "+stack.peek()+"is "+-1);	
	    			stack.pop();
	    		}

	    	}    	
    }

    public static void tworepeatingElements(int nums[]) {
    	
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-1;i++) {
    		
    		if(nums[i]==nums[i+1]) {
    			System.out.println("repeating number "+nums[i]);
    		}
    	}
    	
    }

    public static void repeatingElements(int nums[]) {
    		int []count = new int[nums.length];
    		System.out.print("the repeating numbers are ");
	    	for(int i=0;i<nums.length;i++) {
	    		if(count[nums[i]] == 1) {
	    			System.out.print(nums[i]+ "   ");
	    			count[nums[i]]++;
	    		}
	    		else {
	    			count[nums[i]]++;
	    		}
	    	}
	    	for(int i=0; i<count.length;i++) {
	    		System.out.println("count of repeating elements"+count[i]);
	    	}
    }

}
