package fr.shewbii.maplr_sugar_shack.repository;

import fr.shewbii.maplr_sugar_shack.models.entity.OrderLine;
import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    void deleteByProduct_Id(Integer productId);

    Optional<OrderLine> findByProduct(Product product);

}
