package com.example.a3_listadapterexam.model;
// javabeans : 여러개 변수를 묶어서 관리하는 클래스
public class Job {
    private String title;
    private String description;
    private int image;
    // 생성자 추가
    // 오-마 => Generate 선택 => Constructor 선택
    public Job() {
    }

    public Job(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    // Getter / Setter 추가
    // 오-마 => Generate 선택 => Getter And Setter 선택
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
