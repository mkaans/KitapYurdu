package com.kitapyurdu;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Random;


public class BasePage extends Constant {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30, 150);
    }

    public void start() {

        logger.info("Sayfa açılıyor");
        webDriver.get(FIRST_LINK);
    }

    public void assertMainPage(String link) {
        logger.info("Sayfa kontrol ediliyor");
        Assert.assertEquals(FIRST_LINK, webDriver.getCurrentUrl());
    }

    ////--------------------------------------ARAMA--------------------------------
    public void search(String item) {
        logger.info("Ürün aranıyor");
        webDriver.findElement(By.id(SEARCH_ITEM)).clear();
        webDriver.findElement(By.id(SEARCH_ITEM)).sendKeys(item);
        webDriver.findElement(By.id(SEARCH_ITEM)).sendKeys(Keys.ENTER);
    }


    ////-----------------------------BEKLEME----------------------------------
    public void bekle() throws InterruptedException {
        logger.info("Sayfa yüklenmesi bekleniyor");
        Thread.sleep(3000);

    }

    public List<WebElement> listElements() {
        return webDriver.findElements(By.xpath(ELEMENT_LIST));
    }

    ////-------------------RASTGELE TIK----------------------
    public void randomClick() {
        logger.info("Rastgele ürün seçiliyor");
        Random random = new Random();
        listElements().get(random.nextInt(listElements().size())).click();
    }


    ////---------------SEPETE EKLEME---------------------
    public void addToCart() {
        logger.info("Sepete ekleniyor");
        webDriver.findElements(By.id(ADD_TO_CART));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(ADD_TO_CART))).click();
    }

    public void goToCart() {
        logger.info("Sepete gidiliyor");
        webDriver.findElements(By.id(COUNT_PROS));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(COUNT_PROS))).click();
        webDriver.findElements(By.id(GOTO_CARD));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(GOTO_CARD))).click();
    }

    public void sayıArttır() {
        logger.info("Ürün sayısı arttırılıyor");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_MORE_ITEM)));
        webDriver.findElement(By.xpath(ADD_MORE_ITEM)).clear();
        webDriver.findElement(By.xpath(ADD_MORE_ITEM)).sendKeys("2");
    }

    public void refreshQuantity() {
        logger.info("Sayfa yenilendi");
        webDriver.findElement(By.xpath(REFRESH_ICON)).click();

    }

    public void deleteProduct() {
        logger.info("Çıkan ikinci sayfada ürün temizleye basılıyor");
        webDriver.findElements(By.xpath(DELETE_ITEM));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_ITEM))).click();
    }

    public void assertBack() {
        logger.info("Ürün kontrol ediliyor");
        WebElement element = webDriver.findElement(By.id(COUNT_PROS));
        String elText = element.getText();
        System.out.println(elText);
        Assert.assertEquals(COUNT, elText);
        logger.info("ÜRÜNLER KONTROL EDİLDİ");
    }


    public boolean isDisplayed() {
        Boolean display = webDriver.findElement(By.id(CHECK_TITLE)).isDisplayed();
        if (display = true) {
            logger.info("Sepetiniz güncelleniyor");

        } else {
            logger.info("Sepetiniz güncellenemedi");

        }
        return display;

    }

    public void assertBracket() {
        logger.info("Ürün kontrol ediliyor");
        WebElement element = (WebElement) webDriver.findElement(By.id(COUNT_PROS));
        String validationText = element.getText();
        Assert.assertEquals(COUNT2, validationText);
        logger.info("ÜRÜNLER KONTROL EDİLDİ");
    }


}






