package main.java.Sorting;

public class MergeSort<T> {

    private static void mergeSort(int[] array){
        int length = array.length;

        if(array.length < 2){
            return;
        }

        int leftLength = length / 2;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[length - leftLength];

        for (int i = 0; i < leftLength; i++){
            leftArray[i] = array[i];
        }

        for(int i = leftLength; i < length; i++){
            rightArray[i - leftLength] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);

        //todo Merge
    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf){
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(i < leftLength && j < rightLength){
            if(leftHalf[i] < rightHalf[j]){
                arr[k] = leftHalf[i];
                i++;
            } else{
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while(i < leftLength){
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightLength){
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 8, 3, 5, 19, 98, 13, 89};

        mergeSort(arr);

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
