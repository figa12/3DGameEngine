package com.base.engine;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

/**
 * Created by Figa on 06-04-2015.
 */
public class Util {

    public static FloatBuffer createFloatBuffer(int size) {
        return BufferUtils.createFloatBuffer(size);
    }

    public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
        FloatBuffer buffer = Util.createFloatBuffer(vertices.length * Vertex.SIZE);

        for(int i = 0; i < vertices.length; i++) {
            buffer.put(vertices[i].getPos().getX());
            buffer.put(vertices[i].getPos().getY());
            buffer.put(vertices[i].getPos().getZ());
        }

        buffer.flip();

        return buffer;
    }
}
