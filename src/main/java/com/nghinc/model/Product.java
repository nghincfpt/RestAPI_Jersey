package com.nghinc.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "gia")
	private double gia;
	@Column(name = "soluong")
	private int soluong;
	@Column(name = "mau")
	private String mau;
	@Column(name = "danhmuc")
	private String danhmuc;
	@Column(name = "mota")
	private String mota;

}
