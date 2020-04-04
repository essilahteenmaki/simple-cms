package lopputyo.sovellus.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lopputyo.sovellus.domain.File;
import lopputyo.sovellus.domain.FileRepository;

@Controller
public class FileController {
	
    @Value("${upload.path}")
    private String uploadFolder;
	
	@Autowired
	private FileRepository frepository;
	
	//poista tiedosto
	@RequestMapping(value="/deleteFile/{id}")
	public String deleteFile(@PathVariable ("id") Long fileid, Model model) {
		frepository.deleteById(fileid);
		return "redirect:../files";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/upload")
	public String file() {
		return "upload";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/load")
	public String uploadFolder(@RequestParam("tiedosto") MultipartFile tiedosto, Model model) {
		
        if (tiedosto.isEmpty()) {
        	model.addAttribute("viesti", "Valitse tiedosto");
            return "upload";
        }
        
        if (!tiedosto.getContentType().equals("image/jpeg")) {
        	model.addAttribute("viesti", "Valitse .jpg kuvatiedosto");
            return "upload";
        }

		try {
			File file = new File(tiedosto.getOriginalFilename(), tiedosto.getContentType(), tiedosto.getBytes());
			frepository.save(file);
//			model.addAttribute("viesti", "Tiedosto" +tiedosto.getOriginalFilename() + " ladattu");
			return "redirect:files";
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "upload";
		
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/files")
	public String tiedostot(Model model) {
		model.addAttribute("tiedostot", frepository.findAll());
		return "files";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<File> fileOptional = frepository.findById(id);
		
		if(fileOptional.isPresent()) {
			File file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.body(file.getFile());
			
		}
		
		return ResponseEntity.status(404).body(null);
	}
	
}
