package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[]   array=new int[]{1,1,3,4};
       findErrorNums(array);

    }

    public static int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                dup = i;
            else if (count == 0)
                missing = i;
        }
        System.out.println(dup + " "+ missing);
        return new int[] {dup, missing};
    }



}


