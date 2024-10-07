package maximumProfitInJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || endTime == null || profit == null) {
            return 0;
        }
        if (startTime.length != endTime.length || endTime.length != profit.length) {
            return 0;
        }

        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(j -> j.startTime));

        int[] dp = new int[jobs.length];
        Arrays.fill(dp, -1);
        takeOrSkipJob(jobs, dp, 0);

        int maxProfit = 0;
        for (int p : dp) {
            maxProfit = Math.max(maxProfit, p);
        }
        return maxProfit;
    }

    private int takeOrSkipJob(Job[] jobs, int[] dp, int i) {
        if (i >= jobs.length) {
            return 0;
        }

        // if we have calculated it previously, return it
        if (dp[i] != -1) {
            return dp[i];
        }

        // skip job, move to the next one
        int skipJobProfit = takeOrSkipJob(jobs, dp, i + 1);

        // take job, move to the next one such as next.startTime >= current.endTime
        int j = binarySearchNextJobIndex(jobs, i);
        int takeJobProfit = jobs[i].profit + takeOrSkipJob(jobs, dp, j);

        return dp[i] = Math.max(skipJobProfit, takeJobProfit);
    }

    private int binarySearchNextJobIndex(Job[] jobs, int i) {
        int left = i + 1;
        int right = jobs.length - 1;
        int currentJobEndTime = jobs[i].endTime;

        if (currentJobEndTime > jobs[right].startTime) {
            return jobs.length; // no more jobs can be taken
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (jobs[middle].startTime < currentJobEndTime) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}