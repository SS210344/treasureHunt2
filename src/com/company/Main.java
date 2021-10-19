package com.company;
import java.util.Random;
import java.util.Scanner;



public class Main {
    static String[][] board = new String[10][8];

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        //makes board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "[ ]";
            }
        }


        printBoard(board);

        // add coins to board

        System.out.println("number of coin places:");
        int coinPlaces = input.nextInt();
        for (int i = 0; i < coinPlaces; i++) {
            placeCoin(board,5);

        }
        printBoard(board);

        // fills empty spaces

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals("[ ]")){
                    board[i][j]= "[0]";
                }
            }
        }
        printBoard(board);

        // user code
        int TotalCoins = 0;

        for (int guesses = 0; guesses < 6 ; guesses++) {


            System.out.println("x cord between 1 and 8:");
            int xCord = input.nextInt() ;
            xCord -= 1;
            System.out.println("y cord between 1 and 10:");
            int yCord = input.nextInt() ;
            yCord -= 1;
            String space = board[xCord][yCord];
            System.out.println(space);
            char coin = space.charAt(1);

            int score =Character.getNumericValue(coin);


            TotalCoins += score;
            System.out.println("you found "+coin+" coins");
            System.out.println("you got "+(5 -guesses)+" left");

        }
        System.out.println("you got "+TotalCoins+" coins in total");






    }
    public static void printBoard (String[][] board){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println("");

        }
    }
    public static void placeCoin (String[][] board,int maxCoin){
        Random randNum = new Random();
        while (true){
            int i = randNum.nextInt(9);
            int j = randNum.nextInt(7);
            if (board[i][j].equals("[ ]")) {
                String temp= Integer.toString(randNum.nextInt(maxCoin+1));
                board[i][j] = "["+temp+"]";
                break;
            }
        }
    }
}
