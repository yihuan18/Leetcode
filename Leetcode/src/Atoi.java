public class Atoi {
    public int myAtoi(String str) {
        int startIndex = 0,endIndex = 0;
        int numLength = 0;
        int negativeflag = 1;
        long ret = 0;
        int i;
        for(i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == ' ')
                continue;
            if(str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) < '0' && str.charAt(i) > '9')
                return 0;
            else break;
        }

        startIndex = i;

        if(i == str.length())
            return 0;

        if(str.charAt(startIndex) == '-'){
           negativeflag = -1;
           startIndex++;
        }else if(str.charAt(startIndex) == '+')
            startIndex++;

        for(i = startIndex ; i < str.length() ; i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
        }

        endIndex = i;

        numLength = endIndex - startIndex;
        for(i = startIndex ; i < endIndex ; i++){
            ret += (str.charAt(i)-'0') * Math.pow(10,numLength-1);
            numLength--;
            if(ret > Integer.MAX_VALUE && negativeflag == 1)
                return Integer.MAX_VALUE;
            else if(negativeflag == -1 && (ret*negativeflag) < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        ret *= negativeflag;
        return (int)ret;
    }

    public static void main(String[] args){
        Atoi atoi = new Atoi();
        String s = "+42";
        int ret = atoi.myAtoi(s);
        System.out.print(ret);
    }
}
