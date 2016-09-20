package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
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
	@NotEmpty(message="Thiếu tên của địa điểm")
	private String ten;
	
	@NotEmpty(message="Thiếu địa chỉ của địa điểm")
	private String diachi;
	
	@NotEmpty(message="Thiếu số điện thoại của địa điểm")
	@Size(min = 7, max = 15, message = "Số điện thoại từ 7 đến 11 số")
	@Pattern(regexp = "[0-9]*",message="Số điện thoại không đúng định dạng")
	private String sdt;
	
	
	@NotEmpty(message="Thiếu giá của địa điểm")
	@Pattern(regexp = "[0-9]*",message="Gía không đúng định dạng")
	private String gia1;
	
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String i) {
		this.sdt = i;
	}
	
	public String getGia1(){
		return gia1;
	}
	public void setGia1(String gia1){
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
