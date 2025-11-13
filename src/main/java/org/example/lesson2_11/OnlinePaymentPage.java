package org.example.lesson2_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlinePaymentPage {

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
    private WebElement blockTitle;

    @FindBy(xpath = "//div[contains(@class, 'payment-systems')]//img")
    private List<WebElement> paymentSystemLogos;

    @FindBy(xpath = "//a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement detailsLink;

    @FindBy(xpath = "//div[contains(@class, 'payment-tabs')]//button[contains(text(), 'Услуги связи')]")
    private WebElement servicesTab;

    @FindBy(xpath = "//div[contains(@class, 'payment-tabs')]//button[contains(text(), 'Домашний интернет')]")
    private WebElement internetTab;

    @FindBy(xpath = "//div[contains(@class, 'payment-tabs')]//button[contains(text(), 'Рассрочка')]")
    private WebElement installmentTab;

    @FindBy(xpath = "//div[contains(@class, 'payment-tabs')]//button[contains(text(), 'Задолженность')]")
    private WebElement debtTab;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@placeholder='Номер договора']")
    private WebElement contractNumberInput;

    @FindBy(xpath = "//input[@placeholder='Номер счёта']")
    private WebElement accountNumberInput;

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

    public void selectServicesTab() {
        clickElement(servicesTab);
    }

    public void selectInternetTab() {
        clickElement(internetTab);
    }

    public void selectInstallmentTab() {
        clickElement(installmentTab);
    }

    public void selectDebtTab() {
        clickElement(debtTab);
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

    public String getPhoneNumberPlaceholder() {
        return getElementPlaceholder(phoneNumberInput);
    }

    public String getAmountPlaceholder() {
        return getElementPlaceholder(amountInput);
    }

    public String getContractNumberPlaceholder() {
        return getElementPlaceholder(contractNumberInput);
    }

    public String getAccountNumberPlaceholder() {
        return getElementPlaceholder(accountNumberInput);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getActiveTabText() {
        if (servicesTab.getAttribute("class").contains("active")) {
            return "Услуги связи";
        } else if (internetTab.getAttribute("class").contains("active")) {
            return "Домашний интернет";
        } else if (installmentTab.getAttribute("class").contains("active")) {
            return "Рассрочка";
        } else if (debtTab.getAttribute("class").contains("active")) {
            return "Задолженность";
        }
        return "Неизвестный таб";
    }
}
