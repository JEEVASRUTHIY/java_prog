import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={10,2,3,5,6,9,13,4};
		int first=Integer.MIN_VALUE;
		int second=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
		    if(arr[i]>first){
		        second=first;
		        first=arr[i];
		       
		    }
		    else if(arr[i]>second && arr[i]!=first){
		        second=arr[i];
		    }
		}
       System.out.println(second);
	}
}
