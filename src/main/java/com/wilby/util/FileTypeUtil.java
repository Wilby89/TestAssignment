package com.wilby.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

/**
 * 
 * @author Will
 * Attempt to discover the file contentType, if FileTypeDetector doesn't find it fall back to default Files.probeContentType
 * @
 */
public class FileTypeUtil {
	
	public static String probeContentType(Path path) throws IOException {
	    		
		FileTypeDetector fileTypeDetector = new ConcreteFileTypeDetector();
	    String contentType = fileTypeDetector.probeContentType(path);
	    if (contentType != null) {
	    		return contentType;
	    }
	    return Files.probeContentType(path);
	}
}