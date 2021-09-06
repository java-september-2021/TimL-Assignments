import java.util.ArrayList;

public class Basics{
    public static void main(String[] args){
        print1_255();
        printOdd();
        printSigma();
        int[] arr1 = {1,3,5,7,9,13};
        iteratingArr(arr1);
        int[] arr2 = {-3,-5,-7};
        findMax(arr2);
        arrayOdd();

    }
    public static void print1_255() {
        for (int i=1; i<=255; i++) {
            System.out.println(i);
        }
    }

    public static void printOdd() {
        for (int i=1; i<=255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void printSigma() {
        int sum = 0;
        for (int i=0; i<=255; i++) {
            sum = i + sum;
            System.out.println(i + " Sum:" + sum);
        }
    }

    public static void iteratingArr(int[] x){
        for (int i=0; i<x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public static void findMax(int[] arr) {
        int max = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void arrayOdd() {
        ArrayList<Object> y = new ArrayList<Object>();
        for (int i=1; i<=255; i++) {
            if (i % 2 != 0) {
                y.add(i);
            }
        }
        System.out.println(y);
    }
}