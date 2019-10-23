package storysflower.com.storysflower.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import storysflower.com.storysflower.dto .ImageDTO;
import storysflower.com.storysflower.model.tables.tables.Image;
import storysflower.com.storysflower.model.tables.tables.records.ImageRecord;

import static storysflower.com.storysflower.model.tables.tables.Image.IMAGE;

/**
 * @author ntynguyen
 */
@Component
public class ImageRepository {
    @Autowired
    private DSLContext dslContext;

    public ImageDTO findImageById(long imageId) {
        ImageRecord image = dslContext
                .selectFrom(IMAGE)
                .where(IMAGE.IMAGE_ID.eq(imageId))
                .fetchOne();

        if (image == null) {
            return null;
        }
        return image.into(ImageDTO.class);
    }
}
