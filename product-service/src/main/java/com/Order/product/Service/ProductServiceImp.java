package com.Order.product.Service;

import com.Order.product.Entity.Product;
import com.Order.product.Exceptions.ProductNotFoundException;
import com.Order.product.Mapper.ProductMapper;
import com.Order.product.Repository.ProductRepository;
import com.Order.product.codegen.types.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product add(ProductDTO productDTO) {
        Product product = ProductMapper.mapper.productDTOToProduct(productDTO);
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(
                        product
                );
    }

    @Override
    public Product update(ProductDTO productDTO, String id) {
        Product product = helper(id);
        product.setCategory(productDTO.getCategory());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public List<Product> all() {
        return productRepository.findAll();
    }

    public Product helper(String id){
        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }

    @Override
    public Product productById(String id) {
        return helper(id);
    }

    @Override
    public String delete(String id) {
        productRepository.delete(helper(id));
        return "Product was deleted successfully";
    }
}
