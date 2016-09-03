package com.websystique.springsecurity.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT_PROFILE")
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="ten", nullable=false)
	private String ten;
	
	@NotNull
	@Column(name="diachi", nullable=false)
	private String diachi;
	
	@NotNull
	@Column(name="sdt", nullable=false)
	private int sdt;
	
	@NotNull
	@Column(name="gia1", nullable=false)
	private float gia1;
	
	@Column(name="gia2", nullable=true)
	private Float gia2;
	
	@Column(name="pr", nullable=true)
	private String pr;
	
	@Column(name="hinh", nullable=true)
	private String hinh;
	
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
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", ten=" + ten + ", diachi=" + diachi
				+ ", sdt=" + sdt + "]";
	}
	
}
