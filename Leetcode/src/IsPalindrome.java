public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null)
            return true;

        int frontIndex = 0;
        int tailIndex = s.length() - 1;
        while(tailIndex > frontIndex)
        {
            if(!isValidChar(s.charAt(tailIndex))){
                tailIndex--;
                continue;
            }
            if(!isValidChar(s.charAt(frontIndex))){
                frontIndex++;
                continue;
            }
            if(!AequalsB(s.charAt(frontIndex) , s.charAt(tailIndex))){
                return false;
            }
            else {
                frontIndex++;
                tailIndex--;
            }
        }
        return true;
    }

    private boolean isValidChar(char c){
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }

    private boolean AequalsB(char a , char b){
        if(a == b)
            return true;
        else if(a >= 'a' && a <= 'z'){
            return (Character.toUpperCase(a) == b);
        }
        else if(a >= 'A' && a <= 'Z'){
            return (Character.toLowerCase(a) == b);
        }
        return false;
    }
}
