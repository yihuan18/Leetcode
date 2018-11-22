/*
LeetCode Q204 : 计数质数
统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {
    private int[] primes;
    private int count;
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        primes = new int[n];
        primes[0] = 2;
        count = 1;
        for(int i = 3 ; i < n ; i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }

    private boolean isPrime(int x){
        int i = 0;
        double length = Math.sqrt(x);
        while(primes[i] <= length){
            if(x % primes[i] == 0)
                return false;
            i++;
        }
        primes[count] = x;
        return true;
    }

    /*
    public int countPrimes(int n) {
        if(n < 3) return 0;
        boolean[] flag = new boolean[n];
        int count = n / 2;
        for(int i = 3; i*i < n; i += 2){
            if(flag[i]) continue;
            for(int j = i*i; j < n; j += 2*i){
                if(!flag[j]){
                    count--;
                    flag[j] = true;
                }
            }
        }
        return count;
    }
     */

    public static void main(String[] args){
        CountPrimes countPrimes = new CountPrimes();
        int ret = countPrimes.countPrimes(1500000);
        System.out.print(ret);
    }
}
