package com.algorithm.arrays;

public class MinimumFlips {

    public static void main(String[] args) {
        int [] binaryArray = {0,0,1,1,0,0,1,1,0,1};
        for(int i=1; i < binaryArray.length; i++){
            if(binaryArray[i] != binaryArray[i-1]){
                if(binaryArray[i] != binaryArray[0]){
                    System.out.print("From:" + i + " to ");
                }else{
                    System.out.print(i-1);
                    System.out.println("");
                }
            }
        }
        if(binaryArray[binaryArray.length-1] != binaryArray[0] ){
            System.out.print(binaryArray.length-1);
        }
    }
    
}
