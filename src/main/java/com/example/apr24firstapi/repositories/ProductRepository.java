package com.example.apr24firstapi.repositories;

import com.example.apr24firstapi.models.Category;
import com.example.apr24firstapi.models.Product;
import com.example.apr24firstapi.projections.ProductInfo;
import com.example.apr24firstapi.projections.ProductInfo1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(long id);

    List<Product> findByIdIn(List<Long> ids);  //select * from products where id in (ids)

   // List<Product> findAllByCategoryAndDescription(Category category, String description);

    List<Product> findAllByCategory_Name(String name);
    // select * from products p join category c on p.category_id = c.category_id where c.name = {name}

    // HQL -> SQL + OOPs
    @Query("select p.title, p.description, p.id from Product p where p.id = :id")
    Optional<ProductInfo> getByIdCustomHQL(@Param("id") long id);

    //SQL
    @Query(value = "select p.title, p.description, p.id from product p where p.id = :id", nativeQuery = true)
    Optional<Product> getByIdCustomSQL(@Param("id") long id);
}
