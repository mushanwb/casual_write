package LeetCode;

public class No122 {

//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    输入: [7,1,5,3,6,4]
//    输出: 7
//    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//                 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//
//    输入: [7,6,4,3,1]
//    输出: 0
//    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

//    public static int maxProfit(int[] prices) {
//        int i = 0;
//        int sum = 0;
//        while (i < prices.length-1) {
//            int j = i + 1;
//            if (prices[i] > prices[j]) {
//                i++;
//                continue;
//            }
//            while (j < prices.length && prices[j] > prices[j-1]) {
//                j++;
//            }
//            sum = sum + prices[j-1] - prices[i];
//            i = j;
//        }
//        return sum;
//    }
    
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length -1 ; i++) {
            if (prices[i] < prices[i+1]) {
                sum = sum + prices[i+1] - prices[i];
            }
        }
        return sum;
    }

}
