package org.example.lesson2_9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
    private WebElement onlinePaymentTitle;

    @FindBy(xpath = "//div[contains(@class, 'pay__card')]//img")
    private List<WebElement> paymentSystemLogos;

    @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement detailsLink;

    // Локаторы для формы пополнения
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class, 'pay__tab') and contains(text(), 'Услуги связи')]")
    private WebElement communicationServicesTab;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getOnlinePaymentTitle() {
        wait.until(ExpectedConditions.visibilityOf(onlinePaymentTitle));
        return onlinePaymentTitle.getText();
    }

    public int getPaymentSystemLogosCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentSystemLogos));
        return paymentSystemLogos.size();
    }

    public boolean arePaymentSystemLogosDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentSystemLogos));
        return paymentSystemLogos.stream().allMatch(WebElement::isDisplayed);
    }

    public void clickDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        detailsLink.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void selectCommunicationServicesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(communicationServicesTab));
        communicationServicesTab.click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInput));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.elementToBeClickable(amountInput));
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public void fillPaymentForm(String phoneNumber, String amount) {
        selectCommunicationServicesTab();
        enterPhoneNumber(phoneNumber);
        enterAmount(amount);
    }
}
