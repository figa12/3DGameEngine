package com.base.engine;

/**
 * Created by Figa on 25-02-2015.
 */
public class Vector3f {

    private float x;
    private float y;
    private float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public float dot(Vector3f r) {
        return x * r.getX() + y * r.getY() + z * r.getZ();
    }

    public Vector3f cross(Vector3f r) {
        float x_ = y * r.getZ() - z * r.getY();
        float y_ = z * r.getX() - x * r.getZ();
        float z_ = x * r.getY() - y * r.getX();

        return new Vector3f(x_, y_, z_);
    }

    public Vector3f normalize() {
        float length = length();

        this.x /= length;
        this.y /= length;
        this.z /= length;

        return this;
    }

    public Vector3f rotate() {
        return null;
    }

    public Vector3f add(Vector3f r) {
        return new Vector3f(this.x + r.getX(), this.y + r.getY(), z + r.getZ());
    }

    public Vector3f add(float r) {
        return new Vector3f(this.x + r, this.y + r, this.z + r);
    }

    public Vector3f subtract(Vector3f r) {
        return new Vector3f(this.x - r.getX(), this.y - r.getY(), z - r.getZ());
    }

    public Vector3f subtract(float r) {
        return new Vector3f(this.x - r, this.y - r, this.z - r);
    }

    public Vector3f multiply(Vector3f r) {
        return new Vector3f(this.x * r.getX(), this.y * r.getY(), z * r.getZ());
    }

    public Vector3f multiply(float r) {
        return new Vector3f(this.x * r, this.y * r, this.z * r);
    }

    public Vector3f divide(Vector3f r) {
        return new Vector3f(this.x / r.getX(), this.y / r.getY(), z / r.getZ());
    }

    public Vector3f divide(float r) {
        return new Vector3f(this.x / r, this.y / r, this.z / r);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
