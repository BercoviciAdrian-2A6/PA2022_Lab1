package com.bercoviciadrianpa2022lab1;
//Bercovici Adrian 2A6

import java.util.ArrayList;

public class Homework
{
    class AdjacencyList
    {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();

        public void  addNeighbor(int neighborIndex)
        {
            neighbors.add(neighborIndex);
        }

        public  void printAdjacencyList()
        {
            for (int i = 0; i < neighbors.size(); i++)
            {
                System.out.print(neighbors.get(i) + " ");
            }

            System.out.print("\n");
        }
    }

    //non static variables
    private int n, p;
    private ArrayList<Character> letters;
    private ArrayList<String> words;
    private boolean adjacencyMatrix[][];
    private AdjacencyList adjacencyLists[];

    //Constructor
    Homework(String[] inputArgs)
    {
        //arguments must be already validated at this point
        n = Integer.parseInt( inputArgs[0] );
        p = Integer.parseInt( inputArgs[1] );
        letters = new ArrayList<Character>();

        for (int i = 2; i < inputArgs.length; i++)
        {
            letters.add( inputArgs[i].charAt(0) );
        }

        //generate words
        words = new ArrayList<String>();

        for (int i = 0; i < n; i++)//generate n words
        {
            String temp = "";

            for (int j = 0; j < p; j++)//pick p random letters
            {
                temp += letters.get( Compulsory.getRandomInt() % letters.size() );
            }

            words.add(temp);
        }

        //populate adjacency matrix and lists

        adjacencyMatrix = new boolean[n][n];

        adjacencyLists = new AdjacencyList[n];

        for (int i = 0; i < n; i++)
        {
            adjacencyLists[i] = new AdjacencyList();
        }

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                boolean areNeighbors = wordsAreNeighbours(i,j);

                adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = areNeighbors;
            }
        }

        for (int i = 0; i < n ; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (adjacencyMatrix[i][j] == true)
                    adjacencyLists[i].addNeighbor(j);
            }
        }
    }

    //Methods

    public  static boolean argumentsAreValid( String[] inputArgs )
    {
        if  (inputArgs.length < 3)//the 2 numbers are not present or the alphabet is void
            return false;

        for (int i = 0; i <= 1; i++)//check if the first two strings are numbers
        {
            for (int j = 0; j < inputArgs[i].length(); j++)
            {
                char temp = inputArgs[i].charAt(j);

                if (temp < 48 || temp > 57)//char is not between '0' and '9'
                    return false;
            }
        }

        for (int i = 2; i < inputArgs.length; i++)
        {
            if (inputArgs[i].length() > 1)// string is not a single letter...
                return false;
        }

        return  true;
    }

    boolean wordsAreNeighbours(int wordA, int wordB)
    {
        for (int i = 0; i < p; i ++)
        {
            if ( words.get(wordA).charAt(i) == words.get(wordB).charAt(i) )
                return true;
        }

        return false;
    }

    ArrayList<Integer> BFS( ArrayList<Integer> cycleNodes )
    {
        return null;
    }

    public void findLongestCycle()//BONUS
    {
        //the problem asks that we find the longest cycle in the graph generated from the words
        //since cycles cannot be shorter than 3 nodes the k >= 3 condition is also satisfied
        //Since a BFS search can be used to find the longest cycle starting in the node 0 of the search, we can run the BFS search on each node of the graph
        //to locate the cycle of maximum possible length

        ArrayList<Integer> maxCycle = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            ArrayList<Integer> currentCycle = new ArrayList<>();

            currentCycle.add(i);

            ArrayList<Integer> candidateCycle = BFS(currentCycle);

            if (candidateCycle.size() > maxCycle.size())
                maxCycle = candidateCycle;
        }

    }

    public void debugPrint()
    {
        System.out.println(n);
        System.out.println(p);

        for (int i = 0; i < letters.size(); i++)
        {
            System.out.print(letters.get(i) + " ");
        }

        System.out.print("\n");

        for (int i = 0; i < words.size(); i++)
        {
            System.out.println( words.get(i) );
        }

        //print matrix
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (adjacencyMatrix[i][j])
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }

            System.out.print("\n");
        }

        System.out.print("\n");
        //print lists

        for (int i = 0; i < n; i++)
        {
            adjacencyLists[i].printAdjacencyList();
        }
    }
}
