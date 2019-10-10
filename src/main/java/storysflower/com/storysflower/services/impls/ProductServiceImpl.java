package storysflower.com.storysflower.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.dto.ProductDTO;
import storysflower.com.storysflower.dto.ProductDetailDTO;
import storysflower.com.storysflower.repositories.ProductRepository;
import storysflower.com.storysflower.services.ProductService;

import java.util.List;

/**
 * @author ntynguyen
 */
@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long id) {
        return productRepository.getProductDetailByProductId(id);
    }

    @Override
    public ProductDTO getProductDTOById(Long productId) {
        return productRepository.getProductDTOById(productId);
    }

    @Override
    public List<ProductDTO> getListProductDTOByOccasionId(Long occasionId) {
        return productRepository.getListProductDTOByOccasionId(occasionId);
    }

    @Override
    public List<ProductDTO> getListBestProductDTOByRatting() {
        return productRepository.getListBestProductDTOByRatting();
    }


}
