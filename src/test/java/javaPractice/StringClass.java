package javaPractice;

import java.util.Arrays;

public class StringClass {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("My name is Rahil. I am an automation engineer");
        String string = stringBuilder.toString();
        String newString ="";
        //Split by space
        String[] words = string.split(" ");
        //System.out.println(strArray[2]);
        System.out.println("*****Original String:*****\n"+stringBuilder+"\n");

        //Reversing words in a string
        for (int i = words.length-1; i >= 0; i--) {
            newString += words[i]+" ";
        }
        System.out.println("*** Words reversed ***");
        System.out.println(newString+"\n");

        //Reversing letters and not words in a string
        System.out.println("*** Reversing letters and not words in a string ***");
        StringBuilder sb = new StringBuilder();

        // Iterate backwards (reverse word order)
        for (int i = 0; i < words.length; i++) {
            // Reverse characters of each word
            sb.append(new StringBuilder(words[i]).reverse());

            if (i < words.length) {
                sb.append(" "); // add space between words
            }
        }

        System.out.println(sb+"\n");

        //Reversing the string
        System.out.println("** Reversing the string **");
        System.out.println(stringBuilder.reverse());

       /* System.out.println(newString);
        String convertedString = stringBuilder.toString();
        System.out.println(convertedString);
*/
        /*for (String stringSplit: strArray)
        {
            System.out.println(stringSplit);
        }


        System.out.println(stringBuilder.charAt(4));
        System.out.println(stringBuilder.reverse());
        System.out.println(stringBuilder.insert(5,"POT"));
        System.out.println(stringBuilder.reverse());*/
    }
}
