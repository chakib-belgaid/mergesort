import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MergeSort {

	//first 20 instances :[0 0 1 26 27 10 199 194 10 605 704 0 230 809 51 947 756 371 542 704]
	// the sorted array   [0 0 0 1 10 10 26 27 51 194 199 230 371 542 605 704 704 756 809 947]

	public static void main(String args[]) {
		int n = (args.length > 0) ? Integer.parseInt(args[0]) : 100;
		int niters = (args.length > 1) ? Integer.parseInt(args[1]) : 1;
		for (int iter = 0; iter < niters; iter++) {
			List<Integer> l = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {
				l.add(customRandom(i));

			}

			mergeSort(l);

		}

	}

	public static int customRandom(int n) // pseudo random number generator 
	{
		int MAXI = 1000;
		return ((int) (n * n * n * Math.cos(n) * Math.cos(n)) % MAXI);
	}

	public static <E extends Comparable<? super E>> List<E> mergeSort(List<E> m) {
		if (m.size() <= 1)
			return m;

		int middle = m.size() / 2;
		List<E> left = m.subList(0, middle);
		List<E> right = m.subList(middle, m.size());

		right = mergeSort(right);
		left = mergeSort(left);
		List<E> result = merge(left, right);

		return result;
	}

	public static <E extends Comparable<? super E>> List<E> merge(List<E> left, List<E> right) {
		List<E> result = new ArrayList<E>();
		Iterator<E> it1 = left.iterator();
		Iterator<E> it2 = right.iterator();

		E x = it1.next();
		E y = it2.next();
		while (true) {
			//change the direction of this comparison to change the direction of the sort
			if (x.compareTo(y) <= 0) {
				result.add(x);
				if (it1.hasNext()) {
					x = it1.next();
				} else {
					result.add(y);
					while (it2.hasNext()) {
						result.add(it2.next());
					}
					break;
				}
			} else {
				result.add(y);
				if (it2.hasNext()) {
					y = it2.next();
				} else {
					result.add(x);
					while (it1.hasNext()) {
						result.add(it1.next());
					}
					break;
				}
			}
		}
		return result;
	}
}