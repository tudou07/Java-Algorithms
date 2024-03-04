package main.java.Sorting;

import java.util.Random;

public class QuickSort {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[]arr, int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPoint = lowIndex;
        int rightPoint = highIndex;

        while(leftPoint < rightPoint){

            while(arr[leftPoint] <= pivot && leftPoint < rightPoint){
                leftPoint++;
            }

            while (arr[rightPoint] >= pivot && leftPoint < rightPoint){
                rightPoint--;
            }
            swap(arr, leftPoint, rightPoint);
        }
        swap(arr, leftPoint, highIndex);

        //*leftIndex + 1 and leftIndex - 1 because we don't want to move the previous pivot.
        quickSort(arr, lowIndex, leftPoint-1);
        quickSort(arr, leftPoint+1, highIndex);
    }

    public static void main(String[] args){
        int[] arr = {1, 6, 2, 5, 2, 23, 87, 22, 12};

        quickSort(arr, 0, 8);

        for (int i = 0; i < 8; i++){
            System.out.println(arr[i]);
        }
    }
}
