import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Name: Sreenath Reddy Challuri
Student Number: A00247493
*/

//ArrayTools Class


public class ArrayTools
{
  //Start of the program
    public static void main(String[] args) {

        int[] array = {25, 28, 103, 121, 112, 878, 999, 875};

        ArrayList<String> duplicatesList = new ArrayList<>();

        duplicatesList.add("John");
        duplicatesList.add("william");
        duplicatesList.add("Ani");
        duplicatesList.add("william");
        duplicatesList.add("John");
        duplicatesList.add("Diva");
        duplicatesList.add("Luis");
        duplicatesList.add("Ani");
        duplicatesList.add("Charlotte");
        //encryptStringUsingCaesarCipher("Hi, i'm using a caesar cipher to encrypt this message", 4);
        //arrayAvg(array);
        //arrayContains(array, 25);
        //reverseArray(array);

        System.out.println("Enter a string to encrypt : ");
        // Initiating scanner object from library to read the input from console
        Scanner scanner = new Scanner(System.in);
        String encryptStr = scanner.next();

        System.out.println("Enter a value to encrypt with : ");
        //Variable to print final result
        Scanner scanner1 = new Scanner(System.in);
        int value = scanner1.nextInt();

        StringBuilder encryptedValue = encryptStringUsingCaesarCipher(encryptStr, value);
        System.out.println("Encrypted String : " + encryptedValue);
        StringBuilder decryptedValue =  decryptStringUsingCaesarCipher(encryptedValue.toString(), value);
        System.out.println(decryptedValue);

        System.out.println("\n");

        System.out.println("Testing methods with : " + Arrays.toString(array));
        int avgValue = arrayAvg(array);
        System.out.println("The average is : " +  avgValue);

        System.out.println("\n");

        System.out.println("Enter a value to search for : ");
        Scanner scanner2 = new Scanner(System.in);
        int searchValue = scanner2.nextInt();

        System.out.println("\n");


        boolean isValuePresent = arrayContains(array, searchValue);
        if (isValuePresent)
        {
            System.out.println("The array contains " + searchValue);
        }
        // Check if this value is present in the array or not
        else
        {
            System.out.println("The array not contains " + searchValue);
        }

        System.out.println("\n");

        int[] reveresedArray = reverseArray(array);
         /* swapping values of original array with new array values */
        System.out.println("The  array is reversed : " + Arrays.toString(reveresedArray));

        System.out.println("\n");
        /*printing the reversed array*/

        removeDuplicatesUsingLoop(duplicatesList);

    }

    public static StringBuilder encryptStringUsingCaesarCipher(String originalStr, int offset)
    {

        /* Encrypting original string using given offset value */

        StringBuilder encryptedString = new StringBuilder();
        for (char character : originalStr.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                encryptedString.append(newCharacter);
            } else {
                encryptedString.append(character);
            }
        }

        return encryptedString;

    }

    public static StringBuilder decryptStringUsingCaesarCipher(String encryptedStr, int offset)
    {
        System.out.println("decrypting with : " + (-offset));

        /* Encrypting original string using given offset value */

        StringBuilder decryptedString = new StringBuilder();
        for (char character : encryptedStr.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + (-offset)) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                decryptedString.append(newCharacter);
            } else {
                decryptedString.append(character);
            }
        }

        return decryptedString;

    }

    public static boolean arrayContains(int[] array, int searchValue)
    {
        boolean isValuePresent = false;

        for (int j : array)
        {
            /* Checking condition if given search value is present or not */

            if (j == searchValue)
            {
                isValuePresent = true;

                break;
            }
        }

        return isValuePresent;
    }

    public static int arrayAvg(int[] array)
    {

        int total = 0;

        for (int j : array)
        {
            /* summing up the values of array and storing into a variable */

            total = total + j;
        }

        int average = total / array.length;

        return average;

    }

    public static int[] reverseArray(int[] array)
    {

        for(int i = 0; i < array.length / 2; i++)
        {
            int temp_var = array[i];

            /* swapping values of original array with new array values */

            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp_var;
        }

        return array;

    }

    private static void removeDuplicatesUsingLoop(ArrayList<String> dupList)
    {
        System.out.println("Original List : " + dupList);
        System.out.println("Removing duplicates from above list....");

        for (int i = 0; i < dupList.size(); i++) {
            for (int j = i + 1; j < dupList.size(); j++) {

                /* Checking if value equals or not */

                if (dupList.get(i).equalsIgnoreCase(dupList.get(j))) {
                    dupList.remove(j);
                    j--;
                }
            }
        }

        System.out.println("Filtered List : " + dupList);
    }

}
