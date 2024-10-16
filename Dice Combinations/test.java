
/*
Another shot
*/
/*
 
*/
import java.io.*;
import java.util.*;

public class test {
    public static int m = 1000000007;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int a[]={1,2,3,4,5,6};
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=helper(n,a,6,dp)%m;
        out.println(ans);
        out.close();
    }
    static int helper(int n,int a[],int l,int dp[]){
        if(l==0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n]%m;
        int ans=0;
        for(int i=1;i<=l;i++){
            if(i<=n)
            ans+= helper(n-i, a, l,dp)%m;
        }
        return dp[n]=ans%m;
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

    static int UpperBound(int a[], int x) {
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (a[m] <= x)
                l = m;
            else
                r = m;
        }
        return l + 1;
    }

    static int LowerBound(int a[], int x) {
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= x)
                r = m;
            else
                l = m;
        }
        return r;
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