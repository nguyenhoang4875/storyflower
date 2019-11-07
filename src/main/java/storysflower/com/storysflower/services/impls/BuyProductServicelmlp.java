package storysflower.com.storysflower.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.repositories.BuyProductRepository;
import storysflower.com.storysflower.services.BuyProductServicel;

@Component
public class BuyProductServicelmlp implements BuyProductServicel {

    @Autowired
    BuyProductRepository buyProductRepository;
    @Override
    public boolean updateStatusByIdBuyProduct(Long id) {
        return buyProductRepository.updateStatusByIdBuyProduct(id);
    }
}
