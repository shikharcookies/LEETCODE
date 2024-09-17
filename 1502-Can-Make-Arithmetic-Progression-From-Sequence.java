import java.util.Arrays;  

class Solution {  
    public boolean canMakeArithmeticProgression(int[] arr) {  
        // Sort the array  
        Arrays.sort(arr);  

        // Calculate the common difference  
        int commonDifference = arr[1] - arr[0];  

        // Check if the difference is consistent  
        for (int i = 1; i < arr.length - 1; i++) {  
            if (arr[i + 1] - arr[i] != commonDifference) {  
                return false; // If the difference changes, return false  
            }  
        }  

        return true; // If we made it here, it is an arithmetic progression  
    }  
}