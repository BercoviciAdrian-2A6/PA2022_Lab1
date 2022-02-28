package com.bercoviciadrianpa2022lab1;
//Bercovici Adrian 2A6

import java.sql.Time;

public class Main {

    public static void main(String[] args)
    {
        long startTime = System.nanoTime();

        Compulsory.sayHelloWorld();

        Compulsory compulsory = new Compulsory();

        compulsory.displayMessage();

        String[] debugArgs = {"10","2","A", "G", "C", "T"};

        if (Homework.argumentsAreValid(debugArgs))
        {
            System.out.println("OK - Input is VALID!");
        }
        else
        {
            System.out.println("Invalid input!");
            return;
        }

        Homework homework = new Homework( debugArgs );

        homework.debugPrint();

        long endTime = System.nanoTime();

        System.out.println( endTime - startTime + " nanoseconds" );

    }
}
