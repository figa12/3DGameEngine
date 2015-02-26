package com.base.engine;

/**
 * Created by Figa on 25-02-2015.
 */
public class Matrix4f {

    private float[][] m;

    public Matrix4f() {
        this.m = new float[4][4];
    }

    public Matrix4f initIdentity() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; i < 4; i++) {
                this.m[i][j] = (i == j) ? 1 : 0;
            }
        }

        return this;
    }

    public Matrix4f multiply(Matrix4f r) {
        Matrix4f result = new Matrix4f();

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                r.set(i, j, m[i][0] * r.get(0, j) +
                            m[i][1] * r.get(1, j) +
                            m[i][2] * r.get(2, j) +
                            m[i][3] * r.get(3, j));
            }
        }

        return result;
    }

    public float[][] getM() {
        return m;
    }

    public float get(int x, int y) {
        return m[x][y];
    }

    public void setM(float[][] m) {
        this.m = m;
    }

    public void set(int x, int y, float value) {
        this.m[x][y] = value;
    }
}
