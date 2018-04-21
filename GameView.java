package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

public abstract class GameView
{

    public final void updateView()
    {
        update();
    }

    public abstract void update();

    public abstract void sketch(PolygonSpriteBatch batch);

    public abstract void dispose();
}