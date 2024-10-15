package fr.shewbii.maplr_sugar_shack.service;

import fr.shewbii.maplr_sugar_shack.exception.EntityNotFoundException;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import fr.shewbii.maplr_sugar_shack.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static fr.shewbii.maplr_sugar_shack.repository.spec.ProductSpecification.isType;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(SyrupTypeEnum type) {
        return repository.findAll(isType(type));
    }

    public Product getById(Integer id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException(Product.class.getName()));
    }

    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}
