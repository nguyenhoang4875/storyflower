package storysflower.com.storysflower.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storysflower.com.storysflower.dto.ProductRevenueDTO;

import static storysflower.com.storysflower.model.tables.tables.Cart.CART;
import static storysflower.com.storysflower.model.tables.Tables.BUY_PRODUCT;
import static storysflower.com.storysflower.model.tables.Tables.PRODUCT;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;

@Repository
public class RevenueRepository {
    @Autowired
    private DSLContext dslContext;
    public  List<ProductRevenueDTO> findAllProductRevenue(){
        return dslContext.select(BUY_PRODUCT.CART_ID.as("id"), PRODUCT.PRODUCT_NAME.as("name"), CART.BUY_DATE.as("date"), BUY_PRODUCT.QUANTITY.as("quatity"), PRODUCT.PRICE)
                .from(CART)
                .join(BUY_PRODUCT).on(CART.ID.eq(BUY_PRODUCT.CART_ID))
                .join(PRODUCT).on(PRODUCT.ID.eq(BUY_PRODUCT.PRODUCT_ID))
                .fetchInto(ProductRevenueDTO.class);
    }
}
