package com.wingman.clothingshopmanagement.model.image;

import com.wingman.clothingshopmanagement.util.ImageUtil;
import jakarta.persistence.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImageID")
    private Long imageID;

    @Lob
    @Column(name = "Content", columnDefinition = "BLOB")
    private byte[] content;

    public ImageIcon getImage() {
        return new ImageIcon(content);
    }

    public void setImage(ImageIcon image) {
        if (image == null) {
            throw new IllegalArgumentException("Image is null");
        }
        try {
            content = ImageUtil.convertImageToByteArray(image.getImage());
        } catch (IOException ex) {
            throw new RuntimeException("An error occurred while set image", ex);
        }
    }
}
