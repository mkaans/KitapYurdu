package com.kitapyurdu;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.kitapyurdu.Constant.*;


public class PageTest extends BaseTest {

    public static String dataCsvFile;

    @Test
    public void login() throws InterruptedException, FileNotFoundException {

        Scanner sc = new Scanner(new File("src/main/resources/CsvDataFiles/csvFile.csv"));
        dataCsvFile = sc.nextLine();

        new BasePage(driver).start();
        new BasePage(driver).assertMainPage(FIRST_LINK);
        new BasePage(driver).search(dataCsvFile);
        new BasePage(driver).bekle();
        new BasePage(driver).randomClick();
        new BasePage(driver).bekle();
        new BasePage(driver).addToCart();
        new BasePage(driver).bekle();
        new BasePage(driver).assertBack();
        new BasePage(driver).bekle();
        new BasePage(driver).goToCart();
        new BasePage(driver).sayıArttır();
        new BasePage(driver).bekle();
        new BasePage(driver).refreshQuantity();
        new BasePage(driver).bekle();
        new BasePage(driver).isDisplayed();
        new BasePage(driver).bekle();
        new BasePage(driver).deleteProduct();
        new BasePage(driver).bekle();
        new BasePage(driver).assertBracket();


    }

}



