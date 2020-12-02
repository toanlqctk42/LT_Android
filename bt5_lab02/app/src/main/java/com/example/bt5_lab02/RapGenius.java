package com.example.bt5_lab02;

public class RapGenius {
    private String ten;
    private String follow;
    private int Hinh;

    public RapGenius(String ten, String follow, int hinh) {
        this.ten = ten;
        this.follow = follow;
        Hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
