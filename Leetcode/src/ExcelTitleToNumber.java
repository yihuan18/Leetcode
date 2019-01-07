/*
Leetcode Q171 : Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
*/
public class ExcelTitleToNumber {
    public int titleToNumber(String s) {
        int N = s.length();
        int ret = 0;
        for(int i = N - 1 ; i >= 0 ; i--){
            ret += (s.charAt(i)-'A'+1) * Math.pow(26,N-i-1);
        }
        return ret;
    }

    public static void main(String[] args) {
        ExcelTitleToNumber ettn = new ExcelTitleToNumber();
        System.out.print(ettn.titleToNumber("AAA"));
    }

}
