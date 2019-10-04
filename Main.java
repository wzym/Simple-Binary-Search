import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int sortedArraySize = sc.nextInt();
        int[] sortedArray = new int[sortedArraySize];
        for (int i = 0; i < sortedArraySize; i++) {
            sortedArray[i] = sc.nextInt();
        }
        int arrayWithNumbersToFindSize = sc.nextInt();
        int[] numbersToFind = new int[arrayWithNumbersToFindSize];
        for (int i = 0; i < arrayWithNumbersToFindSize; i++) {
            numbersToFind[i] = sc.nextInt();
        }

        int[] positions = getPositionsIndexes(sortedArray, numbersToFind);
        printResult(positions);
    }

    private void printResult(int[] positions) {
        StringBuilder sb = new StringBuilder();
        for (int position : positions) {
            sb.append(position);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private int[] getPositionsIndexes(int[] sortedArray, int[] numbersToFind) {
        return Arrays.stream(numbersToFind)
                .map(n -> getPosition(n, sortedArray))
                .toArray();
    }

    private int getPosition(int number, int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left < right) {
            int middle = (right + left) / 2;
            if (number <= sortedArray[middle])
                right = middle;
            else left = middle + 1;
        }
        return sortedArray[left] == number ? left + 1 : -1;
    }
}