import java.util.ArrayList;
import java.util.Arrays;

public class HeapSortTester {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 7, 5, 6, 1, 9, 2, 8, 4, 0));
		System.out.println(list);
		HeapSort.sort(list);
		System.out.println(list);
		list = new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
		System.out.println(list);
		HeapSort.sort(list);
		System.out.println(list);
		list = new ArrayList<Integer>();
		System.out.println(list);
		HeapSort.sort(list);
		System.out.println(list);
		list = new ArrayList<Integer>();
		for (int i = 0; i < 20; ++i)
			list.add((int) (Math.random() * 20));
		System.out.println(list);
		HeapSort.sort(list);
		System.out.println(list);
	}

}
