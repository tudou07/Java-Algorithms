package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class HashTable {

    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    HashTable(int size){
        arraySize = size;
        theArray = new String[size];
        //*Filling the whole array with -1 Don't do this in real world
        Arrays.fill(theArray, "-1");
    }

    /**
     * This is an old way of making hashtable
     * @param stringForArray
     * @param theArray
     */
    public void hashFunction(String[] stringForArray, String[] theArray){
        for (int n = 0; n < stringForArray.length; n++){
            String newElementVal = stringForArray[n];
            //*Parse the element to an integer and store that at the array value.
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }
    }

    public void hashFunction2(String[] stringForArray, String[] theArray){
        for (int n = 0; n < stringForArray.length; n++){

            String newElement = stringForArray[n];
            int arrayIndex = Integer.parseInt(newElement) % 29;
            System.out.print("Modulus Index " + arrayIndex + " for value " + newElement + "\n");

            while (!Objects.equals(theArray[arrayIndex], "-1")){
                ++arrayIndex;
                System.out.println("Collison Try" + arrayIndex + " Instead\n");
                arrayIndex %= arraySize;
            }

            theArray[arrayIndex] = newElement;

        }
    }

    public String findKey(String key){
        int arrayIndex = Integer.parseInt(key) % 29;

        while(theArray[arrayIndex] != "-1"){
            if(theArray[arrayIndex] == key){
                System.out.println(key + " was found in index " + arrayIndex);
                return theArray[arrayIndex];
            }
            ++arrayIndex;
            arrayIndex &= arraySize;
        }
        return null;
    }

    public boolean isPrime(int number){
        if(number % 2 ==0){
            return false;
        }

        for (int i = 3; i * i <= number; i+=2){
            if(number % i ==0){
                return false;
            }
        }
        return true;
    }

    public int getNextPrime(int minNumberToCheck){
        for(int i = minNumberToCheck; true; i++){
            if(isPrime(i)){
                return i;
            }
        }
    }

    public void increaseArraySize(int minArraySize){
        int newArraySize = getNextPrime(minArraySize);
        moveOldArray(newArraySize);
    }

    public void moveOldArray(int newAraySize){
        String[] cleanArray = removeEmptySpacesInArray(theArray);
        theArray = new String[newAraySize];
        arraySize = newAraySize;
        fillArrayWithNeg1();
        hashFunction2(cleanArray, theArray);
    }

    public void fillArrayWithNeg1(){
        Arrays.fill(theArray, "-1");
    }

    private String[] removeEmptySpacesInArray(String[] arrayToClean) {
        ArrayList<String> stringList = new ArrayList<>();
        for (String theString : arrayToClean){
            if(!theString.equals("-1") && !theString.equals("")){
                stringList.add(theString);
            }
        }
        return stringList.toArray(new String[stringList.size()]);
    }


    public static void main(String[] args){
        //*Using prime number for size decreases collision
        HashTable thefunc = new HashTable(61);
//        String[] element = {"1", "3", "5", "21" , "19"};
//
//        thefunc.hashFunction(element, thefunc.theArray);

        String[] elementsInFunc2 = {"100", "123" ,"543", "101", "654" ,"243", "199", "999" ,"99", "74", "23" ,"87",
                "235", "802", "900", "723", "699", "1", "16", "999", "890", "235", "802", "900", "723", "699", "1", "16", "890",
                "100", "510", "170", "214", "268", "398"};

        thefunc.hashFunction2(elementsInFunc2, thefunc.theArray);
        thefunc.increaseArraySize(101);
        thefunc.findKey("101");

        thefunc.displayTheStack();
    }

    void displayTheStack(){
        int increment = 0;

        for (int m = 0; m < 10; m++){
            increment += 10;

            for (int n = 0; n < 71; n++){
                System.out.print("-");
            }
            System.out.println();

            for (int n = increment - 10; n < increment; n++){
                System.out.format("| %3s " + " ", n);
            }
            System.out.println("|");

            for (int n = 0; n <71;n++){
                System.out.print("-");
            }
            System.out.println();

            for (int n = increment - 10; n < increment; n++){
                if(theArray[n].equals("-1")){
                    System.out.print("|      ");
                } else{
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
                }
            }

            System.out.println("|");

            for (int n = 0; n <71;n++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
