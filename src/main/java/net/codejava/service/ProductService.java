package net.codejava.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.codejava.config.Helper;
import net.codejava.entity.Product;
import net.codejava.respository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {		
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public void upload(MultipartFile file) throws IOException {
		List<Product> products = Helper.convertExcelToListOfProduct(file.getInputStream());
        this.repo.saveAll(products);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
