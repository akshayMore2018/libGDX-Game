package com.mygdx.game.Utils;

public class NewVector7
{

	public double x, y;
	
	public NewVector7(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//vector operations that modify the original
	public void set(NewVector7 v)
	{
		x = v.x;
		y = v.y;
	}

	public void set(float Vx, float Vy)
	{
		x = Vx;
		y = Vy;
	}

	public void add(NewVector7 v)
	{
		x += v.x;
		y += v.y;
	}

	public void add(double pX, double pY, double pZ)
	{
		x += pX;
		y += pY;
	}

	public void sub(NewVector7 v)
	{
		x -= v.x;
		y -= v.y;
	}

	public void sub(double pX, double pY, double pZ)
	{
		x -= pX;
		y -= pY;
		
	}

	public void div(double val)
	{
		x /= val;
		y /= val;
	}

	public void mult(double val)
	{
		x *= val;
		y *= val;
	}


	public double dot(NewVector7 v)
	{
		return x * v.x + y * v.y;
	}

	public void limit(double lim)
	{
		double mag = mag(this);
		if (mag != 0 && mag > lim)
		{
			x *= lim / mag;
			y *= lim / mag;
		}
	}
	public void normalize()
	{
		double mag = mag(this);
		if (mag != 0)
		{
			x /= mag;
			y /= mag;
		}
	}


	public void rotate(double angle_degrees)
	{
		double radians = Math.toRadians(angle_degrees);
		double cos = Math.cos(radians);
		double sin = Math.sin(radians);
		x = x * cos - y * sin;
		y = x * sin + y * cos;
	}



//----------------------------vector operations that don't modify the original-------------------------------------------------------------------------------//


	public static NewVector7 add(NewVector7 v1, NewVector7 v2) {
		double x = v1.x + v2.x;
		double y = v1.y + v2.y;
		return new NewVector7(x, y);
	}


	public static NewVector7 addAll(NewVector7[] all) {
		NewVector7 v = new NewVector7(0, 0);
		for (NewVector7 a : all) {
			v = NewVector7.add(v, a);
		}
		return v;
	}

	public static NewVector7 sub(NewVector7 v1, NewVector7 v2) {
		double x = v1.x - v2.x;
		double y = v1.y - v2.y;
		return new NewVector7(x, y);
	}


	public static NewVector7 mult(NewVector7 v1, double s1) {
		double x = v1.x * s1;
		double y = v1.y * s1;
		return new NewVector7(x, y);
	}

	public static NewVector7 div(NewVector7 v1, double s1) {
		double x = v1.x / s1;
		double y = v1.y / s1;
		return new NewVector7(x, y);
	}

	public static double mag(NewVector7 v1) {
		return Math.sqrt(Math.pow(v1.x, 2) + Math.pow(v1.y, 2));
	}

	public static double distanceBetweenTwoVectors(NewVector7 v1, NewVector7 v2)
	{
		return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
	}

	public static double angleBetweenTwoVectors(NewVector7 v1, NewVector7 v2)
	{
		return Math.acos(v1.dot(v2) / (mag(v1) * mag(v2)));
	}
	public double heading()
	{
		return Math.atan2(y, x);
	}



}
