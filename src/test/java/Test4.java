import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Test4 {
    {
        ChromeOptions    chrome_options= new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        Configuration.holdBrowserOpen=true;
        Configuration.browserCapabilities=capabilities;
        capabilities.setCapability(ChromeOptions.CAPABILITY,chrome_options);
        Configuration.startMaximized=true;

    }

    @Test
    public void test(){

        String brand = "ALCA MOBIL";
        open("https://aws.autodoc.de/products/search");
        $(byXpath("//input[@id='login']")).shouldBe(visible);
        $(byXpath("//input[@id='login']")).setValue("lion");
        $(byXpath("//input[@id='password']")).setValue("4e24e740");
        $(byXpath("//button[@class='btn btn-default btn-sm pull-right']")).click();
        $(byId("order_products_list")).shouldBe(visible);
        $(byId("form_filterSearch[onStorage]")).selectOptionByValue("no");
        $(byXpath("//div[@id='form_filterSearch_suppliers__chzn']//input")).shouldBe(visible).setValue(brand);
        $(byXpath("//em[contains(text(),'" + brand + "')]")).shouldBe(visible).click();
        $(byId("form_filterSearch[inSuplierStocks]")).selectOptionByValue("yes");
        $(byId("form_submit")).submit();
        $(byXpath("//table[@id='order_products_list']//tr[2]//td[5]")).shouldHave(text(brand));

        List<Integer> id = new ArrayList<>();

        ElementsCollection idFromTable = $$(byXpath("//table[@id='order_products_list']//tr//td[1]"));
        SelenideElement paginator = $(byXpath("//ul[@class='pagination']/li[8]/a"));

     //   SelenideElement lastpage = $(byXpath("//div[@id='contentwrapper']//li[9]//a"));
     //   String lastPage = lastpage.getAttribute("href");
     //   String lastPAGE=lastPage.substring(44);
        int lasTPage = Integer.parseInt($(byXpath("//div[@id='contentwrapper']//li[9]//a")).getAttribute("href").substring(44));

        System.out.println(lasTPage);


        for (int i=0; i<lasTPage;i++) {
            paginator.click();
        }

    /*ChromeOptions    chrome_options= new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();


        open("https://rozetka.com.ua/samsung_galaxy_m30s_4_64gb_black/p74042907/");
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        $(byXpath("//div[@class='rz-banner_wrapper']")).shouldBe(visible);
        chrome_options.addArguments("–disable-infobars");
        chrome_options.addArguments("–enable-automation");
        chrome_options.addArguments("–start-maximized");
        chrome_options.addArguments("--disable-notifications");
*/
      //  System.setProperties();


   /*     open("https://www.autodoc.de/autoteile/bremsschlauche-10135/vw/golf/golf-iv-1j1/8799-1-4-16v");
        $(byXpath("//div[@class='listing-wrap']")).shouldBe(visible);
        String select = Keys.chord(Keys.CONTROL,Keys.RETURN);
         $(byXpath("//div[@class='name']/a")).sendKeys(select);
        Selenide.switchTo().window(1);
        $(byXpath("//div[@class='product-block__price-block']")).shouldBe(visible);
        String price = $(byXpath("//p[@class='product-new-price']")).getText();
        System.out.println(price);
        Selenide.switchTo().window(0);
        Selenide.switchTo().window(1).close();*/

/*
        open("https://www.autodoc.de/autoteile/bremsschlauche-10135/vw/golf/golf-iv-1j1/8799-1-4-16v");
        $(byXpath("//div[@class='js-listing-wrap']")).shouldBe(visible);
        SelenideElement buttonNext = $(byXpath("//span[@class='next']/a"));
        SelenideElement paginator = $(byXpath("//div[@class='pagination']"));
        int page=1;

      //  SelenideElement lastElement  =  $(byXpath("//span[@class='last']/a")).getAttribute("href")
   //     String lastPage=lastElement.getAttribute("href");
   //String lastPages=     $(byXpath("//span[@class='last']/a")).getAttribute("href").substring(92);
   int cout = Integer.parseInt($(byXpath("//span[@class='last']/a")).getAttribute("href").substring(92));
    //    System.out.println(lastPages);

        for (int j=0; j<cout;j++) {
            String title = $(byXpath("//div[@class='name']/a")).getText();
            System.out.println("Page: " + page +" - " + title);
         //   System.out.println(title);
            page++;
            buttonNext.click();
           // cout--;
        }*/
    }
}
