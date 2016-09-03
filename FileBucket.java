package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {

	MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	private Integer id;

	private String ten;
	
	private String diachi;
	
	private int sdt;
	
	private float gia1;
	
	private Float gia2;
	

	private String pr;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
	public float getGia1(){
		return gia1;
	}
	public void setGia1(float gia1){
		this.gia1=gia1;
	}
	
	public Float getGia2() {
		return gia2;
	}
	public void setGia2(Float gia2) {
		this.gia2 = gia2;
	}
	
	public String getPr() {
		return pr;
	}
	public void setPr(String pr) {
		this.pr = pr;
	}
}
