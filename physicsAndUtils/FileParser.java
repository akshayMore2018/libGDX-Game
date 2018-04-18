package com.mygdx.game.physicsAndUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileParser {
    String filePath;
    Scanner inFile;
    String token="";
    List<String> tokenList;
    public FileParser(String path){
        filePath=path;
        tokenList=new ArrayList<String>();
        try {
            inFile=new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void delimiters(String delArray[],int count){
        String del="";
        for(int i=0;i<count-1;i++) {
            del += delArray[i] + "|";
        }
        del=del+delArray[count-1];
        inFile.useDelimiter(del);
    }
    public void parseThis(){
        while(inFile.hasNext()){
            token=inFile.next();
            tokenList.add(token);
        }
        inFile.close();
    }

    public void display(){
        for(int i=0;i<tokenList.size();i++)
        System.out.println(tokenList.get(i));
    }

}
