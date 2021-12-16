package com.example.practice1.helper;

import com.example.practice1.model.Score;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// 리스트에 저장된 객체를 파일로 저장
public class FileHelper {
    // 싱글톤 패턴 시작
    private static FileHelper instance;

    public static FileHelper getInstance() {
        if(instance == null) instance = new FileHelper();

        return instance;
    }

    private FileHelper() {}
    // 싱글톤 패턴 끝

    // 파일 쓰기
    public boolean write(String filePath, List<Score> list) {
        boolean result = false;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            // list의 총데이터 갯수를 파일에 저장
            oos.writeInt(list.size());
            // list에 저장된 객체를 파일에 저장
            for(int i=0; i<list.size(); i++) {
                oos.writeObject(list.get(i));
                oos.flush();
            }
            result = true;    // 저장 성공
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos != null) oos.close();
                if(fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 파일 읽기
    public List<Score> read(String filePath) {
        List<Score> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            // 총 데이터 갯수 읽기
            int totalSize = ois.readInt();
            // 객체를 읽어서 리스트에 저장
            for(int i=0; i<totalSize; i++) {
                Score score = (Score) ois.readObject();
                list.add(score);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois == null) ois.close();
                if(fis == null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
