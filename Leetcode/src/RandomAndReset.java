import java.util.*;

/**
 * @author 🐰
 * @since  2019/10/28 1:40 PM
 * 题中给出一个 n 行 n 列的二维矩阵 (n_rows,n_cols)，且所有值被初始化为 0。
 * 要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；
 * 同样编写一个 reset 函数，将所有的值都重新置为 0。
 * 尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。
 */

public class RandomAndReset {

    Set<List<Integer>> set = new HashSet<>();
    private int rows;
    private int cols;
    Random random = new Random();

    public RandomAndReset(int n_rows, int n_cols){
        rows = n_rows;
        cols = n_cols;
    }

    public int[] flip() {
        List<Integer> pos = getRandomPos();
        while (set.contains(pos)){
            pos = getRandomPos();
        }
        set.add(pos);
        return new int[]{pos.get(0),pos.get(1)};
    }

    public void reset() {
        set.clear();
    }

    private List<Integer> getRandomPos(){
        int x = random.nextInt(rows);
        int y = random.nextInt(cols);
        List<Integer> pos = new ArrayList<>();
        pos.add(x);
        pos.add(y);
        return pos;
    }

    public static void main(String[] args) {
        RandomAndReset randomAndReset = new RandomAndReset(2,3);
        int i = 3;
        while (i-- > 0) {
            int[] flip = randomAndReset.flip();
            System.out.println(flip[0] + "," + flip[1]);
        }
    }
}
