import java.util.HashSet;
import java.util.Set;

/*Write a function called sumIntervals/sum_intervals() 
 *that accepts an array of intervals, and returns the
 *sum of all the interval lengths. Overlapping intervals
 *should only be counted once.
*/
public class SumOfIntervals {

	private static int sumIntervals(int[][] intervals) {
		Set<Integer> hash = new HashSet<Integer>();

		if (intervals == null || intervals.equals(null))
			return 0;

		for (int[] list : intervals) {
			for (int i = list[0]; i < list[1]; i++) {
				hash.add(i);
			}
		}
		return hash.size();
	}

	public static void main(String[] args) {

		System.out.println(
				sumIntervals(new int[][] { { -101, 24 }, { -35, 27 }, { 27, 53 }, { -105, 20 }, { -36, 26 }, }));
		System.out.println(sumIntervals(new int[][] { { 1, 2 }, { 2, 6 }, { 6, 55 } }));
		System.out.println(sumIntervals(new int[][] { { -2, -1 }, { -1, 0 }, { 0, 21 } }));
		System.out.println(
				sumIntervals(new int[][] { { -101, 24 }, { -35, 27 }, { 27, 53 }, { -105, 20 }, { -36, 26 }, }));

	}

}
