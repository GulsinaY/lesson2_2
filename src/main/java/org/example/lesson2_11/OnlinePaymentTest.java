package org.example.lesson2_11;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.OnlinePaymentPage;
import pages.PaymentModalPage;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Проверка функциональности онлайн платежей")
@Feature("Блок 'Онлайн пополнение без комиссии'")
@Story("Тесты для сайта mts.by")
public class OnlinePaymentTest extends BaseTest {

    @Test
    @DisplayName("Проверка надписей в полях для всех вариантов оплаты")
    @Description("Этот тест проверяет корректность placeholder'ов в полях ввода для всех вариантов оплаты: услуги связи, домашний интернет, рассрочка, задолженность")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Тестировщик Автоматизатор")
    public void testPlaceholdersForAllPaymentOptions() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        Allure.step("Проверка полей для 'Услуги связи'", () -> {
            assertEquals("Номер телефона", paymentPage.getPhoneNumberPlaceholder(),
                    "Placeholder поля номера телефона не соответствует ожидаемому");
            assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                    "Placeholder поля суммы не соответствует ожидаемому");
            takeScreenshot("Услуги связи - поля ввода");
        });

        Allure.step("Проверка полей для 'Домашний интернет'", () -> {
            paymentPage.selectInternetTab();
            assertEquals("Номер договора", paymentPage.getContractNumberPlaceholder(),
                    "Placeholder поля номера договора не соответствует ожидаемому");
            assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                    "Placeholder поля суммы не соответствует ожидаемому");
            takeScreenshot("Домашний интернет - поля ввода");
        });

        Allure.step("Проверка полей для 'Рассрочка'", () -> {
            paymentPage.selectInstallmentTab();
            assertEquals("Номер счёта", paymentPage.getAccountNumberPlaceholder(),
                    "Placeholder поля номера счёта не соответствует ожидаемому");
            assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                    "Placeholder поля суммы не соответствует ожидаемому");
            takeScreenshot("Рассрочка - поля ввода");
        });

        Allure.step("Проверка полей для 'Задолженность'", () -> {
            paymentPage.selectDebtTab();
            assertEquals("Номер счёта", paymentPage.getAccountNumberPlaceholder(),
                    "Placeholder поля номера счёта не соответствует ожидаемому");
            assertEquals("Сумма", paymentPage.getAmountPlaceholder(),
                    "Placeholder поля суммы не соответствует ожидаемому");
            takeScreenshot("Задолженность - поля ввода");
        });
    }

    @Test
    @DisplayName("Комплексная проверка оплаты услуг связи с проверкой модального окна")
    @Description("Полная проверка процесса оплаты услуг связи: заполнение формы, переход в модальное окно, проверка данных и полей карты")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Тестировщик Автоматизатор")
    public void testCommunicationServicesPaymentWithModalVerification() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);
        PaymentModalPage modalPage = new PaymentModalPage(driver);

        // Пререквизиты из предыдущей темы
        String testPhoneNumber = "297777777";
        String testAmount = "5";

        Allure.step("Заполнение формы для услуг связи", () -> {
            paymentPage.selectServicesTab();
            paymentPage.fillPaymentForm(testPhoneNumber, testAmount);
            takeScreenshot("Форма заполнена данными");
        });

        Allure.step("Проверка активности кнопки 'Продолжить'", () -> {
            assertTrue(paymentPage.isContinueButtonEnabled(),
                    "Кнопка 'Продолжить' не активна при валидных данных");
        });

        Allure.step("Нажатие кнопки 'Продолжить'", () -> {
            paymentPage.clickContinueButton();
            takeScreenshot("Модальное окно после нажатия кнопки");
        });

        Allure.step("Проверка отображения модального окна оплаты", () -> {
            assertTrue(modalPage.isModalDisplayed(),
                    "Модальное окно оплаты не отображается");
        });

        Allure.step("Проверка корректности отображения номера телефона", () -> {
            String displayedPhone = modalPage.getDisplayedPhoneNumber();
            assertTrue(displayedPhone.contains(testPhoneNumber) ||
                            displayedPhone.contains("29 777-77-77") ||
                            displayedPhone.contains("+375297777777"),
                    "Номер телефона в модальном окне отображается некорректно");
            takeScreenshot("Номер телефона в модальном окне");
        });

        Allure.step("Проверка корректности отображения суммы", () -> {
            String displayedAmount = modalPage.getDisplayedAmount();
            assertTrue(displayedAmount.contains(testAmount),
                    "Сумма в модальном окне отображается некорректно");
        });

        Allure.step("Проверка суммы на кнопке оплаты", () -> {
            String payButtonText = modalPage.getPayButtonText();
            String extractedAmount = modalPage.extractAmountFromPayButton();
            assertTrue(payButtonText.contains(testAmount) ||
                            extractedAmount.equals(testAmount) ||
                            extractedAmount.equals(testAmount + ".00"),
                    "Сумма на кнопке оплаты отображается некорректно");
            takeScreenshot("Кнопка оплаты с суммой");
        });

        Allure.step("Проверка надписей в полях для ввода реквизитов карты", () -> {
            assertEquals("Номер карты", modalPage.getCardNumberPlaceholder(),
                    "Placeholder поля номера карты не соответствует ожидаемому");
            assertEquals("Срок действия", modalPage.getExpiryDatePlaceholder(),
                    "Placeholder поля срока действия не соответствует ожидаемому");
            assertEquals("CVV", modalPage.getCvvPlaceholder(),
                    "Placeholder поля CVV не соответствует ожидаемому");
            assertEquals("Имя владельца", modalPage.getCardHolderPlaceholder(),
                    "Placeholder поля имени владельца не соответствует ожидаемому");
            takeScreenshot("Поля для реквизитов карты");
        });

        Allure.step("Проверка отображения полей для карты", () -> {
            assertTrue(modalPage.areCardFieldsDisplayed(),
                    "Не все поля для ввода реквизитов карты отображаются");
        });

        Allure.step("Проверка наличия иконок платёжных систем", () -> {
            assertTrue(modalPage.arePaymentSystemIconsDisplayed(),
                    "Иконки платёжных систем не отображаются");

            int iconsCount = modalPage.getPaymentSystemIconsCount();
            assertTrue(iconsCount > 0,
                    "Не найдено иконок платёжных систем в модальном окне");
            takeScreenshot("Иконки платежных систем");

            Allure.addAttachment("Количество иконок платежных систем",
                    "В модальном окне найдено " + iconsCount + " иконок платежных систем");
        });
    }

    @Test
    @DisplayName("Полная проверка блока онлайн пополнения")
    @Description("Базовые проверки основного блока онлайн пополнения: название, логотипы, ссылки")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Тестировщик Автоматизатор")
    public void testCompleteOnlinePaymentBlock() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        Allure.step("Проверка названия блока", () -> {
            assertEquals("Онлайн пополнение без комиссии", paymentPage.getBlockTitle());
        });

        Allure.step("Проверка логотипов платежных систем", () -> {
            assertTrue(paymentPage.arePaymentSystemsDisplayed());
            assertTrue(paymentPage.getPaymentSystemsCount() >= 3);
            takeScreenshot("Логотипы платежных систем");

            Allure.addAttachment("Информация о логотипах",
                    "В блоке найдено " + paymentPage.getPaymentSystemsCount() + " логотипов платежных систем");
        });

        Allure.step("Проверка ссылки 'Подробнее о сервисе'", () -> {
            assertTrue(paymentPage.isDetailsLinkDisplayed());
        });

        Allure.step("Проверка отображения формы", () -> {
            assertTrue(paymentPage.isPaymentFormDisplayed());
            takeScreenshot("Общий вид блока онлайн пополнения");
        });

        Allure.addAttachment("Результат проверки",
                "Все базовые проверки блока 'Онлайн пополнение без комиссии' пройдены успешно");
    }

    // Вспомогательный метод для создания скриншотов
    private void takeScreenshot(String name) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshot), "png");
        } catch (Exception e) {
            System.out.println("Не удалось сделать скриншот: " + e.getMessage());
        }
    }
}
