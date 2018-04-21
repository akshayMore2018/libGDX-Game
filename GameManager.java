package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;


public class GameManager
{
    public static GameView currentView;

    public GameManager()
    {

    }

    public void update()
    {
        currentView.updateView();
    }

    public void sketch(PolygonSpriteBatch graphics)
    {

        Gdx.gl.glClearColor(0.2f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        currentView.sketch(graphics);
    }

    public void startGame()
    {
        Game.startGame();
    }


    public void dispose()
    {
        currentView.dispose();
    }

}