package com.mygdx.game2.physicsAndUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
    private Scanner inFile;
    private List<String> tokenList;
    private String[][] mapIdArray;
    private int xTiles,yTiles;
    public FileParser(String path, int xTiles, int yTiles) {

        tokenList = new ArrayList<String>();
        try {
            inFile = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.xTiles=xTiles;
        this.yTiles=yTiles;
        mapIdArray = new String[xTiles][yTiles];

        String[] temp = {"\n", ","};
        delimiters(temp, 2);
        parseThis();

    }

    private void delimiters(String delArray[], int count) {
        StringBuffer del = new StringBuffer();
        for (int i = 0; i < count - 1; i++) {
            del.append(delArray[i]).append("|");
        }
        del.append(delArray[count - 1]);
        inFile.useDelimiter(del.toString());

    }

    private void parseThis() {
        String token;
        while (inFile.hasNext()) {
            token = inFile.next();
            tokenList.add(token);
        }
        inFile.close();
        int count = 0;
        for (int i = 0; i < xTiles; i++) {
            for (int j = 0; j < yTiles; j++) {
                mapIdArray[j][i] = tokenList.get(count++);
            }
        }

    }


    public String getMapID(int x, int y) {
        return mapIdArray[x][y];
    }

}
