package com.ANZ.interview;

import java.util.Scanner;

public class DownloadManagerTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter url here : ");
		String url = input.nextLine();
		DownloadInfo information = new DownloadInfo(url);
	}
}
