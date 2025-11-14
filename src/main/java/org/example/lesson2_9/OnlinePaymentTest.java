import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentTest extends BaseTest {

    @Test
    @DisplayName("Проверка блока 'Онлайн пополнение без комиссии'")
    public void testOnlinePaymentBlock() {
        MtsHomePage homePage = new MtsHomePage(driver);

        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = homePage.getOnlinePaymentTitle();
        assertTrue(actualTitle.contains(expectedTitle),
                "Ожидалось, что заголовок содержит: " + expectedTitle + ", но получено: " + actualTitle);

        int logosCount = homePage.getPaymentSystemLogosCount();
        assertTrue(logosCount > 0, "Ожидалось наличие хотя бы одного логотипа платёжной системы");

        boolean allLogosDisplayed = homePage.arePaymentSystemLogosDisplayed();
        assertTrue(allLogosDisplayed, "Не все логотипы платёжных систем отображаются");

        String originalUrl = homePage.getCurrentUrl();
        homePage.clickDetailsLink();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String newUrl = homePage.getCurrentUrl();
        assertNotEquals(originalUrl, newUrl, "Ссылка 'Подробнее о сервисе' не работает - URL не изменился");

        driver.navigate().back();

        homePage.fillPaymentForm("297777777", "10");

        boolean isContinueButtonEnabled = homePage.isContinueButtonEnabled();
        assertTrue(isContinueButtonEnabled, "Кнопка 'Продолжить' должна быть активна после заполнения полей");

        homePage.clickContinueButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String paymentPageUrl = homePage.getCurrentUrl();
        assertTrue(paymentPageUrl.contains("payment") || !paymentPageUrl.equals("https://www.mts.by/"),
                "После нажатия кнопки 'Продолжить' должен произойти переход на страницу оплаты");
    }

    @Test
    @DisplayName("Проверка валидации номера телефона")
    public void testPhoneNumberValidation() {
        MtsHomePage homePage = new MtsHomePage(driver);

        homePage.fillPaymentForm("297777777", "10");
        boolean isValidPhoneEnabled = homePage.isContinueButtonEnabled();
        assertTrue(isValidPhoneEnabled, "Кнопка должна быть активна при валидном номере телефона");

        homePage.enterPhoneNumber("123");
        homePage.enterAmount("10");
    }
}