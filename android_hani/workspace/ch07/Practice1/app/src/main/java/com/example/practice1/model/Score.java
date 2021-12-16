package com.example.practice1.model;

import java.io.Serializable;

public class Score implements Serializable {
    private String hak;             // 학번
    private String name;            // 이름
    private String kor, eng, mat;   // 과목

    public Score() {
    }

    public Score(String hak, String name, String kor, String eng, String mat) {
        this.hak = hak;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    @Override
    public String toString() {
        return  "hak='" + hak + '\'' +
                ", name='" + name + '\'' +
                ", kor='" + kor + '\'' +
                ", eng='" + eng + '\'' +
                ", mat='" + mat + '\'';
    }

    public String getHak() {
        return hak;
    }

    public void setHak(String hak) {
        this.hak = hak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKor() {
        return kor;
    }

    public void setKor(String kor) {
        this.kor = kor;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }
}
