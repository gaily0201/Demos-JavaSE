package mytest;

import java.util.Comparator;

public class MyDefaultComparator<T extends Comparable<T>>  implements MyComparator<T> {

	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean equals(Object obj, T t1) {
		// TODO Auto-generated method stub
		return false;
	}

}
