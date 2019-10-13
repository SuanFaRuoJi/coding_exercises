public class matrix {
    int[][] raw_matrix;
    int origin_x, origin_y, width, height, actual_w, actual_h;
    // mind x is vertical, y is horizontal

    /*
     * copying the original matrix to save time and space
     * */
    matrix(matrix source, int x, int y, int height, int width){
        raw_matrix = source.raw_matrix;
        this.origin_x = x;
        this.origin_y = y;
        this.width = width;
        this.height = height;
        this.actual_w = Math.min(source.actual_w-(y-source.origin_y), width);
        this.actual_h = Math.min(source.actual_h-(x-source.origin_x), height);
    }

    /*
     * create a new matrix from int arrs;
     * */
    matrix(int[][] source){
        this.raw_matrix = source;
        this.origin_x = 0;
        this.origin_y = 0;
        this.height = source.length;
        this.width = source[0].length;
        this.actual_h = height;
        this.actual_w = width;
    }

    matrix multiply(matrix b){
        return new matrix(multiple(this, b));
    }

    static int[][] multiple(matrix a, matrix b){ // a * b, result should be [a.height][b.width]
        int[][] result = new int[a.height][b.width];
        if (b.width==1 && b.height==1){
            int b_val = b.get(0,0);
            if (b_val != 0){
                for (int i=0; i<a.actual_h; i++){ //no need to go beyond this point;
                    int a_val = a.get(i, 0);
                    result[i][0] = a_val * b_val;
                }
            }
            return result;
        }
        if (a.width==1 && a.height==1){
            int a_val = a.get(0,0);
            if (a_val != 0){
                for (int i=0; i<b.actual_w; i++){
                    int b_val = b.get(0, i);
                    result[0][i] = a_val * b_val;
                }
            }
            return result;
        }
        matrix[][] A = a.split(), B = b.split();
        matrix s_1 = add(B[1][2], B[2][2], false);
        matrix s_2 = add(A[1][1], A[1][2], true);
        matrix s_3 = add(A[2][1], A[2][2], true);
        matrix s_4 = add(B[2][1], B[1][1], false);
        matrix s_5 = add(A[1][1], A[2][2], true);
        matrix s_6 = add(B[1][1], B[2][2], true);
        matrix s_7 = add(A[1][2], A[2][2], false);
        matrix s_8 = add(B[2][1], B[2][2], true);
        matrix s_9 = add(A[1][1], A[2][1], false);
        matrix s_10 = add(B[1][1], B[1][2], true);

        matrix p_1 = A[1][1].multiply(s_1);
        matrix p_2 = s_2.multiply(B[2][2]);
        matrix p_3 = s_3.multiply(B[1][1]);
        matrix p_4 = A[2][2].multiply(s_4);
        matrix p_5 = s_5.multiply(s_6);
        matrix p_6 = s_7.multiply(s_8);
        matrix p_7 = s_9.multiply(s_10);

        matrix c_00 = add(p_5, add(p_4, add(p_2, p_6, false), false), true);
        matrix c_01 = add(p_1, p_2, true);
        matrix c_10 = add(p_3, p_4, true);
        matrix c_11 = add(p_5, add(p_1, add(p_3, p_7, true), false), true);

        copy(result, c_00, 0,0);
        copy(result, c_01, 0, c_00.width);
        copy(result, c_10, c_00.height, 0);
        copy(result, c_11, c_00.height, c_00.width);
        return result;
    }

    matrix[][] split(){
        matrix[][] A = new matrix[3][3];
        int new_height = (height+1)/2, new_width = (width+1)/2;
        A[1][1] = new matrix(this, origin_x, origin_y, new_height, new_width);
        A[1][2] = new matrix(this, origin_x, origin_y+new_width, new_height, new_width);
        A[2][1] = new matrix(this, origin_x+new_height, origin_y, new_height, new_width);
        A[2][2] = new matrix(this, origin_x+new_height, origin_y+new_width, new_height, new_width);
        return A;
    }

    static matrix add(matrix a, matrix b, boolean add){ // will reset the index to 0 start
        int[][] source = new int[a.height][a.width];
        for (int i=0; i<a.height; i++){
            for (int j=0; j<a.width; j++){
                source[i][j] = a.get(i, j) + (add ? b.get(i, j) : -b.get(i, j));
            }
        }
        return new matrix(source);
    }

    int get(int i, int j){
        int abs_i = origin_x+i;
        int abs_j = origin_y+j;
        return i<actual_h&&j<actual_w ? raw_matrix[abs_i][abs_j] : 0;
    }

    static void copy(int[][] dst, matrix src, int origin_x, int origin_y){
        for (int i=0; i<src.height && origin_x+i<dst.length; i++){
            for (int j=0; j<src.width && origin_y+j<dst[0].length; j++){
                int val = src.get(i, j);
                dst[i+origin_x][j+origin_y] = val;
            }
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("matrix: " + height + ", " + width + "/" + actual_h + ", " + actual_w + " starting from " + origin_x + ", " + origin_y + "\n");
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                result.append(get(i, j) + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
