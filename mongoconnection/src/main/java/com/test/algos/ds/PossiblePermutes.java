package com.test.algos.ds;

import java.util.ArrayList;
import java.util.List;

public class PossiblePermutes {
	List<String> list = new ArrayList<>();
	PossiblePermutes(String str){		
		permutes(str,0,str.length()-1);
	}
	void permutes(String str, int l, int r) {
		if(l==r) {
			list.add(str);
		}
		else {
			for(int i=l; i<=r;i++)
			{
				str = swap(str,l,i);
				permutes(str,l+1,r);
				str = swap(str,l,i);
			}
		}
	}
	String swap(String str,int l, int r) {
		if(l==r)  return str;
		char[] ch = str.toCharArray();
		char temp = ch[l];
		ch[l] = ch[r];
		ch[r] =temp;
		return new String(ch);
	}
	public static void main(String[] args) {
		PossiblePermutes pp = new PossiblePermutes("123");
		System.out.println("permutation sequence of this number is "+pp.list);
	}
}