package storysflower.com.storysflower.dto;

public class ProductCartDTO {
    private int id;
    private String picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductCartDTO{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", messageToRecipient='" + messageToRecipient + '\'' +
                ", price=" + price +
                ", totalMoney=" + totalMoney +
                '}';
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
