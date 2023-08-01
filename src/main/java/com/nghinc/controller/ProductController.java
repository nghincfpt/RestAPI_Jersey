package com.nghinc.controller;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.nghinc.model.Product;
import com.nghinc.repository.ProductRepository;


@Path("/products")
public class ProductController {
//	debug info  warn, erorr
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private  ProductRepository productRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts(){
		logger.info("Lấy hêt dữ liệu thành công");
		return productRepository.listAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct (Product product) {
		productRepository.addProduct(product);
		logger.info("Thêm sản phẩm thành công");
		String message= " Thêm thành công.";
		return Response.status(Response.Status.CREATED).entity(message).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteByID(@PathParam("id") int id) {
		productRepository.deleteProduct(id);
		logger.info("Xóa sản phẩm thành công");
		String message= "Xóa thành công id :"+id;
		return Response.status(Response.Status.OK).entity(message).build();
		
	}
	
	@GET 
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	  public Product getProductById(@PathParam("id") int id) {
		return productRepository.getProductByID(id);
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(@PathParam("id") int id, Product product) {
		product.setId(id);
		productRepository.updateProduct(product);
		logger.info("Cập nhật sản phẩm thành công");
		String message = "update thành công id :"+id;
		return Response.status(Response.Status.OK).entity(message).build();
	}
	
}
