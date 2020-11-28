package geekbrains.controller;

import geekbrains.service.PictureService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/picture")
public class PictureController {

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    private PictureService pictureService;

    @Autowired
    public void setPictureService(PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @GetMapping("/{pictureId}")
    public void downloadProductPicture(@PathVariable("pictureId") Integer pictureId, HttpServletResponse response) throws IOException, NotFoundException {
        logger.info("Downloading picture {}", pictureId);

        String contentType = pictureService
                .getPictureContentTypeById(pictureId)
                .orElseThrow(() -> new NotFoundException(String.format("Picture with id=%d does not exist", pictureId)));

        response.setContentType(contentType);
        response.getOutputStream().write(pictureService.getPictureDataById(pictureId).get());

    }
}
