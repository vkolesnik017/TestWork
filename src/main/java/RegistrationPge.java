import static com.codeborne.selenide.Selenide.*;
import  static com.codeborne.selenide.Selectors.*;
import static  com.codeborne.selenide.Selenide.*;
import  static com.codeborne.selenide.Condition.*;
import  static com.codeborne.selenide.CollectionCondition.*;


public class RegistrationPge {

    public RegistrstionAdress registrationUser (String email, String password) {
       element("#form_Email").setValue(email);
       element("#form_Password").setValue(password);
       $(".login").click();
       return page(RegistrstionAdress.class);
    }
}
