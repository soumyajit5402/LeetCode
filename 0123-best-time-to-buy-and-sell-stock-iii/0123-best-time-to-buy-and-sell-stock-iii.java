class Solution {
    public int maxProfit(int[] prices) {
        int maxRight = prices[prices.length - 1];
        int[] maxProfit1Trxn = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit1Trxn[i] = Math.max(0, maxRight - prices[i]);
            maxRight = Math.max(maxRight, prices[i]);
        }
        
        int[] maxProfitRight = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfitRight[i] = Math.max(maxProfit1Trxn[i], maxProfitRight[i+1]);
        }
        
        int minLeft = prices[0], totalMaxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currProfit = Math.max(0, prices[i] - minLeft) + maxProfitRight[i];
            totalMaxProfit = Math.max(totalMaxProfit, currProfit);
            minLeft = Math.min(minLeft, prices[i]);
        }
        return totalMaxProfit;
    }
}