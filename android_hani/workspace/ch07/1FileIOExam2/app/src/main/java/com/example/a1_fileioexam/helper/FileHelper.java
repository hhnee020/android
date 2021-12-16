package com.example.a1_fileioexam.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

// 파일에 문자열 출력 및 읽어오기
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
    // => 문자열을 byte 배열(스트림)로 변환후, 파일에 저장
    public boolean writeString(String filePath, String content, String encType) {
        boolean result = false;
        byte[] data = null;

        // 문자열을 byte 배열로 변환
        try {
            data = content.getBytes(encType);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 파일에 저장
        OutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            out.write(data);
            result = true;  // 파일 저장 성공
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 파일 읽기
    // => 파일의 내용을 byte 배열에 저장한 후, 문자열로 변환
    public String readString(String filePath, String encType) {
        String content = null;
        byte [] data = null;

        // 파일읽기
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            // 파일의 크기만큼 byte 배열 만들기
            // in.available() : 파일의 크기를 읽어오는 함수
            data = new byte[in.available()];
            // 파일내용 저장
            in.read(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 문자열로 변환
        try {
            content = new String(data, encType);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return content;
    }
}







