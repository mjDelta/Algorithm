package algorithm;

import java.util.Arrays;

public class KMP {
	public static int[] next(String pattern){
		int[] next=new int[pattern.length()];
		next[0]=-1;
		int k=-1;
		int j=0;
		while(j<pattern.length()-1){
			if (k==-1||pattern.charAt(j)==pattern.charAt(k)){
				next[++j]=++k;
			}else{
				k=next[k];
			}
		}
		return next;
	}
	public static int search(String match,String pattern){
		int i=0;
		int j=0;
		int[] next=next(pattern);
		System.out.println(Arrays.toString(next));
		while(i<match.length()&&j<pattern.length()){
			//if (j==-1)return -1;
			if(j==-1||match.charAt(i)==pattern.charAt(j)){
				i++;
				j++;
			}else{
				j=next[j];
			}
		}
		//System.out.println(i);
		if(j==pattern.length())return i-j;
		return -1;
	}
	public static void main(String[] args) {
		String match="asdtasdesefyuih";
		String pattern="esef";
		System.out.println(search(match, pattern));
	}
}
