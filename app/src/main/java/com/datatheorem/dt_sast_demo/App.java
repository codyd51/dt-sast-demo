package com.datatheorem.dt_sast_demo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());

		// Let's add some insecure code...
		// 
		// 1. Download a .zip over the network
		ZipInputStream zis = new ZipInputStream(new FileInputStream("./poc.zip"));
		// 2. Iterate each file listed in the .zip archive
		ZipEntry ent = zis.getNextEntry();
		while (ent != null) {
			// 3. Extract the file to the local filesystem
			String fileName = ent.getName();
			FileOutputStream fos = new FileOutputStream(fileName);
			byte[] bytes = new byte[128];
			int size = zis.read(bytes);
			while (size != -1) {
				fos.write(bytes, 0, size);
				size = zis.read(bytes);
			}
			// 4. Iterate to the next file listed in the .zip archive, if any
			ent = zis.getNextEntry();
		}
		// 5. Clean up resources
		zis.closeEntry();
		zis.close();
    }
}
