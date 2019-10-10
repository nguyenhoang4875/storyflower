package storysflower.com.storysflower.services;

import storysflower.com.storysflower.dto.CartDTO;

import java.util.List;

/**
 * @author ntynguyen
 */
public interface CartService {
    boolean addCard(List<CartDTO> cartDTOList, Long productId, String quantity);

    double calculateTotal(List<CartDTO> cartDTOList);
}
