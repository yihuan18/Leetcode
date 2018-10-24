//反转整数
public class ReverseInteger {
    public int reverse(int x) {
        String s = Integer.toString(x);
        String str = s;
        long number = 0;
        long mul = 1;
        if(s.charAt(0) == '-'){
            str = s.substring(1);
        }
        for(int i = 0 ; i < str.length() ; i++){
            number += (str.charAt(i)-'0') * mul;
            mul *= 10;
        }
        if(s.charAt(0) == '-')
            number *= -1;

        if(number > Integer.MAX_VALUE || number < Integer.MIN_VALUE)
            return 0;
        else return (int)number;
    }

    public static void main(String[] args){
        ReverseInteger reverseInteger = new ReverseInteger();
        int ret = reverseInteger.reverse(1534236469);
        System.out.print(ret);
    }
}
