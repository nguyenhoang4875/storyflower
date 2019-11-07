package storysflower.com.storysflower.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static storysflower.com.storysflower.model.tables.Tables.BUY_PRODUCT;

@Repository
public class BuyProductRepository {
    @Autowired
    DSLContext dslContext;
    public boolean updateStatusByIdBuyProduct(Long id) {
        return dslContext.update(BUY_PRODUCT)
                .set(BUY_PRODUCT.STATUS, 1)
                .where(BUY_PRODUCT.ID.eq(id))
                .execute() > 0;
    }
}
