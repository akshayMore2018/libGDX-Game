package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.entities.EntityCreator;
import com.mygdx.game.world.TileMap;

public class ViewGamePlay extends GameView {
    private EntityCreator creator;
    private TileMap map;

    public ViewGamePlay() {
        map = new TileMap(10, 10);
        creator = new EntityCreator(map);
    }

    @Override
    public void update() {
        creator.update();
    }

    @Override
    public void sketch(PolygonSpriteBatch batch) {

        creator.sketch(batch);
    }

    @Override
    public void dispose() {

    }
}
