package com.test.algos.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OverlappingIntervals {
	public static void main(String []args) {
		ArrayList<Interval> a = new ArrayList<>();
		a.add(new Interval(1,8));
		a.add(new Interval(6,10));
		a.add(new Interval(12,15));
	}
	public ArrayList<Interval> mergeList(ArrayList<Interval> list) {
		if(list.size()==0 || list.size() ==1) return list;
		ArrayList<Interval> result = new ArrayList<Interval>();
		Collections.sort(list, new IntervalComparator());
		int start = list.get(0).getStart();
		int end =  list.get(0).end;
		Interval current;
		for(int i=1; i<list.size();i++) {
			current = list.get(i);
			if(current.getStart() <=end) {
				end = current.getEnd();
			}else {
				result.add(new Interval(start,end));
				start = current.getStart();
				end = current.getEnd();
			}
		}
		result.add(new Interval(start, end));
		return result;
	}
}

class Interval{
	int start;
	int end;
	Interval(){
		start =0;
		end =0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
}
class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.getStart() - o2.getStart();
	}	
}