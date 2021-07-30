package com.mbb.ib.txnhist.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.mbb.ib.txnhist.constant.FileUtilConstant;

public class FileUtil {

	public void renameToTempFile(File file, String path) {
		String fileName = file.getName() + FileUtilConstant._temp;
		this.writeToFile(file, path, fileName);
		this.deleteFile(file);
	}

	public void moveToArchive(File file, String path) {
		String fileName = this.removeTempFromFileName(file.getName());
		this.writeToFile(file, path, fileName);
		this.deleteFile(file);
	}

	public void moveToError(File file, String path) {
		String fileName = this.removeTempFromFileName(file.getName());
		this.writeToFile(file, path, fileName);
		this.deleteFile(file);
	}

	public void writeToFile(File file, String writeToPath, String fileName) {

		try {
			Scanner text = new Scanner(file);
			FileWriter pen = new FileWriter(writeToPath + fileName);

			while (text.hasNextLine()) {
				pen.write(text.nextLine());
				if (text.hasNextLine())
					pen.write(FileUtilConstant.newline);
			}

			pen.close();
			text.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteFile(File file) {
		file.delete();
	}

	public File[] getAllFile(String path) {
		return new File(path).listFiles();
	}

	public Boolean isTextFile(File file) {
		return file.getName().endsWith(FileUtilConstant._text);
	}

	public void skipFirstRow(Scanner text) {
		text.nextLine();
	}

	public Boolean hasNextRowOfData(Scanner text) {
		return text.hasNextLine();
	}

	public String getRowOfData(Scanner text) {
		return text.nextLine();
	}

	public String[] getArrayOfData(String rowOfData) {
		return rowOfData.split(FileUtilConstant.separator);
	}

	public File getTempFile(File file) {
		return new File(file + FileUtilConstant._temp);
	}

	public String removeTempFromFileName(String fileName) {
		return fileName.substring(0, fileName.length() - 4);
	}
}
