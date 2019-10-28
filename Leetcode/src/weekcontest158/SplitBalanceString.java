package weekcontest158;

public class SplitBalanceString {
    public static int balancedStringSplit(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }

        int splitCount = 0;
        int RCount = 0;
        int LCount = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'R'){
                RCount++;
            }else {
                LCount ++;
            }
            if(RCount == LCount){
                splitCount++;
                RCount = 0;
                LCount = 0;
            }
        }
        return splitCount;
    }

    public static void main(String[] args) {
        int ret = balancedStringSplit("LLLLRRRR");
        System.out.println(ret);
    }
}
