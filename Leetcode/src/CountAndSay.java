public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String target = "1";
        for(int times = 0 ; times < n-1 ; times++){
            StringBuilder result = new StringBuilder();
            int targetPointer = 0;
            Integer count = 1;
            while(true){
                if(targetPointer == (target.length() - 1)){
                    result.append(count.toString());
                    result.append(target.charAt(targetPointer));
                    break;
                }
                if(target.charAt(targetPointer) == target.charAt(targetPointer + 1)){
                    count++;
                    targetPointer++;
                }
                else{
                    result.append(count.toString());
                    result.append(target.charAt(targetPointer));
                    count = 1;
                    targetPointer++;
                }
            }
            target = result.toString();
        }
        return target;
    }
    public static void main(String[] args){
        CountAndSay countAndSay = new CountAndSay();
        String ret = countAndSay.countAndSay(30);
        System.out.print(ret);
    }
}
