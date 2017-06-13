package algorithm;

import java.util.*;

public class code03_KMP{
    public static int[] next(String pattern){
        int[] next=new int[pattern.length()+1];
        int k=-1;
        int j=0;
        next[0]=k;
        while(j<pattern.length()){
            if (k==-1||pattern.charAt(k)==pattern.charAt(j)){
                next[++j]=++k;
            }else{
                k=next[k];
            }
        }
        return next;
    }
    public static int search(String match,String pattern,int[] next){
        int i=0;
        int j=0;
        int count=0;
        while(i<match.length()){
            if(j==-1||pattern.charAt(j)==match.charAt(i)){
                j++;
                i++;
            }else{
                j=next[j];
            }
            if(j==pattern.length()){
            	
                count++;
                
                j=next[j];
            }
        }
        
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());
        for(int i=0;i<num;i++){
            String pattern=sc.nextLine();
            String match=sc.nextLine();
            int[] next=next(pattern);
            //System.out.println(Arrays.toString(next));
            int count=search(match,pattern,next);

            System.out.println(count);
        }
    
    }
}