package com.base.engine;

/**
 * Created by Figa on 24-02-2015.
 */
public class Vector2f {

    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public float dot(Vector2f r) {
        return x * r.getX() + y * r.getY();
    }

    public Vector2f normalize() {
        float length = length();

        this.x /= length;
        this.y /= length;

        return this;
    }

    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Vector2f((float)(this.x * cos - y * sin), (float)(x * sin + y * cos));
    }

    public Vector2f add(Vector2f r) {
        return new Vector2f(this.x + r.getX(), this.y + r.getY());
    }

    public Vector2f add(float r) {
        return new Vector2f(this.x + r, this.y + r);
    }

    public Vector2f subtract(Vector2f r) {
        return new Vector2f(this.x - r.getX(), this.y - r.getY());
    }

    public Vector2f subtract(float r) {
        return new Vector2f(this.x - r, this.y - r);
    }

    public Vector2f multiply(Vector2f r) {
        return new Vector2f(this.x * r.getX(), this.y * r.getY());
    }

    public Vector2f multiply(float r) {
        return new Vector2f(this.x * r, this.y * r);
    }

    public Vector2f divide(Vector2f r) {
        return new Vector2f(this.x / r.getX(), this.y / r.getY());
    }

    public Vector2f divide(float r) {
        return new Vector2f(this.x / r, this.y / r);
    }

    public String toString() {
        return "(" + x + " " + y + ")";
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
