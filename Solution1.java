class Solution {
    public long f(int ind,int[][] questions,long[] dp)
    {
        if(ind>=questions.length)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        long t=questions[ind][0]+f(ind+questions[ind][1]+1,questions,dp);
        long nt=f(ind+1,questions,dp);
        return dp[ind]=Math.max(t,nt);
    }
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return f(0,questions,dp);
    }
}