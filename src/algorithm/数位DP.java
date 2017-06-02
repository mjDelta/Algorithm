package algorithm;

import java.util.Arrays;

/*
 * ������������[a,b],�������ж��ٸ�����������4���Ҳ�������62����1<a,b<=10^15��
 */
public class ��λDP {
	private int[][] dp=new int[10][10];
	
	public ��λDP(){

		for(int i=0;i<=9;i++){
			dp[0][i]=1;
		}
		dp[0][4]=0;
		for(int i=1;i<=9;i++){
			for(int j=0;j<10;j++){//iλ
				for(int k=0;k<10;k++){//i-1λ
					if(j!=4&&!(j==6&&k==2))dp[i][j]+=dp[i-1][k];
				}
			}
		}
		for(int i=0;i<=9;i++){
			for (int j=0;j<=9;j++){
				System.out.print(dp[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	public int solve(int number){
		String ss=String.valueOf(number);
		int count=0;
		int[] digits=new int[ss.length()+1];
		for(int i=0;i<ss.length();i++){
			digits[i]=number%10;
			number/=10;
		}
		digits[ss.length()]=0;
		for(int i=ss.length()-1;i>=0;i--){
			for(int j=0;j<digits[i];j++){
				if(j!=4&&!(digits[i+1]==6&&j==2))count+=dp[i][j];
			}
			if(digits[i]==4||(digits[i+1]==6&&digits[i]==2))break;
		}
		return count;
	}
	public static void main(String[] args) {
		��λDP ss=new ��λDP();
		int number=100;
		System.out.println(ss.solve(number));
	}
}
