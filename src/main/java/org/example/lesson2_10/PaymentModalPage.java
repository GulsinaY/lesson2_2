package org.example.lesson2_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PaymentModalPage {

    @FindBy(xpath = "//div[contains(@class, 'modal-content')]")
    private WebElement modalWindow;

    @FindBy(xpath = "//div[contains(@class, 'phone-number')]")
    private WebElement phoneNumberDisplay;

    @FindBy(xpath = "//div[contains(@class, 'amount')]")
    private WebElement amountDisplay;

    @FindBy(xpath = "//button[contains(@class, 'pay-button')]")
    private WebElement payButton;

    @FindBy(xpath = "//input[@placeholder='Номер карты']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@placeholder='Срок действия']")
    private WebElement expiryDateInput;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    private WebElement cvvInput;

    @FindBy(xpath = "//input[@placeholder='Имя владельца']")
    private WebElement cardHolderInput;

    @FindBy(xpath = "//div[contains(@class, 'payment-systems')]//img")
    private List<WebElement> paymentSystemIcons;

    public PaymentModalPage(WebDriver driver) {
        super(driver);
    }

    public boolean isModalDisplayed() {
        return isElementDisplayed(modalWindow);
    }

    public String getDisplayedPhoneNumber() {
        return getElementText(phoneNumberDisplay);
    }

    public String getDisplayedAmount() {
        return getElementText(amountDisplay);
    }

    public String getPayButtonText() {
        return getElementText(payButton);
    }

    public String getCardNumberPlaceholder() {
        return getElementPlaceholder(cardNumberInput);
    }

    public String getExpiryDatePlaceholder() {
        return getElementPlaceholder(expiryDateInput);
    }

    public String getCvvPlaceholder() {
        return getElementPlaceholder(cvvInput);
    }

    public String getCardHolderPlaceholder() {
        return getElementPlaceholder(cardHolderInput);
    }

    public int getPaymentSystemIconsCount() {
        return paymentSystemIcons.size();
    }

    public boolean arePaymentSystemIconsDisplayed() {
        return paymentSystemIcons.stream()
                .allMatch(this::isElementDisplayed);
    }

    public boolean areCardFieldsDisplayed() {
        return isElementDisplayed(cardNumberInput) &&
                isElementDisplayed(expiryDateInput) &&
                isElementDisplayed(cvvInput) &&
                isElementDisplayed(cardHolderInput);
    }

    public String extractAmountFromPayButton() {
        String buttonText = getPayButtonText();
        if (buttonText.matches(".\\d+[.,]\\d+.")) {
            return buttonText.replaceAll(".?(\\d+[.,]\\d+).", "$1");
        }
        return "";
    }
}
