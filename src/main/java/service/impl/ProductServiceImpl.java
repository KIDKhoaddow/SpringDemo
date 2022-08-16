package service.impl;

import DAO.IProductRepository;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import service.ICRUDService;

import java.util.Optional;

public class ProductServiceImpl implements ICRUDService<Product> {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateById(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product save(Product product) {
      return   productRepository.save(product);
    }
}
