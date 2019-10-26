package storysflower.com.storysflower.services;

import storysflower.com.storysflower.dto.ProductDTO;
import storysflower.com.storysflower.dto.ProductDetailDTO;

import java.util.List;

/**
 * @author ntynguyen
 */
public interface ProductService {
    public ProductDetailDTO getProductDetailDTOById(Long id);

    public ProductDTO getProductDTOById(Long productId);

    public List<ProductDTO> getListProductDTOByOccasionId(Long occasionId);

    public List<ProductDTO> getListBestProductDTOByRatting();

    List<ProductDTO> getListBestProductDTOByRattingAndOccasion(Long occasionId);

    List<ProductDTO> getListBestProductDTOBySellerAndOccasion(Long occasionId);

    List<ProductDTO> getAllFlower();
}
