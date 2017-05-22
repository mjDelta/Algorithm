package algorithm;

import java.util.Arrays;

public class MergeSorting {
	public static void sort(int[] input,int start,int end){
		int mid=(start+end)/2;
		if(start<end){
			sort(input, start, mid);
			sort(input, mid+1, end);
			merge(input,mid,start,end);			
		}
		
	}
	public static void merge(int[] input,int mid,int start,int end){
		int[] temp=new int[end-start+1];
		int i=start;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=end){
			if(input[i]<input[j]){
				temp[k++]=input[i++];
			}else{
				temp[k++]=input[j++];
			}
		}
		while(i<=mid){
			temp[k++]=input[i++];
		}
		while(j<=end){
			temp[k++]=input[j++];
		}
		for(int m=0;m<end-start+1;m++){
			input[start+m]=temp[m];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={1,2,43,12,44,2,7,45,89,10,24};
		sort(input,0,input.length-1);
		System.out.println(Arrays.toString(input));
	}

}
