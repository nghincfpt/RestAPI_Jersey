package com.nghinc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nghinc.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> listAll(){
		String sql = "SELECT * FROM products";		
		
		return jdbcTemplate.query(sql, (rs,rowNum)  ->{
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setTen(rs.getString("ten"));
			product.setGia(rs.getDouble("gia"));
			product.setSoluong(rs.getInt("soluong"));
			product.setMau(rs.getString("mau"));
			product.setDanhmuc(rs.getString("danhmuc"));
			product.setMota(rs.getString("mota"));
			
			return product;
		});
	}
	
	public  void addProduct(Product product) {
		String sql = "insert into products (id,ten,gia,soluong,mau,danhmuc,mota) VALUES (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,product.getId(),product.getTen(),product.getGia(),product.getSoluong(),product.getMau(),product.getDanhmuc(),product.getMota());
	}
	
	public  void deleteProduct(int id) {
		String sql = "delete from products where id = ?";
		jdbcTemplate.update(sql,id);
	}
	
	public Product getProductByID(int id) {
		String sql = "select * from products where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id},(rs,rowMun)-> {
			
			Product product = new Product();
			
			product.setId(rs.getInt("id"));
			product.setTen(rs.getString("ten"));
			product.setGia(rs.getDouble("gia"));
			product.setSoluong(rs.getInt("soluong"));
			product.setMau(rs.getString("mau"));
			product.setDanhmuc(rs.getString("danhmuc"));
			product.setMota(rs.getString("mota"));

			return product;
		});
	}
	
	
	public void updateProduct(Product product) {
		String sql = "update products set  ten= ?,gia=? , soluong= ? ,mau =?, danhmuc =? ,mota= ? where id = ? ";
		jdbcTemplate.update(sql,product.getTen(),product.getGia(),product.getSoluong(),product.getMau(),product.getDanhmuc(),product.getMota(),product.getId());
	}
}
