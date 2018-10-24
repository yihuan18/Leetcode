public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[256];
        if(s.length() != t.length())
            return false;
        for(int i = 0 ; i < s.length() ; i++){
            charCount[s.charAt(i)]++;
        }
        for(int i = 0 ; i < t.length() ; i++){
            char currentChar = t.charAt(i);
            if(charCount[currentChar] != 0)
                charCount[currentChar]--;
            else return false;
        }
        return true;
    }
}
