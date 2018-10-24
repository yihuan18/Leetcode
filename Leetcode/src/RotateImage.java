import javax.swing.*;
//将矩阵顺时针旋转90度
public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int lastCircle = length/2;
        for(int times = 0 ; times < lastCircle ; times++){
            int start_i = times,start_j = times;
            int current_i = times , current_j = times;
            int next_i,next_j;
            int current = matrix[times][times];
            int num = (length - 2 * times - 1) * 4;
            for(int i = 0 ; i < num ; i++){
                next_i = current_j;
                next_j = length - 1 - current_i;
                int temp = matrix[next_i][next_j];
                matrix[next_i][next_j] = current;
                current = temp;
                current_i = next_i;
                current_j = next_j;
                if(next_i == start_i && next_j == start_j) {
                    start_i++;
                    current = matrix[start_i][start_j];
                    current_i = start_i;
                    current_j = start_j;
                }
            }
        }
    }

    public static void main(String[] args){
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateImage.rotate(matrix);
        for(int i = 0; i < matrix.length ;i++) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j]);
        }
    }
}
