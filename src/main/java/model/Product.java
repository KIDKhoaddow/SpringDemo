package model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


@Entity
@Table
public class Product implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProduct;
    private String describeProduct;
    private String pictureProduct;
    @Transient
    private MultipartFile image;

    public Product() {
    }

    public Product(Long id, String nameProduct, String describeProduct, String pictureProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.describeProduct = describeProduct;
        this.pictureProduct = pictureProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public String getPictureProduct() {
        return pictureProduct;
    }

    public void setPictureProduct(String pictureProduct) {
        this.pictureProduct = pictureProduct;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
