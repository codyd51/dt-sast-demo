package com.example.androidcheckstest;

import android.content.ContentProvider;

public class VulnerableProvider1 extends ContentProvider {
	public ParcelFileDescriptor openFile (Uri uri, String mode) throws FileNotFoundException {
		File f = new File(DIR, uri.getLastPathSegment());
		return ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
	}
}

