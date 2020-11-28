package ru.geekbrains.service;



import ru.geekbrains.model.PictureData;

import java.util.Optional;


public interface PictureService {

    Optional<String> getPictureContentTypeById(int id);

    Optional<byte[]> getPictureDataById(int id);

    PictureData createPictureData(byte[] picture);
}
