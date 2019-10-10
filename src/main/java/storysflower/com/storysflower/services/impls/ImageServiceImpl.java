package storysflower.com.storysflower.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import storysflower.com.storysflower.dto.ImageDTO;
import storysflower.com.storysflower.repositories.ImageRepository;
import storysflower.com.storysflower.services.ImageService;

/**
 * @author ntynguyen
 */

@Component
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public ImageDTO findImageById(Long id) {
        return imageRepository.findImageById(id);
    }
}
