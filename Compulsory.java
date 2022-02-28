package com.bercoviciadrianpa2022lab1;
//Bercovici Adrian 2A6
import java.io.PipedWriter;
import java.util.ArrayList;

public class Compulsory
{
    //Non-static variables
    //lack of private modifier marks variables as package level..
    private ArrayList<String> languages;

    //Constructors
    Compulsory ()
    {
        languages = new ArrayList<>();
        languages.add("C#");
        languages.add("C++");
        languages.add("Python");
        languages.add("Go");
        languages.add("Rust");
        languages.add("JavaScript");
        languages.add("PHP");
        languages.add("Swift");
        languages.add("Java");
    }

    //Methods

    public static void sayHelloWorld()
    {
        System.out.println("Hello world!");
    }

    public static int getRandomInt()
    {
        return (int) (Math.random() * 1000000);
    }

    private int binaryToDecimal(String input)
    {
        int binary[] = new int[input.length()];

        for (int i = 0; i < input.length(); i++)
        {
            binary[i] = input.charAt(i) - 48;//48 is the ascii code of '0'
        }

        int total = 0;

        int pow = 0;

        for (int i = binary.length - 1; i >= 0; i--)
        {
            total += Math.pow(2, pow) * binary[i];
            pow++;
        }

        //System.out.print(total);

        return total;
    }

    private int hexadecimalToDecimal(String input)
    {
        int total = 0;
        int pow = 0;

        for (int i = input.length() - 1; i >= 0; i--)
        {
            char inputChar = input.charAt(i);

            int intVal = -1;

            if ( inputChar >= 48 && inputChar <= 57 )//char is between '0' and '9'
                intVal = inputChar - 48;
            else//else char is of type A = 10, B = 11, C = 12, D = 13, E = 14, F = 15
                intVal = inputChar - 65 + 10;//65 is the ascii of 'A'

            total += Math.pow(16, pow) * intVal;
            pow++;
        }

        //System.out.print(total);

        return total;
    }

    private int computeN()
    {
        int randN = getRandomInt();

        randN *= 3;

        randN += binaryToDecimal("10101");
        randN += hexadecimalToDecimal("FF");
        randN *= 6;

        return  randN;
    }

    private int sumOfDigits(int input)
    {
        int sum = 0;

        do
        {
            sum += input % 10;
            input /= 10;
        }while (input > 9);

        if (sum < 10)
            return  sum;

        return sumOfDigits(sum);
    }

    public void displayMessage()
    {
        System.out.println( "Willy-nilly, this semester I will learn " + languages.get( sumOfDigits( computeN() ) % languages.size() ));
    }

    public  void debugPrintLanguages()
    {
        for (int i = 0; i < languages.size(); i++)
        {
            System.out.println(languages.get(i));
        }
    }


}
