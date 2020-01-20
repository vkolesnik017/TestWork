import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.*;
import  static com.codeborne.selenide.Selectors.*;
import static  com.codeborne.selenide.Selenide.*;
import  static com.codeborne.selenide.Condition.*;
import  static com.codeborne.selenide.CollectionCondition.*;

public class RegistrstionAdress {

    public void addAllData (String name, String surName, String street, int numOfStreet, int firstCOde, int secondCode, String changeOnTestCode) {
        element(byName("lVorname")).setValue(name);
        element(byName("lName")).setValue(surName);
        element(byName("lStrasse")).setValue(street);
        element(byName("delivery_house")).setValue(Integer.toString(numOfStreet));
        element(byName("lPlz")).setValue(Integer.toString(firstCOde));
        element(byName("lOrt")).setValue(Integer.toString(secondCode));
        element(Selectors.byXpath("//div[@class='jq-selectbox__trigger']")).click();
        element(Selectors.byXpath("//li[contains(text(),'Deutschland')]")).click();
        element(byName("lTelefon")).setValue(changeOnTestCode);
        element(Selectors.byXpath("//div[@class='button-continue address-continue']/a")).click();
    }
}
