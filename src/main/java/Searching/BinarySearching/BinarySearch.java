package main.java.Searching.BinarySearching;

public class BinarySearch {

    public static int search(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            //middle should be inside while loop as it is always changing
            int middle = (left + right) / 2;

            //If the target is on the left side bring the right Pointer to the left side as well
            if(target < arr[left]){
                right = middle - 1;
            }
            else if(target > arr[right]){
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 8, 9};

        int search = search(arr, 5);

        System.out.println(search);

    }
}
