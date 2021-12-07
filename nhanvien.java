package tranducvu;

import java.util.Scanner;

public class nhanvien {
  private String hoten;
  private int namsinh;
  private int thamnien;
  private int heso;
  private String luong;
  public nhanvien(){
  }
  public nhanvien(String hoten,int namsinh, int heso, int thamnien){
  this.hoten=hoten;
  this.namsinh=namsinh;
  this.thamnien=thamnien;
  this.heso=heso;
}
public String gethoten() {
	return hoten;
}
public void sethoten (String hoten) {
	this.hoten=hoten;
}
public int getnamsinh() {
	return namsinh;
}
public void setnamsinh (int namsinh) {
	this.namsinh=namsinh;
}
public int getheso() {
	return heso;
}
public void setheso (int heso) {
	this.heso=heso;
}
public int getthamnien() {
	return thamnien;
}
public void setthamnien (int  thamnien) {
	this.thamnien=thamnien;
}
public void inThongtin() {
	Scanner ntr = new Scanner(System.in);
	System.out.print("Nhap ho va ten : ");
    String hoten = ntr.nextLine();
    System.out.print("Nhap nam sinh: \n");
    int namsinh = ntr.nextInt();
    System.out.print("Nhap he so: ");
    double heso = ntr.nextDouble();
    System.out.print("Nhap tham nien: ");   
    int thamnien = ntr.nextInt();
}
	public double luong() {
		return (heso * 150000 + thamnien * 30000);
	}
	public void inThongTin(int i) {
		System.out.println("Họ và tên: " + hoten + ", " + "Năm sinh: "  + namsinh + ", " + "Lương: " + luong());
	}
	
}

