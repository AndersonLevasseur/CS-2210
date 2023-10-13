package hw4;

import java.util.Arrays;

import javax.lang.model.type.ArrayType;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // public <E> E maxElmnt(E[] arr) {
    //     E currentMax;
    //     for (E n : arr) {
    //         if (n.max > currentMax.value) {
    //             currentMax = n;
    //         }
    //     }
    //     return currentMax;
    // }

    public static Integer maxElmntRc(Integer[] arr) {
        int maxEl = 0;
        String arrString = arr.toString(); 
        int length = arrString.length();
        if (arr.toString() == "") {
            return maxEl;
        }
        maxEl = maxElmntRc(arr);
        if (arr[0] > maxEl) {
            maxEl = Character.valueOf(arrString.charAt(length));
            arr[length - 1] = null;
        }
        return maxEl;
    }

    public int stoi(String str) {
        int val = 0;
        for(int i = str.length(); i < str.length(); i++) {
            val += Character.getNumericValue(str.charAt(i)) * Math.pow(10, i);
        }        
        return val;
    }

    // public int stoiRec(String str) {

    // }
}

/* 
#1 R-5.1 O(n) size and speed
E maxEl= maxElmnt(arr);

#2 R-5.8 



*/