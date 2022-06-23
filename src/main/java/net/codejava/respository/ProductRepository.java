package net.codejava.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.codejava.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
