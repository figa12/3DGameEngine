package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {

    private Mesh mesh;
    private Shader shader;

    public Game() {
        this.mesh = new Mesh();
        this.shader = new Shader();

        Vertex[] data = new Vertex[] {new Vertex(new Vector3f(-1,-1,0)),
                                      new Vertex(new Vector3f(0,1,0)),
                                      new Vertex(new Vector3f(1,-1,0))};

        mesh.addVertices(data);

        this.shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        this.shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
        this.shader.compileShader();
    }

    public void input() {
        if(Input.getKeyDown(Keyboard.KEY_UP)) {
            System.out.println("We pressed up!");
        }

        if(Input.getKeyUp(Keyboard.KEY_UP)) {
            System.out.println("We released up!");
        }

        if(Input.getMouseDown(1)) {
            System.out.println("We right clicked at " + Input.getMousePosition().toString());
        }

        if(Input.getMouseUp(1)) {
            System.out.println("We released right click!");
        }
    }

    public void update() {

    }

    public void render() {
        this.shader.bind();
        mesh.draw();
    }

}