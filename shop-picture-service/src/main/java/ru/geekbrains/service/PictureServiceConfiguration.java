package ru.geekbrains.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.repository.PictureRepository;


@Configuration
public class PictureServiceConfiguration {

    @Bean
    @ConditionalOnProperty(name = "picture.storage.type", havingValue = "database")
    public PictureService pictureServiceBlobImpl(PictureRepository pictureRepository) {
        return new PictureServiceBlobImpl(pictureRepository);
    }

    @Bean
    @ConditionalOnProperty(name = "picture.storage.type", havingValue = "${files}")
    public PictureService pictureServiceFileImpl(PictureRepository pictureRepository) {
        return new PictureServiceFileImpl(pictureRepository);
    }

    @Bean
    @ConditionalOnProperty(name = "picture.storage.type", havingValue = "${database}")
    public PictureServiceBlobImpl pictureServiceBlob(PictureRepository pictureRepository) {
        return new PictureServiceBlobImpl(pictureRepository);
    }
}
