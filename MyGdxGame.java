package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

    private GameManager gm;
    private PolygonSpriteBatch polygonSpriteBatch;

    @Override
    public void create() {
        polygonSpriteBatch = new PolygonSpriteBatch();
        gm = new GameManager();
        gm.startGame();

    }

    @Override
    public void render() {
        update();
        sketch();

    }

    private void update() {
        gm.update();
    }

    private void sketch() {
        polygonSpriteBatch.begin();
        gm.sketch(polygonSpriteBatch);
        polygonSpriteBatch.end();


    }

    @Override
    public void dispose() {
        polygonSpriteBatch.dispose();
        gm.dispose();
    }

}