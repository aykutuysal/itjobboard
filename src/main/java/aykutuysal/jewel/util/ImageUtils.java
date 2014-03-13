package aykutuysal.jewel.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtils {

	public static String saveImage(CommonsMultipartFile image, String rootPath) {
		
		String imagePath = rootPath + image.getOriginalFilename();
		
		try {
			File file = new File(imagePath);
			file.mkdirs();
			image.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagePath;
	}
}
