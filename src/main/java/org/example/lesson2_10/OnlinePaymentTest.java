package org.example.lesson2_10;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OnlinePaymentPage;
import pages.PaymentModalPage;
import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentTest {

    @Test
    @DisplayName("Проверка надписей в полях для всех вариантов оплаты")
    public void testPlaceholdersForAllPaymentOptions() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        assertEquals("Номер телефона", paymentPage.getPhoneNumberPlaceholder(),
                "Placeholder поля номера телефона не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                "Placeholder поля суммы не соответствует ожидаемому");

        paymentPage.selectInternetTab();
        assertEquals("Номер договора", paymentPage.getContractNumberPlaceholder(),
                "Placeholder поля номера договора не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                "Placeholder поля суммы не соответствует ожидаемому");

        paymentPage.selectInstallmentTab();
        assertEquals("Номер счёта", paymentPage.getAccountNumberPlaceholder(),
                "Placeholder поля номера счёта не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                "Placeholder поля суммы не соответствует ожидаемому");

        paymentPage.selectDebtTab();
        assertEquals("Номер счёта", paymentPage.getAccountNumberPlaceholder(),
                "Placeholder поля номера счёта не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                "Placeholder поля суммы не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Комплексная проверка оплаты услуг связи с проверкой модального окна")
    public void testCommunicationServicesPaymentWithModalVerification() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);
        PaymentModalPage modalPage = new PaymentModalPage(driver);

        String testPhoneNumber = "297777777";
        String testAmount = "5";

        paymentPage.selectServicesTab();
        paymentPage.fillPaymentForm(testPhoneNumber, testAmount);

        assertTrue(paymentPage.isContinueButtonEnabled(),
                "Кнопка 'Продолжить' не активна при валидных данных");
        paymentPage.clickContinueButton();

        assertTrue(modalPage.isModalDisplayed(),
                "Модальное окно оплаты не отображается");

        String displayedPhone = modalPage.getDisplayedPhoneNumber();
        assertTrue(displayedPhone.contains(testPhoneNumber) ||
                        displayedPhone.contains("29 777-77-77") ||
                        displayedPhone.contains("+375297777777"),
                "Номер телефона в модальном окне отображается некорректно. Ожидалось: " +
                        testPhoneNumber + ", получено: " + displayedPhone);

        String displayedAmount = modalPage.getDisplayedAmount();
        assertTrue(displayedAmount.contains(testAmount),
                "Сумма в модальном окне отображается некорректно. Ожидалось: " +
                        testAmount + ", получено: " + displayedAmount);

        String payButtonText = modalPage.getPayButtonText();
        String extractedAmount = modalPage.extractAmountFromPayButton();
        assertTrue(payButtonText.contains(testAmount) ||
                        extractedAmount.equals(testAmount) ||
                        extractedAmount.equals(testAmount + ".00"),
                "Сумма на кнопке оплаты отображается некорректно. Текст кнопки: " + payButtonText);

        assertEquals("Номер карты", modalPage.getCardNumberPlaceholder(),
                "Placeholder поля номера карты не соответствует ожидаемому");
        assertEquals("Срок действия", modalPage.getExpiryDatePlaceholder(),
                "Placeholder поля срока действия не соответствует ожидаемому");
        assertEquals("CVV", modalPage.getCvvPlaceholder(),
                "Placeholder поля CVV не соответствует ожидаемому");
        assertEquals("Имя владельца", modalPage.getCardHolderPlaceholder(),
                "Placeholder поля имени владельца не соответствует ожидаемому");

        assertTrue(modalPage.areCardFieldsDisplayed(),
                "Не все поля для ввода реквизитов карты отображаются");

        assertTrue(modalPage.arePaymentSystemIconsDisplayed(),
                "Иконки платёжных систем не отображаются");

        int iconsCount = modalPage.getPaymentSystemIconsCount();
        assertTrue(iconsCount > 0,
                "Не найдено иконок платёжных систем в модальном окне");

        System.out.println("Найдено иконок платежных систем в модальном окне: " + iconsCount);
    }

    @Test
    @DisplayName("Полная проверка блока онлайн пополнения")
    public void testCompleteOnlinePaymentBlock() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        assertEquals("Онлайн пополнение без комиссии", paymentPage.getBlockTitle());

        assertTrue(paymentPage.arePaymentSystemsDisplayed());
        assertTrue(paymentPage.getPaymentSystemsCount() >= 3);

        assertTrue(paymentPage.isDetailsLinkDisplayed());

        assertTrue(paymentPage.isPaymentFormDisplayed());

        System.out.println("Все базовые проверки блока 'Онлайн пополнение без комиссии' пройдены успешно");
    }
}
