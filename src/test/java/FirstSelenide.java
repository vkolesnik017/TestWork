import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

//import static com.codeborne.selenide.Condition.*;

@ExtendWith({SoftAssertsExtension.class})
public class FirstSelenide {
    {
        Configuration.holdBrowserOpen = true;
        Configuration.startMaximized=true;
        Configuration.timeout=6000;

    }

    @Test
    public void check() {
        PageClass page = open("https://www.pkwteile.de/", PageClass.class);
        CheckEmail checkletter = page.registrtion("aacgvhjvmbkjhcdvscdfsdfsfv7@gmail.com");
        checkletter.selectLetter("testselenide2@gmail.com");
        SelectCar pageCar =  checkletter.closeWindowEmail();
        pageCar.logOut();
        pageCar.logNewClient("amdaavfkjhghjkdbdbcvkvssafdff017@gmail.com");
        PageCatalog selectCategory =  pageCar.selectCar(4,308,61);
        CheckPrice sortingPrice = selectCategory.selectCategory();
        AddToBasketProduct pageBasket = sortingPrice.checkSortingPrice("//div[@class='price']");
        CheckAws checkOrderAws = new CheckAws();
        checkOrderAws.checkOrder(pageBasket.addToBasket());

    }
}
