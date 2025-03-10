public class MainClass {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < len; i++) {
            int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int first = 1, second = 2, result = 0;
        
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        
        return result;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // อัพเดตราคาซื้อที่ต่ำที่สุด
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // คำนวณกำไรสูงสุด
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {

        System.out.println("## Q1 ##################");
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // Output: 0
        System.out.println("----------------------------------------------------");

        System.out.println("## Q2 ##################");
        System.out.println(compareVersion("1.01", "1.001")); // Output: 0
        System.out.println(compareVersion("1.0", "1.0.0")); // Output: 0
        System.out.println(compareVersion("0.1", "1.1")); // Output: -1
        System.out.println("----------------------------------------------------");

        System.out.println("## Q3 ##################");
        System.out.println(climbStairs(2)); // Output: 2
        System.out.println(climbStairs(3)); // Output: 3
        System.out.println(climbStairs(5)); // Output: 8
        System.out.println("----------------------------------------------------");
    }
}