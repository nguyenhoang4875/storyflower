package storysflower.com.storysflower.repositories;


import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import storysflower.com.storysflower.dto.CartDTO;
import storysflower.com.storysflower.dto.CustomerDTO;
import storysflower.com.storysflower.dto.ReceiptDTO;
import storysflower.com.storysflower.dto.RecipientDTO;
import storysflower.com.storysflower.model.tables.tables.Cart;
import storysflower.com.storysflower.model.tables.tables.Customer;
import storysflower.com.storysflower.model.tables.tables.Recipient;
import storysflower.com.storysflower.utils.DateUtil;
import storysflower.com.storysflower.utils.TimeUtil;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import static storysflower.com.storysflower.model.tables.Tables.BUY_PRODUCT;
import static storysflower.com.storysflower.model.tables.tables.Cart.CART;
import static storysflower.com.storysflower.model.tables.tables.Customer.CUSTOMER;
import static storysflower.com.storysflower.model.tables.tables.Recipient.RECIPIENT;

@Repository
public class CartRepository {
    @Autowired
    private DSLContext dslContext;

    @Transactional
    public boolean updataCartData(ReceiptDTO receiptDTO, List<CartDTO> cartDTOList) {
        CustomerDTO customerDTO = receiptDTO.getCustomerDTO();
        RecipientDTO recipientDTO = receiptDTO.getRecipientDTO();
        insertCustomerData(customerDTO);
        insertRecipientData(recipientDTO);
        insertCartData(customerDTO, recipientDTO, DateUtil.convertFromStringToDaTe(receiptDTO.getDeliveryDate()));
        insertBuyData(cartDTOList, getCartId(getCustomerId(customerDTO.getEmail()), getRecipientId(recipientDTO)));
        return true;
    }

    public int insertCartData(CustomerDTO customerDTO, RecipientDTO recipientDTO, Date deliveryDate){
        return (dslContext.insertInto(CART)
                .set(CART.CUSTOMER_ID, getCustomerId(customerDTO.getEmail()))
                .set(CART.RECIPIENT_ID, getRecipientId(recipientDTO))
                .set(CART.DELIVERY_DATE, deliveryDate)
                .execute());
    }

    public int insertBuyData(List<CartDTO> cartDTOList, Long cartId){
        for(CartDTO cartDTO: cartDTOList){
            dslContext.insertInto(BUY_PRODUCT)
                    .set(BUY_PRODUCT.CART_ID, cartId)
                    .set(BUY_PRODUCT.PRODUCT_ID, cartDTO.getProductDTO().getId())
                    .set(BUY_PRODUCT.QUANTITY, cartDTO.getQuantity())
                    .execute();
        }
        return 1;
    }


    @Transactional
    public int insertCustomerData(CustomerDTO customerDTO){
        return dslContext.insertInto(CUSTOMER)
                .set(CUSTOMER.FULL_NAME, customerDTO.getFullName())
                .set(CUSTOMER.ADDRESS, customerDTO.getAddress())
                .set(CUSTOMER.EMAIL, customerDTO.getEmail())
                .set(CUSTOMER.PHONE_NUMBER, customerDTO.getPhoneNumber())
                .execute();
    }

    @Transactional
    public int insertRecipientData(RecipientDTO recipientDTO){
        return dslContext.insertInto(RECIPIENT)
                .set(RECIPIENT.FULL_NAME, recipientDTO.getFullName())
                .set(RECIPIENT.ADDRESS, recipientDTO.getAddress())
                .set(RECIPIENT.PHONE_NUMBER, recipientDTO.getPhoneNumber())
                .set(RECIPIENT.MESSAGE_TO_RECIPIENT, recipientDTO.getMessageToRecipient())
                .set(RECIPIENT.MESSAGE_TO_US, recipientDTO.getMessageToUs())
                .execute();
    }

    public Long getCustomerId(String email){
        return dslContext.select(CUSTOMER.ID)
                .from(CUSTOMER)
                .where(CUSTOMER.EMAIL.eq(email))
                .fetchOneInto(Long.class);
    }
    public Long getRecipientId(RecipientDTO recipientDTO){
        return dslContext.select(RECIPIENT.ID)
                .from(RECIPIENT)
                .where(RECIPIENT.FULL_NAME.eq(recipientDTO.getFullName()))
                .and(RECIPIENT.ADDRESS.eq(recipientDTO.getAddress()))
                .and(RECIPIENT.PHONE_NUMBER.eq(recipientDTO.getPhoneNumber()))
                .fetchOneInto(Long.class);
    }

    public Long getCartId(Long customerId, Long recipientId){
        return dslContext.select(CART.ID)
                .from(CART)
                .where(CART.CUSTOMER_ID.eq(customerId))
                .and(CART.RECIPIENT_ID.eq(recipientId))
                .fetchOneInto(Long.class);
    }

}
