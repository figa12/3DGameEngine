package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

/**
 * Created by Figa on 06-04-2015.
 */
public class Mesh {
    private int vbo;
    private int size;

    public Mesh() {
        this.vbo = glGenBuffers();
        this.size = 0;
    }

    public void addVertices(Vertex[] vertices) {
        this.size = vertices.length;// * Vertex.SIZE;

        glBindBuffer(GL_ARRAY_BUFFER, this.vbo);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
    }

    public void draw() {
        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, this.vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);

        glDrawArrays(GL_TRIANGLES, 0, this.size);

        glDisableVertexAttribArray(0);
    }
}
