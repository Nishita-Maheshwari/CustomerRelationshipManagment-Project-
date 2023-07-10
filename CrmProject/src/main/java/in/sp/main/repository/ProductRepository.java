package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>
{
	Product findByCoursename(String coursename);
}
