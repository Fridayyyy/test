package com.example.guanli.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtil {
    public static void writeText(String path,String content,boolean isAppend){

        FileOutputStream outputStream=null;
        OutputStreamWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            outputStream= new FileOutputStream(path,isAppend);
            writer = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(content);
            bufferedWriter.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            }catch (Exception e){

            }
        }
    }
}
