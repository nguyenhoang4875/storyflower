package storysflower.com.storysflower.services;

import storysflower.com.storysflower.dto.*;

import java.util.List;

/**
 * @author ntynguyen
 */
public interface CartService {
    boolean addCard(List<CartDTO> cartDTOList, Long productId, String quantity);

    double calculateTotal(List<CartDTO> cartDTOList);

    boolean updateCartData(ReceiptDTO receiptDTO, List<CartDTO> cartDTOList);

    List<CartAdminDTO> findAll();

    int countPagination();

    List<ProductCartDTO> findAllListProductByIdCart(Long idCart);

    boolean updateStatus(Long id);

    int getStatus(Long id);
}
