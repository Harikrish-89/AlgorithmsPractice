package com.algorithms.searchsort;

public class FirstBadVersion {
	public static void main(String[] args) {
		int n = 5;
		if(n == 1){
            System.out.println(1);
        }
        int l=1, r = n;
         
        while (l <= r){
           int mid = l + (r -l)/2;
         
            if(isBadVersion(mid)){
                r = mid-1;
              
            }else{
                  l = mid+1;
            }
        }
        System.out.println(l);
	}

	private static boolean isBadVersion(int mid) {
		return false;
	}
}
