package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.Component;

public class Graphics implements Component
{
    public Texture img;
    public float height,width;

    public Graphics(String path,float W,float H){
        img=new Texture(path);
        width=W;
        height=H;
    }

    @Override
    public String toString()
    {
        return "("+img+")";
    }
}