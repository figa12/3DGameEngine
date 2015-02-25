package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {

    public Game() {

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

    }

}