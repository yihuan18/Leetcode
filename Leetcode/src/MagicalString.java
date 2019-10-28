/**
 * @author 🐰
 * @since  2019/10/28 4:15 PM
 * 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
 * 字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
 * 字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
 * 如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * 并且每个组中 '1' 或 '2' 的出现次数分别是：
 * 1 2 2 1 1 2 1 2 2 1 2 2 ......
 * 你可以看到上面的出现次数就是 S 本身。
 * 给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
 * 注意：N 不会超过 100,000。
 */
public class MagicalString {
    public static int magicalString(int n) {

        if(n <= 0){
            return 0;
        }

        if(n <= 3){
            return 1;
        }

        int totalOne = 1;

        StringBuilder stringBuilder = new StringBuilder("122");
        int timesIndex = 2;
        int stringIndex = 3;

        while (true){
            int times = stringBuilder.charAt(timesIndex) - '1' + 1;
            char lastDigit = stringBuilder.charAt(stringIndex - 1);

            if(lastDigit == '1'){
                for(int i = 0 ; i < times ; i++) {
                    stringBuilder.append('2');
                    stringIndex++;
                    if(stringIndex == n){
                        break;
                    }
                }
            }

            else if(lastDigit == '2'){
                for(int i = 0 ; i < times ; i++) {
                    stringBuilder.append('1');
                    totalOne++;
                    stringIndex++;
                    if(stringIndex == n){
                        break;
                    }
                }
            }

            timesIndex++;

            if(stringIndex >= n){
                return totalOne;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(magicalString(6));
    }
}
