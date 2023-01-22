//Hasti Mohebali Zadeh
//26 September 2020

//this code is from lab 2 that we use for the extra assignment
//it sorts in ascending order
//the pivot is the first key 

package Extra2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Extra_Quick {

	// This class should not be instantiated.
	private Extra_Quick() { }

	public static void sort(String[] a, ExtraTest<String, Integer> st) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1, st);
		assert isSorted(a);
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(String[] a, int lo, int hi, ExtraTest<String, Integer> st) { 
		if (hi <= lo) return;
		int j = partition(a, lo, hi, st);
		sort(a, lo, j-1, st);
		sort(a, j+1, hi, st);
		assert isSorted(a, lo, hi);
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(String[] a, int lo, int hi, ExtraTest<String, Integer> st) {
		int i = lo;
		int j = hi + 1;
		Integer v = st.get(a[lo]);/////pivot is the value of the first key in st
		while (true) { 

			// find item on lo to swap
			while (less(st.get(a[++i]), v)) {
				if (i == hi) break;
			}

			// find item on hi to swap
			while (less(v, st.get(a[--j]))) {
				if (j == lo) break;      // redundant since a[lo] acts as sentinel
			}

			// check if pointers cross
			if (i >= j) break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	public static Comparable select(String[] a, int k, ExtraTest<String, Integer> st) {
		if (k < 0 || k >= a.length) {
			throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
		}
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while (hi > lo) {
			int i = partition(a, lo, hi, st);
			if      (i > k) hi = i - 1;
			else if (i < k) lo = i + 1;
			else return a[i];
		}
		return a[lo];
	}

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		if (v == w) return false;   // optimization when reference equals
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}


	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}
}
