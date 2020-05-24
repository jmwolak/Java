
/*
 * Short Description of the Problem:
	This program will ask which file the user wishes to use. Once inserted,
	the program will read the list of numbers(specifically 1, 2, 3) within 
	that file. If the number reads 1, Enqueue element x into the end of the
	queue. If number reads 2, Dequeue element at front of the queue. If
	the number reads 3, peek element at front of queue.
 */

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
	final static String TITLE = "Queue Using two Stacks";
	final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	private static final boolean PROCESS_USING_SCANNER = false;
	private static Stack<Integer> stack1 = new Stack<>();
	private static Stack<Integer> stack2 = new Stack<>();
	private static int size;
	private static int num;

//****************************************************************	

	private static void peek() {

		int peek;

		transferToStack2();

		peek = stack2.peek();

		if (stack1.isEmpty()) {

			transferToStack1();
		}

		System.out.println(peek);

	}

//=================================================================

	private static void transferToStack1() {

		while (!stack2.isEmpty()) {

			stack1.push(stack2.pop());

		}

	}
//****************************************************************

	private static void transferToStack2() {

		while (!stack1.isEmpty()) {

			stack2.push(stack1.pop());

		}

	}

//****************************************************************

	private static void dequeue() {

		transferToStack2();

		stack2.pop();

		if (stack1.isEmpty()) {

			transferToStack1();
		}
	}

//****************************************************

	private static void enqueue(int val) {

		stack1.push(val);

	}
//****************************************************	

	private static void readQueueData(Scanner sc) {
		try {
			System.out.print("Enter Filename: ");
			String filename = sc.nextLine();
			Scanner fileInput = new Scanner(new File(filename));
			size = fileInput.nextInt();

			System.out.printf("Size: %d\n", size);

			num = fileInput.nextInt();

			while (num > 0) {

				if (num == 1) {

					num = fileInput.nextInt();
					enqueue(num);

				} else if (num == 2) {

					dequeue();

				} else if (num == 3) {

					peek();
				}

				num = fileInput.nextInt();
			}

			fileInput.close();

		} catch (Exception ex) {
		}
	}

//****************************************************	

	private static void process(Scanner sc, String args[]) {

		readQueueData(sc);

	}

//****************************************************	

	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);

		String doOver = sc.nextLine();

		return doOver.equalsIgnoreCase("Y");

	}

// ***********************************************************

	public static void main(String args[]) {

		final String CONTINUE_PROMPT = "Do this again? [y/N] ";

		System.out.println("Welcome to " + TITLE);

		Scanner sc = new Scanner(System.in);

		do {

			process(sc, args);

		} while (doThisAgain(sc, CONTINUE_PROMPT));

		sc.close();

		System.out.println("Thank you for using " + TITLE);

	}

}
