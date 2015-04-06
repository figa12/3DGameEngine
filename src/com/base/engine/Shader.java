package com.base.engine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

/**
 * Created by Figa on 06-04-2015.
 */
public class Shader {
    private int program;

    public Shader() {
        this.program = glCreateProgram();

        if(this.program == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location in constructor");
            System.exit(1);
        }
    }

    public void bind() {
        glUseProgram(this.program);
    }

    public void addVertexShader(String text) {
        this.addProgram(text, GL_VERTEX_SHADER);
    }

    public void addGeometryShader(String text) {
        this.addProgram(text, GL_GEOMETRY_SHADER);
    }

    public void addFragmentShader(String text) {
        this.addProgram(text, GL_FRAGMENT_SHADER);
    }

    public void compileShader() {
        glLinkProgram(this.program);

        if(glGetProgrami(this.program, GL_LINK_STATUS) == 0) {
            System.err.println(glGetProgramInfoLog(this.program, 1024));
            System.exit(1);
        }

        glValidateProgram(this.program);

        if(glGetProgrami(this.program, GL_VALIDATE_STATUS) == 0) {
            System.err.println(glGetProgramInfoLog(this.program, 1024));
            System.exit(1);
        }
    }

    private void addProgram(String text, int type) {
        int shader = glCreateShader(type);

        if(shader == 0) {
            System.err.println("Shader creation failed: Could not find valid memory location when adding shader");
            System.exit(1);
        }

        glShaderSource(shader, text);
        glCompileShader(shader);

        if(glGetShaderi(shader, GL_COMPILE_STATUS) == 0) {
            System.err.println(glGetShaderInfoLog(shader, 1024));
            System.exit(1);
        }

        glAttachShader(this.program, shader);
    }
}
