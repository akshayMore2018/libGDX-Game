package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.entities.EntityCreator;
import com.mygdx.game.world.TileMap;

public class ViewGamePlay extends GameView {
    private EntityCreator creator;
    private TileMap map;
    private Texture tileImg;

    public ViewGamePlay() {
        tileImg = new Texture(Gdx.files.internal("towerDefense_tile024.png"));
        map = new TileMap(10, 10);
        creator = new EntityCreator(map);
    }

    @Override
    public void update() {
        creator.update();
    }

    @Override
    public void sketch(PolygonSpriteBatch batch) {
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                batch.draw(tileImg, i * Settings.SCALED_TILE_SIZE, j * Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
            }
        }
        creator.sketch(batch);
    }

    @Override
    public void dispose() {

    }
}