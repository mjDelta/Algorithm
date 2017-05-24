package algorithm;

public class BinarySearch {
	/*
	 * 二分查找的数列必须是有序数列，从小到大排序的数列
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={12,23,45,46,47,51,55,56,58,61,77,98,99};
		int target=98;
		System.out.println(search(input, target));

	}
	public static int search(int[] input,int n){
		int start=0;
		int end=input.length-1;
		int mid;
		while(true){
			mid=(start+end)/2;
			if(input[mid]>n){
				end=mid-1;
			}else if(input[mid]<n){
				start=mid+1;
			}else {
				break;
			}
		}
		return mid;
	}

}
