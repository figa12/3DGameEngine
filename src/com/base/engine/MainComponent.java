package com.base.engine;

public class MainComponent {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "3D Test";
    public static final double FRAME_CAP = 5000.0;

    private boolean isRunning;
    private Game game;

    public MainComponent() {
        System.out.println("OpenGL Version: " + RenderUtil.getOpenGLVersion());
        RenderUtil.initGraphics();
        this.isRunning = false;
        this.game = new Game();
    }

    public void start() {

        if(this.isRunning)
            return;

        this.isRunning = true;

        this.run();
    }

    public void stop() {
        if(!this.isRunning)
            return;

        this.isRunning = false;
    }

    private void run() {

        int frames = 0;
        long frameCounter = 0;

        final double frameTime = 1.0 / FRAME_CAP;

        long lastTime = Time.getTime();
        double unprocessedTime = 0;

        while(this.isRunning) {

            boolean render = false;

            long startTime = Time.getTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double)Time.SECOND;
            frameCounter += passedTime;

            while(unprocessedTime > frameTime) {

                render = true;

                unprocessedTime -= frameTime;

                if(Window.isCloseRequested())
                    this.stop();

                Time.setDelta(frameTime);

                this.game.input();
                Input.update();

                this.game.update();

                if(frameCounter >= Time.SECOND) {
                    System.out.println(frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }

            if(render) {
                this.render();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        }

        this.cleanUp();
    }

    private void render() {
        RenderUtil.clearScreen();
        this.game.render();
        Window.render();
    }

    private void cleanUp() {

    }

    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        MainComponent game = new MainComponent();

        game.start();
    }

}