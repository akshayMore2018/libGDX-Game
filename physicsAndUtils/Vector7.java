package com.mygdx.game.physicsAndUtils;


public class Vector7
{

    public double x, y, z;

    public Vector7()
    {
    }

    public Vector7(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Vector7(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public void set(Vector7 v)
    {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public void set(float Vx, float Vy)
    {
        this.x = Vx;
        this.y = Vy;
        this.z = 0;
    }

    public void add(Vector7 v)
    {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    public void add(double pX, double pY, double pZ)
    {
        x += pX;
        y += pY;
        z += pZ;
    }

    public void sub(Vector7 v)
    {
        x -= v.x;
        y -= v.y;
        z -= v.z;
    }

    public void sub(double pX, double pY, double pZ)
    {
        x -= pX;
        y -= pY;
        z -= pZ;
    }

    public void div(double val)
    {
        x /= val;
        y /= val;
        z /= val;
    }

    public void mult(double val)
    {
        x *= val;
        y *= val;
        z *= val;
    }

    public double magnitude()
    {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double dot(Vector7 v)
    {
        return x * v.x + y * v.y + z * v.z;
    }

    public void normalize()
    {
        double mag = magnitude();
        if (mag != 0)
        {
            x /= mag;
            y /= mag;
            z /= mag;
        }
    }

    public void limit(double lim)
    {
        double mag = magnitude();
        if (mag != 0 && mag > lim)
        {
            x *= lim / mag;
            y *= lim / mag;
            z *= lim / mag;
        }
    }

    public double heading()
    {
        return Math.atan2(y, x);
    }

    public static Vector7 sub(Vector7 v, Vector7 v2)
    {
        return new Vector7(v.x - v2.x, v.y - v2.y);
    }

    public static double distanceBetweenTwoVectors(Vector7 v, Vector7 v2)
    {
        return Math.sqrt(Math.pow(v.x - v2.x, 2) + Math.pow(v.y - v2.y, 2));
    }

    public static double angleBetweenTwoVectors(Vector7 v, Vector7 v2)
    {
        return Math.acos(v.dot(v2) / (v.magnitude() * v2.magnitude()));
    }


    public void rotate(double angle_degrees)
    {
        double radians = Math.toRadians(angle_degrees);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        x = x * cos - y * sin;
        y = x * sin + y * cos;
    }


}