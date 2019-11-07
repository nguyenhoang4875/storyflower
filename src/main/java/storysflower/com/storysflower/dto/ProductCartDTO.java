package storysflower.com.storysflower.dto;

public class ProductCartDTO {
    private String productName;
    private Integer quantity;
    private String messageToRecipient;
    private Double price;
    private double totalMoney;

    public ProductCartDTO(String productName,  String messageToRecipient, Double price, Integer quantity) {
        this.productName = productName;
        this.quantity = quantity;
        this.messageToRecipient = messageToRecipient;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMessageToRecipient() {
        return messageToRecipient;
    }

    public void setMessageToRecipient(String messageToRecipient) {
        this.messageToRecipient = messageToRecipient;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
