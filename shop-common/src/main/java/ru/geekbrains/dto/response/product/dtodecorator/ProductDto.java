package ru.geekbrains.dto.response.product.dtodecorator;

import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.dto.BrandDto;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.dto.PictureDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDto {
    public void setId(Integer id);
    public void setName(String name);
    public void setPrice(BigDecimal price);
    public void setCategory(CategoryDto category) ;
    public void setBrand(BrandDto brand);
    public void setPictures(List<PictureDto> pictures);
    public void setNewPictures(MultipartFile[] newPictures);
    public Integer getId();
    public String getName();
    public BigDecimal getPrice();
    public CategoryDto getCategory();
    public BrandDto getBrand();
    public List<PictureDto> getPictures();
    public MultipartFile[] getNewPictures();
}
