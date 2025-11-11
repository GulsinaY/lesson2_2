package org.example.lesson2_9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class OnlinePaymentTest {

    @Test
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        String actualTitle = paymentPage.getBlockTitle();
        String expectedTitle = "Онлайн пополнение без комиссии";

        assertEquals(expectedTitle, actualTitle,
                "Название блока не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemsLogos() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        assertTrue(paymentPage.arePaymentSystemsDisplayed(),
                "Не все логотипы платёжных систем отображаются");

        int logosCount = paymentPage.getPaymentSystemsCount();
        assertTrue(logosCount > 0,
                "Логотипы платёжных систем не найдены");

        System.out.println("Найдено логотипов платежных систем: " + logosCount);
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testDetailsLink() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        assertTrue(paymentPage.isDetailsLinkDisplayed(),
                "Ссылка 'Подробнее о сервисе' не отображается");

        String originalUrl = paymentPage.getCurrentUrl();

        paymentPage.clickDetailsLink();

        String newUrl = paymentPage.getCurrentUrl();
        assertNotEquals(originalUrl, newUrl,
                "URL не изменился после клика по ссылке");

        assertTrue(newUrl.contains("help")  newUrl.contains("service")  newUrl.contains("detail"),
                "Новый URL не соответствует ожидаемому формату для страницы с подробной информацией");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Продолжить' с валидными данными")
    public void testContinueButtonWithValidData() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        String testPhoneNumber = "297777777";
        String testAmount = "10";

        paymentPage.fillPaymentForm(testPhoneNumber, testAmount);

        assertTrue(paymentPage.isContinueButtonEnabled(),
                "Кнопка 'Продолжить' не активна при валидных данных");

        paymentPage.clickContinueButton();
    }

    @Test
    @DisplayName("Комплексная проверка всего блока онлайн пополнения")
    public void testCompleteOnlinePaymentBlock() {
        OnlinePaymentPage paymentPage = new OnlinePaymentPage(driver);

        assertEquals("Онлайн пополнение без комиссии", paymentPage.getBlockTitle());

        assertTrue(paymentPage.arePaymentSystemsDisplayed());
        assertTrue(paymentPage.getPaymentSystemsCount() >= 3);

        assertTrue(paymentPage.isDetailsLinkDisplayed());

        assertTrue(paymentPage.isPaymentFormDisplayed());

        String testPhoneNumber = "297777777";
        String testAmount = "5";

        paymentPage.fillPaymentForm(testPhoneNumber, testAmount);
        assertTrue(paymentPage.isContinueButtonEnabled());

        System.out.println("Все проверки блока 'Онлайн пополнение без комиссии' пройдены успешно");
    }
}
