package Lec_DP;

public class Edit_distance {
	public int solve(int i1, int i2,String word1, String word2) {
        if(i1==word1.length() || i2== word2.length()){
            return Math.max(word1.length()-i1,word2.length()-i2);
        }
         
         if(word1.charAt(i1)==word2.charAt(i2)){
             int sp3 = solve(i1+1,i2+1,word1,word2); // replace
             return sp3;
         }
         int sp1 = solve(i1,i2+1,word1,word2); // insert
         int sp2 = solve(i1+1,i2,word1,word2); // del
         int sp3 = solve(i1+1,i2+1,word1,word2); // replace
         
         return 1+Math.min(sp1,Math.min(sp3,sp2));
         
    }
}
