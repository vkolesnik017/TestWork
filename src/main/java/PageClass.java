import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageClass {

    public CheckEmail registrtion (String email) {
        System.out.println("Registration of new clien ");
        $(byXpath("//span[@class='status ga-click']")).click();
        $(byId("reg_pop")).click();
        $(byId("email")).setValue(email);
        $(byId("Password")).setValue("12345678");
        $(byId("new_pass_confirm")).setValue("12345678");
        $("#register_form > fieldset > div.accept_subscription_checkbox.subscribe_checkbox > label").click();
        $(byXpath("//a[@class='register_submit']")).click();
        $("#login_complete > div.btns > div:nth-child(2) > a").shouldHave(text("Weiter einkaufen")).click();
        $(byId("login_complete")).shouldBe(Condition.disappear);
        return page(CheckEmail.class);


    }
}
