package storysflower.com.storysflower.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storysflower.com.storysflower.dto.ImageDTO;
import storysflower.com.storysflower.exceptions.ApiException;
import storysflower.com.storysflower.services.ImageService;
import storysflower.com.storysflower.services.UserService;

import java.util.concurrent.TimeUnit;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author ntynguyen
 */
@RestController
@RequestMapping("api/image")
public class ImageRestController extends BaseRestController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getImageById(@PathVariable("id") long id) {
        ImageDTO imageDTO = imageService.findImageById(id);

        if (imageDTO == null) {
            throw new ApiException(NOT_FOUND, "Image not found.");
        }

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(3600 * 24 * 30, TimeUnit.SECONDS))
                .body(imageDTO.getImage());
    }
}