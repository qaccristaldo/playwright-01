package org.sofka.demo.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.util.List;


@UsePlaywright(MainPageTest.CustomOptions.class)
public class MainPageTest {

        public static class CustomOptions implements OptionsFactory{

        @Override
        public Options getOptions() {
            return new Options()
                    .setHeadless(false)
                    .setContextOptions(new Browser.NewContextOptions()
                            .setViewportSize(null))
                    .setLaunchOptions(
                            new BrowserType.LaunchOptions()
                                    .setArgs(List.of("--start-maximized", "--disable-gpu", "--no-sandbox"))
                    );
        }
    }

    @Test
    void searchByKeywordTest(Page page){

        page.navigate("https://tiendaqa.centyc.com.ar/");

        System.out.println(page.title());

        page.locator("//input[@id='s']").fill("casco");
        page.locator("//input[@id='s']/following::button[1]").click();
        int results = page.locator("//article").count();

        System.out.println(results);




    }
}
