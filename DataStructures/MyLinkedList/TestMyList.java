// Test Program to check ArrayList vs LinkList Performance

package chapter24;

public class TestMyList {

	/** Main method */

	public static void main(String[] args) {

		// Create a list for strings

		long start = System.nanoTime();

		MyList<String> list = new MyLinkedList<>();

		// MyList<String> list = new MyArrayList<String>();

		// Add elements to the list

		list.add("America"); // Add it to the list

		// System.out.println("(1) " + list);

		for (int i = 0; i < 10000; i++) {

			list.add(0, "USAUSAUSA");

		}

		for (int i = 0; i < 10000; i++) {

			list.remove(0);

		}

		list.add(0, "Canada"); // Add it to the beginning of the list

		// System.out.println("(2) " + list);

		list.add("Russia"); // Add it to the end of the list

		// System.out.println("(3) " + list);

		list.add("France"); // Add it to the end of the list

		// System.out.println("(4) " + list);

		list.add(2, "Germany"); // Add it to the list at index 2

		// System.out.println("(5) " + list);

		list.add(5, "Norway"); // Add it to the list at index 5

		// System.out.println("(6) " + list);

		list.add(0, "Poland"); // Same as list.addFirst("Poland")

		// System.out.println("(7) " + list);

		// Remove elements from the list

		// list.remove(0); // Same as list.remove("Australia") in this case

		// System.out.println("(8) " + list);

		// list.remove(2); // Remove the element at index 2

		// System.out.println("(9) " + list);

		// list.remove(list.size() - 1); // Remove the last element

		// System.out.print("(10) " + list + "\n(11) ");

		// for (String s : list)

		// System.out.print(s.toUpperCase() + " ");

		long end = System.nanoTime();

		System.out.printf("%,d\n", end - start);

		// list.clear();

		// System.out.println("\nAfter clearing the list, the list size is "

		// + list.size());

		// **********************************************

		// Code to test Implementation of MyLinkedList.java

		// unimplemented methods

		// **********************************************

		System.out.println(list);

		System.out.println(list.contains("Germany"));

		System.out.println(list.contains("Italy"));

		System.out.println(list.contains("Poland"));

		System.out.println(list.get(3));

		System.out.println(list.get(6));

		System.out.println(list.get(0));

		System.out.println(list.indexOf("Germany"));

		System.out.println(list.indexOf("Italy"));

		System.out.println(list.indexOf("Poland"));

		list.add("Germany");

		list.add("Italy");

		list.add("Poland");

		System.out.println(list.lastIndexOf("Germany"));

		System.out.println(list.lastIndexOf("Italy"));

		System.out.println(list.lastIndexOf("Poland"));

		list.set(0, "Tony");

		list.set(3, "Bill");

		list.set(5, "Bob");

		System.out.println(list);

	}

}