package Lec_DP;

import java.util.ArrayList;

public class LIS {

	public static int solve(int i, int prev, int[] nums) {
		if (i == nums.length) {
			return 0;
		}
		int sp1 = solve(i + 1, prev, nums);
		int sp2 = 0;
		if (nums[i] > prev) {
			sp2 = 1 + solve(i + 1, nums[i], nums);
		}
		
		return Math.max(sp1, sp2);
	}
	public static int solve(int i, int prevIdx, int[] nums,Integer[][]dp) {
		if (i == nums.length) {
			return 0;
		}
//         dp[i][prevIdx+1] = solve(i,prevIdx)
        if(dp[i][prevIdx+1]!=null){
            return dp[i][prevIdx+1];
        }
		int sp1 = solve(i + 1, prevIdx, nums,dp);
		int sp2 = 0;
		if (prevIdx==-1||nums[i] > nums[prevIdx] ) {
			sp2 = 1 + solve(i + 1, i, nums,dp);
		}
		dp[i][prevIdx+1] = Math.max(sp1, sp2);
		return Math.max(sp1, sp2);
	}
	public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> AL = new ArrayList<>();
        for(int ali : nums){
            if(AL.isEmpty() || ali > AL.get(AL.size()-1)){
                AL.add(ali);
            }else{
                int s = 0;
                int e = AL.size()-1;
                int ans =-1;
                while(s<=e){
                    int mid = (s+e)/2;
                    if(ali<=AL.get(mid)){
                        ans = mid;
                        e = mid-1;
                    }else{
                        s = mid+1;
                    }
                }
                AL.set(ans,ali);
            }   
        }
        return AL.size();
    }
	
}
