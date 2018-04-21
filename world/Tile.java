package com.mygdx.game.world;

public class Tile {
    private TERRAIN terrain;
    private int entityID;

    public Tile(TERRAIN terrain) {
        this.terrain = terrain;
    }

    public TERRAIN getTerrain() {
        return terrain;
    }

    public int getEntityID() {
        return entityID;
    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }
}
