package com.ANZ.interview;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Downloader implements Runnable {

	private URL downloadURL;

	private int startByte;

	private int endByte;

	private int threadNum;

	private RandomAccessFile outputFile;

	private InputStream stream;

	public Downloader(URL downloadURL, int startByte, int endByte, int threadNum, RandomAccessFile outputFile) {
		this.downloadURL = downloadURL;
		this.startByte = startByte;
		this.endByte = endByte;
		this.threadNum = threadNum;
		this.outputFile = outputFile;
	}

	@Override
	public void run() {
		download();
	}

	private void download() {
		try {

			System.out.printf("Thread %d is working...\n", threadNum);

			HttpURLConnection httpURLConnection = (HttpURLConnection) downloadURL.openConnection();

			httpURLConnection.setRequestProperty("Range", "bytes=" + startByte + "-" + endByte);

			httpURLConnection.connect();

			outputFile.seek(startByte);

			stream = httpURLConnection.getInputStream();

			while (true) {
				int nextByte = stream.read();
				if (nextByte == -1) {
					break;
				}

				outputFile.write(endByte);

			}

		} catch (IOException ex) {
			Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}