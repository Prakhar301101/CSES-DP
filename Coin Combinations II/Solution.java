
/*Another shot*/
/*
 dp(i,k) represents the number of coins required to create a sum of k
 where coins from i to n-1 are usable
*/
import java.io.*;
import java.util.*;

public class Solution {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        /*
         * 1.Relax
         * 2.Dont submit before checking different cases
         * 3.If WA then dont submit again before proper debugging
         */
        int ttt = 1;
        // ttt = sc.nextInt();
        outer: while (ttt-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int a[] = sc.readArray(n);
            int dp[][]=new int[n+1][x+1];
            for(int i=0;i<n;i++) dp[i][0]=1;
            for(int i=n-1;i>=0;i--){
                for(int j=1;j<=x;j++){
                    int skip=dp[i+1][j];
                    int pick=0;
                    if(a[i]<=j){
                        pick=dp[i][j-a[i]];
                    }
                    dp[i][j]=(skip+pick)%mod;
                }
            }
            out.println(dp[0][x]);
        }
        out.close();
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void revsort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l, Collections.reverseOrder());
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static long modinv(long a) {
        int m = 1000000007;
        if (a == 1)
            return 1;
        return (m - ((m / a) * modinv(m % a)) % m) % m;
    }

    static int pow(int a, int b) {
        int m = 1000000007;
        if (b == 0)
            return 1;
        else if (b == 1)
            return a;
        else {
            int ans = pow(a, b / 2);
            if (b % 2 == 0)
                return ((ans % m * ans % m) % m);
            else
                return ((ans % m * ans % m * a) % m);
        }
    }

    static boolean[] sieve(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == true) {
                for (int j = 2 * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    /* ......FAST SCANNER template taken from secondthread...... */
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextdouble() {
            return Double.parseDouble(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readArrayL(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}