package storysflower.com.storysflower.dto;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

public class CartAdminDTO {
    private Long id;
    private String full_name;
    private  String product_name;
    private int status;
    private Date delivery_date;
    private  String message_to_us;

    public CartAdminDTO() {
    }

    public CartAdminDTO(Long id, String full_name, String product_name, int status, Date delivery_date, String message_to_us) {
        this.id = id;
        this.full_name = full_name;
        this.product_name = product_name;
        this.status = status;
        this.delivery_date = delivery_date;
        this.message_to_us = message_to_us;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getMessage_to_us() {
        return message_to_us;
    }

    public void setMessage_to_us(String message_to_us) {
        this.message_to_us = message_to_us;
    }
}
