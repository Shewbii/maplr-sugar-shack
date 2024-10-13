package fr.shewbii.maplr_sugar_shack.repository.spec;

import fr.shewbii.maplr_sugar_shack.models.entity.Product;
import fr.shewbii.maplr_sugar_shack.models.enums.SyrupTypeEnum;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> isType(SyrupTypeEnum type) {
        return (root, query, builder) -> {
            if (type == null) {
                return null;
            }
            return builder.equal(root.get("type"), type);
        };
    }
}
