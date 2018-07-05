import java.util.ArrayList;

/**
 * An implementation of heap sort.
 * 
 * @author Zhiyuan Xue
 *
 */
public class HeapSort {
	/**
	 * Sort an array list by ascending order using the heap sort algorithm.
	 * 
	 * @param list
	 *            an array list needs to be sorted
	 */
	public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
		buildMaxHeap(list);
		// System.out.printf("max heap: %s\n", list);
		for (int i = list.size(); i > 1; --i) {
			swap(list, i, 1);
			siftDown(list, 1, i - 1);
			// System.out.printf("after %d sift: %s\n", list.size() - i + 1, list);
		}
	}

	/**
	 * Heap indices are more convenient if starting from 1. Use this to translate a
	 * heap index to an array index.
	 * 
	 * @param list
	 *            underlying array list
	 * @param index
	 *            heap index
	 * @return the wanted object
	 */
	private static <T> T heapGet(ArrayList<T> list, int index) {
		return list.get(index - 1);
	}

	/**
	 * Heap indices are more convenient if starting from 1. Use this to translate a
	 * heap index to an array index.
	 * 
	 * @param list
	 *            underlying array list
	 * @param index
	 *            heap index
	 * @param t
	 *            the object to be set
	 * @return
	 */
	private static <T> void heapSet(ArrayList<T> list, int index, T t) {
		list.set(index - 1, t);
	}

	/**
	 * Swap two objects.
	 * 
	 * @param i1
	 *            object 1
	 * @param i2
	 *            object 2
	 */
	private static <T> void swap(ArrayList<T> list, int i1, int i2) {
		T temp = heapGet(list, i1);
		heapSet(list, i1, heapGet(list, i2));
		heapSet(list, i2, temp);
	}

	/**
	 * Sift an object down the heap.
	 * 
	 * @param list
	 *            underlying array list
	 * @param index
	 *            heap index of the object
	 * @param size
	 *            current heap size
	 */
	private static <T extends Comparable<T>> void siftDown(ArrayList<T> list, int index, int size) {
		T temp = heapGet(list,index);
		int pl, pr, lr;
		while (index <= size / 2) {
			pl = temp.compareTo(heapGet(list, index * 2));
			if (index * 2 + 1 <= size) {
				pr = temp.compareTo(heapGet(list, index * 2 + 1));
				lr = heapGet(list, index * 2).compareTo(heapGet(list, index * 2 + 1));
				if (pl >= 0 && pr >= 0)
					break;
				else if (lr >= 0) {
					heapSet(list, index, heapGet(list, index * 2));
					index = index * 2;
				} else {
					heapSet(list, index, heapGet(list, index * 2 + 1));
					index = index * 2 + 1;
				}
			} else if (pl >= 0)
				break;
			else {
				heapSet(list, index, heapGet(list, index * 2));
				index = index * 2;
			}
		}
		heapSet(list, index, temp);
	}

	/**
	 * Change an array list into a maximum binary heap.
	 * 
	 * @param list
	 *            underlying array list
	 */
	private static <T extends Comparable<T>> void buildMaxHeap(ArrayList<T> list) {
		for (int i = list.size(); i >= 1; --i) {
			siftDown(list, i, list.size());
		}
	}
}
