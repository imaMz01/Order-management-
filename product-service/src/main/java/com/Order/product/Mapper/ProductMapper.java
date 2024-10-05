package com.Order.product.Mapper;

import com.Order.product.Entity.Product;
import com.Order.product.codegen.types.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
    List<ProductDTO> productToProductDTO(List<Product> product);
    List<Product> productDTOToProduct(List<ProductDTO> productDTO);
}
