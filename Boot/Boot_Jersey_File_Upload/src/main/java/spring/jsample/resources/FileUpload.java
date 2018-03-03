package spring.jsample.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

@Component
@Path("/upload")
public class FileUpload {

	private static final String TEMP_PATH = "D:\\temp\\";

	@POST
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadFile(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData,
			@FormDataParam("fileDescription") String fileDescription) {

		try {

			File dirObj = createTempDirectory();
			String fileName = fileMetaData.getFileName();
			Files.copy(fileInputStream, Paths.get(dirObj.getAbsolutePath(), fileName),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("There is an error while uploading file.")
					.build();
		}
		return Response.ok("File with description - " + fileDescription + " - is successfully uploaded.").build();
	}

	private File createTempDirectory() {
		String dirPath = new StringBuilder(TEMP_PATH).append(File.separator).append(System.currentTimeMillis())
				.toString();
		File dirObj = new File(dirPath);
		dirObj.mkdirs();
		return dirObj;
	}
}
