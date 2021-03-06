package files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMngment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Copy one file to diferent folder or diferent file in the same folder, using
	 * IO API like Before JDK7.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static void copyFile(String from, String to) {

		File fileFrom = new File(from);
		File fileTo = new File(to);
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(fileFrom));
			OutputStream out = new BufferedOutputStream(new FileOutputStream(fileTo));

			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {
				
				// it's possible to append in a StringBuffer here
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * NIO.2 API (JDK7) increase file copying performance since the NIO.2 utilizes
	 * lower-level system entry points.
	 * 
	 * @param from
	 * @param to
	 */
	public static void copyFileFast(String from, String to) {
		try {
			File original = new File(from);
			Path copied = Paths.get(to);
			Path originalPath = original.toPath();
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Move a file with JDK 6 api.
	 * 
	 * @param from
	 * @param to
	 * @throws FileSystemException
	 */
	public static void moveFile(String from, String to) throws FileSystemException {
		File fileToMove = new File(from);
		boolean isMoved = fileToMove.renameTo(new File(to));
		if (!isMoved) {
			throw new FileSystemException(from);
		}
	}

	/**
	 * Move file with using NIO and JDK 7.
	 * 
	 * @param from
	 * @param to
	 * @throws IOException 
	 */
	public static void moveFileFast(String from, String to) throws IOException {
		
		Path fileToMovePath = Files.createFile(Paths.get(from));
		Path targetPath = Paths.get(to);

		Files.move(fileToMovePath, targetPath.resolve(fileToMovePath.getFileName()));
	}

}
