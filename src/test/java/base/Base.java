package base;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

import utility.Sky_It_School_Listener;
//@Listeners(Sky_It_School_Listener.class)//We can add Listeners class inTestng.xml

public class Base {
	public static Page page;
	public static Browser browser;
	public static Playwright playwright;

	@BeforeSuite
	public static void startUp() {

		System.out.println("......@BeforeSuite..........");
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

		// playwright declaration and creation
		// Playwright playwright;
		playwright = Playwright.create();

		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");

		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)
				.setExecutablePath(Paths.get(chromePath));

		// Browser browser;
		browser = playwright.chromium().launch(launchOptions);

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		page = context.newPage();

	}

	public static String innerText(String locator) {
		String s = page.locator(locator).innerText();
		return s;
	}

	public static void fill(String locator, String value) {
		page.locator(locator).fill(value);
	}

	public static void navigate(String url) {
		page.navigate(url);
	}

	public static void click(String locator) {
		page.locator(locator).click();
	}

	public static void p(String s) {
		System.out.println(s);

	}

	public static void assertion(String xpath, String text) {
		assertThat(page.locator(xpath)).hasText(text);
	}

	public static void browserClose() {
		page.close();
	}

	public static void Selection(String path, String value) {
		page.selectOption(path, value);
	}

	public static void count_Table_Head(String xpath, String xpath2) {// need to ask
		int num = page.locator(xpath).locator(xpath2).count();
		System.out.println("Table head is : " + num);
		click("//select[@name='example_length']");

	}

	public static void arrowdown(String locator) {
		for (int i = 0; i < 2; i++) {
			page.press(locator, "ArrowDown");
		}
	}

	public static int generateNumber() {
		return (int) (Math.random() * 100000);
	}

	public static void generateScreenshot(String filename) {
		ScreenshotOptions ssOptions = new ScreenshotOptions();
		page.screenshot(ssOptions.setPath(Paths.get(filename)));
	}

	// All close
	@AfterSuite
	public static void close_All() {
		System.out.println("......@AfterSuite..........");
		page.close();
		browser.close();
		playwright.close();
	}
}
