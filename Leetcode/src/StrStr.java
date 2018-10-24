public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        int hay_pointer = 0 , needle_pointer = 0;
        while(true) {
            //首先匹配首字母
            while (haystack.charAt(hay_pointer) != needle.charAt(needle_pointer)) {
                hay_pointer++;
                if (hay_pointer == haystack.length())
                    break;
            }
            if (hay_pointer == haystack.length() || (haystack.length() - hay_pointer) < needle.length())
                return -1;
            int hay_pointer_copy = hay_pointer + 1;
            boolean found = true;
            for (int i = 1; i < needle.length(); i++) {
                if (haystack.charAt(hay_pointer_copy) != needle.charAt(i)) {
                    found = false;
                    break;
                } else
                    hay_pointer_copy++;
            }
            if (found)
                return hay_pointer;
            hay_pointer++;
            if ((haystack.length() - hay_pointer) < needle.length())
                return -1;
        }
    }
    public static void main(String[] args){
        StrStr strStr = new StrStr();
        int ret = strStr.strStr("","");
        System.out.print(ret);
    }
}
