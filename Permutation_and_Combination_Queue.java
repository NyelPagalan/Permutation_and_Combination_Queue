import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Permutation_and_Combination_Queue {

    static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    static int total;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {

        // Ask how many elements to add
        System.out.print("Enter number of elements to add: ");
        int numElements = input.nextInt();

        // Use queue.add() to insert elements (stored in capital letters)
        for (int index = 1; index <= numElements; index++) {
            System.out.print("Enter element " + index + ": ");
            queue.add(input.next().toUpperCase());
        }

        displayQueue();

        // Task 1: when five elements are entered, dequeue two of them
        if (numElements == 5) {
            for (int index = 0; index < 2 && !queue.isEmpty(); index++) {
                System.out.println("Dequeued: " + queue.peek());
                queue.poll();
            }
            displayQueue();
        }
    }

    // TODO 2: Display all elements in the Queue
    static void displayQueue() {

        // Display the contents of the Queue
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue: " + queue);
        }
    }

    // Helper: copy the queue into an array without losing its contents
    static String[] copyQueue() {

        int queueSize = queue.size();
        String[] elements = new String[queueSize];

        for (int index = 0; index < queueSize; index++) {
            String element = queue.poll();
            elements[index] = element;
            queue.add(element);
        }

        return elements;
    }

    // TODO 3: Generate all possible permutations
    static void generatePermutations() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }

        displayQueue();
        System.out.println();

        // Ask how many elements should be selected
        System.out.print("Enter number of elements to arrange: ");
        int numToSelect = input.nextInt();
        System.out.println();

        if (numToSelect < 1 || numToSelect > queue.size()) {
            System.out.println("Invalid number. Must be 1 to " + queue.size() + ".");
            return;
        }

        // Generate all possible arrangements
        String[] elements = copyQueue();
        boolean[] isUsed = new boolean[elements.length];
        total = 0;
        arrangeElements(elements, isUsed, "", 0, numToSelect);

        // Display the total number of permutations
        System.out.println();
        System.out.println("Total Permutations: " + total);
    }

    static void arrangeElements(String[] elements, boolean[] isUsed, String result, int position, int numToSelect) {

        if (position == numToSelect) {
            System.out.println(result);
            total++;
            return;
        }

        for (int index = 0; index < elements.length; index++) {
            if (!isUsed[index]) {
                isUsed[index] = true;
                arrangeElements(elements, isUsed, result + elements[index], position + 1, numToSelect);
                isUsed[index] = false;
            }
        }
    }

    // TODO 4: Generate all possible combinations
    static void generateCombinations() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }

        displayQueue();
        System.out.println();

        // Ask how many elements should be selected
        System.out.print("Enter number of elements to select: ");
        int numToSelect = input.nextInt();
        System.out.println();

        if (numToSelect < 1 || numToSelect > queue.size()) {
            System.out.println("Invalid number. Must be 1 to " + queue.size() + ".");
            return;
        }

        // Generate all possible selections (no duplicates)
        String[] elements = copyQueue();
        total = 0;
        selectElements(elements, 0, "", numToSelect);

        // Display the total number of combinations
        System.out.println();
        System.out.println("Total Combinations: " + total);
    }

    static void selectElements(String[] elements, int startIndex, String result, int numToSelect) {

        if (numToSelect == 0) {
            System.out.println(result);
            total++;
            return;
        }

        for (int index = startIndex; index < elements.length; index++) {
            selectElements(elements, index + 1, result + elements[index], numToSelect - 1);
        }
    }
}