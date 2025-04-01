# april1_2025
The problem that i solved today in leetcode

1.You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
Return the maximum points you can earn for the exam.

Code:
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
