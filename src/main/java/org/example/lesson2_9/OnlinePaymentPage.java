package org.example.lesson2_9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class OnlinePaymentPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
    private WebElement blockTitle;

    @FindBy(xpath = "//div[contains(@class, 'payment-systems')]//img")
    private List<WebElement> paymentSystemLogos;

    @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement detailsLink;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class, 'payment-form')]")
    private WebElement paymentForm;

    public OnlinePaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitle() {
        return getElementText(blockTitle);
    }

    public int getPaymentSystemsCount() {
        waitForElementToBeVisible(paymentSystemLogos.get(0));
        return paymentSystemLogos.size();
    }

    public boolean arePaymentSystemsDisplayed() {
        return paymentSystemLogos.stream()
                .allMatch(this::isElementDisplayed);
    }

    public void clickDetailsLink() {
        clickElement(detailsLink);
    }

    public boolean isDetailsLinkDisplayed() {
        return isElementDisplayed(detailsLink);
    }

    public void enterPhoneNumber(String phoneNumber) {
        enterText(phoneNumberInput, phoneNumber);
    }

    public void enterAmount(String amount) {
        enterText(amountInput, amount);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }

    public boolean isPaymentFormDisplayed() {
        return isElementDisplayed(paymentForm);
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public void fillPaymentForm(String phoneNumber, String amount) {
        enterPhoneNumber(phoneNumber);
        enterAmount(amount);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
