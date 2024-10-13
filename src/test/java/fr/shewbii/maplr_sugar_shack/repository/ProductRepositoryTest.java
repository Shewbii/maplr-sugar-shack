package fr.shewbii.maplr_sugar_shack.repository;

import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static fr.shewbii.maplr_sugar_shack.repository.spec.ProductSpecification.isType;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private final Product PRODUCT_1 = new Product(1, "Product 1", "Desc", "img1", 24.25, 24, SyrupTypeEnum.AMBER);
    private final Product PRODUCT_2 = new Product(2, "Product 2", "Desc", "img2", 24.25, 24, SyrupTypeEnum.CLEAR);
    private final Product PRODUCT_3 = new Product(3, "Product 3", "Desc", "img3", 24.25, 24, SyrupTypeEnum.DARK);
    private final Product PRODUCT_4 = new Product(4, "Product 4", "Desc", "img4", 24.25, 24, SyrupTypeEnum.AMBER);

    @BeforeEach
    public void init() {
        productRepository.save(PRODUCT_1);
        productRepository.save(PRODUCT_2);
        productRepository.save(PRODUCT_3);
        productRepository.save(PRODUCT_4);
    }

    @Test
    public void findAllWithoutType() {
        List<Product> products = productRepository.findAll(isType(null));
        assertThat(products).hasSize(4);
    }

    @Test
    public void findAllDark() {
        List<Product> products = productRepository.findAll(isType(SyrupTypeEnum.DARK));
        assertThat(products).hasSize(1);
    }
}
