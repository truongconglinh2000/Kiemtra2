package com.example.test;

public class People {
    private String Ten;
    private String Sdt;
    private int Hinh;

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setGia(String gia) {
        Sdt = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public People(String ten, String sdt, int hinh){
     Ten = ten;
     Sdt = sdt;
     Hinh =hinh;



 }
}
