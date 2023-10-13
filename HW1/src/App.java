public class App {

    public static void main(String[] args) {
        String num1, num2;
        num1 = args[0];
        // num2 = args [1];
        // if (isMultiple(Long.parseLong(num1), Long.parseLong(num2))) {
        // if (isEven(Integer.parseInt(num1))) {
            // System.out.println("true");
        // } else {
            // System.out.println("false");
        // }
        System.out.println(String.valueOf(oddSum(Integer.parseInt(num1))));
    }

    private static boolean isMultiple(long n, long m) {
        if (n != 0 && (m % n) == 0) {
            return true;
        }
        return false;
    }

    private static boolean isEven(int i) {
        if ((i & 1) == 0) {
            return true;
        }
        return false;
    }

    private static long oddSum(int n) {
        long sum = 0;

        if (n % 2 == 0 && n != 0) {
            n--;
        }

        for (int i = 1; i <= n; i +=2) {
            sum += i;
        }
        return sum;
    }

    //R-2.11
    //Ship it.Box it.Buy it.Read it.Buy it.Buy it.
    // Read it.Ship it.Buy it.Read it.Box it.Read it.

    // R-2.13
    // d can be cast to a racer but it will take two steps. First you must cast equestrian to a horse, then you must cast the horse to a racer 

    //R-4.2 
    // A is faster than B for all n >= 1 because 

    //R-4.8 
    // 2^10 , 2^logn , 3n + 100logn , 4n , nlogn , 4nlogn + 2n, n^2 + 10n, n^3, 2^n

    //R-4.22 Show that (n+1)^5 is the same as n^5
    // they are the same because bigO for n^5 is O(n^5) and bigO for 

    //R.23 Same as ^^^ but with 2^n+t and 2^n

    //R-4.34 
    // Assuming that meal qualtiy is distributed evenly acrross a person's lifetime they will experience happiness once.
}