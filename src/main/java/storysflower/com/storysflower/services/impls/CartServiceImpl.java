package storysflower.com.storysflower.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.dto.CartDTO;
import storysflower.com.storysflower.dto.ReceiptDTO;
import storysflower.com.storysflower.repositories.CartRepository;
import storysflower.com.storysflower.services.CartService;
import storysflower.com.storysflower.services.ProductService;

import java.util.List;

/**
 * @author ntynguyen
 */
@Component
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public boolean addCard(List<CartDTO> cartDTOList, Long productId, String quantity) {
        CartDTO cartDTO = new CartDTO(productService.getProductDTOById(productId), Integer.parseInt(quantity));
        for (CartDTO cartDTO1: cartDTOList){
            if(cartDTO.getProductDTO().getId().equals(cartDTO1.getProductDTO().getId())){
                return false;
            }
        }
        return cartDTOList.add(cartDTO);
    }

    @Override
    public double calculateTotal(List<CartDTO> cartDTOList) {
        return cartDTOList.stream().mapToDouble(t ->(t.getQuantity() * t.getProductDTO().getPrice())).sum();
    }

    @Override
    public boolean updateCartData(ReceiptDTO receiptDTO, List<CartDTO> cartDTOList) {
        return cartRepository.updataCartData(receiptDTO, cartDTOList);
    }
}
