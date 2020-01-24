import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.apache.http.util.Asserts;
//import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

//@ExtendWith({SoftAssertsExtension.class})
public class CheckPrice {

    public AddToBasketProduct checkSortingPrice(String locatorOfPricecs) {
        Configuration.assertionMode = AssertionMode.SOFT;
        ElementsCollection priceList = Selenide.elements(Selectors.byXpath(locatorOfPricecs));
        System.out.println(priceList.size());
        List<Double> priceListDouble = new ArrayList();

        for (int i = 0; i < priceList.size(); ++i) {
            String correctPrice = priceList.get(i).getText().replaceAll("[^0-9,]", "").replace(",", ".");
            priceListDouble.add(Double.parseDouble(correctPrice));
        }

        List<Double> checkPriceList = new ArrayList(priceListDouble);
        Collections.sort(checkPriceList);
        if (priceListDouble.size() == checkPriceList.size()) {
            for (int el = 0; el < priceList.size(); ++el) {
                Asserts.check(priceListDouble.get(el) == checkPriceList.get(el), "Error");

            }
        } else {
            System.out.println("Quantity of prices don't match");
        }
        return page(AddToBasketProduct.class);
    }
}
