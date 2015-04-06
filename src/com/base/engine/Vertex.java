package com.base.engine;

/**
 * Created by Figa on 06-04-2015.
 */
public class Vertex {
    public static final int SIZE = 3;

    private Vector3f pos;

    public Vertex(Vector3f pos) {
        this.pos = pos;
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }
}
