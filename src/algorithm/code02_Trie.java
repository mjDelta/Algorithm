package algorithm;


import java.util.*;
public class code02_Trie{
    int num;
    code02_Trie[] next;
    public code02_Trie(){
        num=0;
        next=new code02_Trie[26];
        for(int i=0;i<26;i++){
            next[i]=null;
        }
    }    
    public static void code02_Trie(String[] args){
        code02_Trie root=new code02_Trie();
        Scanner sc=new Scanner(System.in);
        int word_num=Integer.valueOf(sc.nextLine());
        /*
         *构造Trie树的过程
         */
        for(int i=0;i<word_num;i++){
            String word=sc.nextLine();
            code02_Trie p=root;
            for(int j=0;j<word.length();j++){
                char letter=word.charAt(j);
                int idx=letter-'a';
                if(p.next[idx]==null){
                    p.next[idx]=new code02_Trie();   
                }
                p=p.next[idx];
                p.num+=1;
            }
        }
        /*
         *查询过程
         */
         int query_num=Integer.valueOf(sc.nextLine());
         for(int i=0;i<query_num;i++){
            String query=sc.nextLine();
            code02_Trie q=root;
            int j=0;
            boolean f=true;
            for(;j<query.length();j++){
                char letter=query.charAt(j);
                int idx=letter-'a';
                if (q.next[idx]==null){
                	f=false;
                	break;
                }
                q=q.next[idx];
            }
            if(f)System.out.println(q.num);
            else System.out.println(0);
             
         }
    }
    
}