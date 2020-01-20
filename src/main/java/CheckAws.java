import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckAws {

    public void checkOrder(String numberOfOrder) {

        open("https://aws.autodoc.de/search-orders");
        $(byId("login")).shouldBe(visible);
        $(byId("login")).setValue("lion");
        $(byId("password")).setValue("4e24e740");
        $(".btn").click();
        $(byId("form_Filter[orderId]")).setValue(numberOfOrder).pressEnter();
        $(".order_link").shouldBe(visible).click();
        $(byText("Изменить Статус Заказа")).scrollTo();
        String statusOfOrder = $(".btn-link").getText().substring(16);
        System.out.println(statusOfOrder);
        if (statusOfOrder.equals("Testbestellungen")) {
            System.out.println("Order in test-status");
        } else {
            System.out.println("Order isn't in test status. Now it will be change on TEST");
            $(byId("form_OrderStatus[newStatus]")).selectOptionByValue("60");
        }

    }
}
