package algorithm;

import java.util.Arrays;

public class InsertSorting {
	public static void sort(int[] input){
		for(int i=1;i<input.length;i++){
			int key=input[i];
			int j=i-1;
			while(j>=0&&input[j]>key){
				input[j+1]=input[j];
				j--;
			}
			input[j+1]=key;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={1,2,43,12,44,2,7,45,89,10,24};
		sort(input);
		System.out.println(Arrays.toString(input));
	}

}
