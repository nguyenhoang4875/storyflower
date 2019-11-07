package storysflower.com.storysflower.services;

import storysflower.com.storysflower.dto.CartAdminDTO;
import storysflower.com.storysflower.dto.CartDTO;
import storysflower.com.storysflower.dto.ReceiptDTO;
import storysflower.com.storysflower.dto.CustomerDTO;

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

    CartAdminDTO findCartById(Long id);

}
