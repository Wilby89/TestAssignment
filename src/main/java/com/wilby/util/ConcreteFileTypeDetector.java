package com.wilby.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

/**
 * @author Will
 * Create a custom probe
 *
 */
public class ConcreteFileTypeDetector extends FileTypeDetector{

	@Override
	public String probeContentType(Path path) throws IOException {
		String pathValue = path.toString();
        if (pathValue.lastIndexOf(".") != -1 && pathValue.lastIndexOf(".") != 0) {
        		return pathValue.substring(pathValue.lastIndexOf(".")+1);
        }
        return null;
	}

}
