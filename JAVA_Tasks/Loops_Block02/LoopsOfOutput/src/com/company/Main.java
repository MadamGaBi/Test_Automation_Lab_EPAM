package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        printMessage("-------------------------------------------------------------------------------------------");
        printEmpty();
        firstLoop(arr);

        printMessage("-------------------------------------------------------------------------------------------");
        printEmpty();
        secondLoop(arr);

        printMessage("-------------------------------------------------------------------------------------------");
        printEmpty();
        thirdLoop(arr);

        printMessage("-------------------------------------------------------------------------------------------");
    }

    /*
    * 0 0 0 0 0
    * 1 1 1 1
    * 2 2 2
    * 3 3
    * 4
    * */
    public static void firstLoop(int[] arr) {
        for (int i=0; i<arr.length; i++){
            for (int j=arr.length; j>i; j--){
                printMessage(arr[i] + " ");
            }
            printEmpty();
        }
    }

    /*
    * 0 1 2 3 4
    * 0 1 2 3
    * 0 1 2
    * 0 1
    * 0
    * */
    public static void secondLoop(int[] arr) {
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-i; j++){
                printMessage(arr[j] + " ");
            }
            printEmpty();
        }
    }

    /*
    * 0 1 2 3 4
    * 1 2 3 4
    * 2 3 4
    * 3 4
    * 4
    * */
    public static void thirdLoop(int[] arr) {
        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                printMessage(arr[j] + " ");
            }
            printEmpty();
        }
    }

    public static void printMessage(String mess) {
        System.out.print(mess);
    }
    public static void printEmpty() {
        System.out.println();
    }
}
