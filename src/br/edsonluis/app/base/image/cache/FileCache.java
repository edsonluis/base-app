package br.edsonluis.app.base.image.cache;

import java.io.File;
import android.content.Context;

public class FileCache {

	private File cacheDir;

	public FileCache(Context context) {
		cacheDir = context.getCacheDir();
		if (!cacheDir.exists()) {
			cacheDir.mkdirs();
		}
	}

	public File getFile(String url) {
		String filename = String.valueOf(url.hashCode());
		return new File(cacheDir, filename);
	}

	public void clear() {
		File[] files = cacheDir.listFiles();
		if (files == null) {
			return;
		}

		for (File f : files) {
			f.delete();
		}
	}
}
