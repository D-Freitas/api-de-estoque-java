package br.com.pentagono.estoque.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArquivoUtils {
	
	public static final String DIRETORIO_BASE = "/home/user/dev/media/";

	public String salvarEmDisco(MultipartFile arquivo) {
		String realPath = DIRETORIO_BASE;

		File diretorio = new File(realPath);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		diretorio = null;

		try {
			String path = realPath + arquivo.getOriginalFilename();
			arquivo.transferTo(new File(path));
			return "media/" + arquivo.getOriginalFilename();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
}
