package com.omrbranchbrokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_WebPage {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		List<WebElement> linkCount = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links present:" + linkCount.size());

		int brokenLink = 0;

		for (WebElement element : linkCount) {

			String linkName = element.getDomProperty("href");

			URL url = new URL(linkName);
			URLConnection con = url.openConnection();

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				System.out.println("Broken link Names:" + linkName);
				brokenLink++;
			}
		}
		System.out.println("Total Number of Broken links present in the WebPage are:" + brokenLink);
	}

	public void hi7() {
		System.out.println("Hai");

	}

	public void helo8() {
		System.out.println("Helo");

	}

	public void bye9() {
		System.out.println("Tata");

	}

}
