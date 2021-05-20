import java.util.LinkedList;
import java.util.Collection;
import java.util.Scanner;


public class main {
    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {

        Collection<Collection<String>> listsCollection = new LinkedList<Collection<String>>();

        for (int i = 0; i < getRandomNumber(5, 10); i++) {
            Collection<String> stringCollection = new LinkedList<String>();
            for (int j = 0; j < getRandomNumber(0, 8); j++) {
                stringCollection.add(String.valueOf(getRandomNumber(0, 100)));
            }
            listsCollection.add(stringCollection);
        }

        int i = 1;
        System.out.print("Generated collections:");
        for (Collection<String> stringCollection : listsCollection) {
            System.out.printf("\nCollection %d: ", i);
            i += 1;
            for (String string : stringCollection) {
                System.out.printf("%s, ", string);
            }
        }

        Collection<String> compareCollection = new LinkedList<String>();
        System.out.println("\n\nEnter three values to compare given lists with");
        Scanner s = new Scanner(System.in);
        for (i = 0; i < 3; i++) {
            compareCollection.add(String.valueOf(s.nextInt()));
        }

        System.out.print("Given list: ");
        for (String string : compareCollection) {
            System.out.printf("%s, ", string);
        }
        System.out.println();

        i = 1;
        Boolean flag = false;
        for (Collection<String> stringCollection : listsCollection) {
            if (stringCollection.containsAll(compareCollection)) {
                System.out.printf("Collection %d has your values in it!\n", i);
                flag = true;
            }
            i += 1;
        }
        if (!flag) {
            System.out.println("Your numbers were not found in collections");
        }
    }
}
