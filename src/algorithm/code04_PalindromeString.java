package algorithm;
import java.util.*;

public class code04_PalindromeString {
	public static String expandStr(String oldStr){
		String newString="#";
		for(int i=0;i<oldStr.length();i++){
			newString=newString+oldStr.charAt(i)+"#";
		}
		return newString;
	}
	public static int manacher(String newStr){
		int po=0;//当前取得len最大的位置
		int max=0;//当前匹配位置之中向右延伸的最大位置
		int[] len=new int[newStr.length()];
		len[0]=1;
		int j=1;
		int maxLen=0;
		while(j<newStr.length()){
			if(j<max){
				len[j]=(len[2*po-j]<(max-j)?len[2*po-j]:(max-j));
			}else{
				len[j]=1;
			}
			while(j+len[j]<newStr.length()&&j-len[j]>=0&&newStr.charAt(j+len[j])==newStr.charAt(j-len[j])){
				len[j]++;
			}
			if(len[j]+j-1>max){
				max=len[j]+j-1;
				po=j;
			}
			if(j%2!=0&&len[j]-1>maxLen)maxLen=len[j]-1;
			j++;
		}
		return maxLen;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int nums=Integer.valueOf(scanner.nextLine());
		for(int i=0;i<nums;i++){
			String ss=scanner.nextLine();
			System.out.println(manacher(expandStr(ss)));
		}
		
	}
}
