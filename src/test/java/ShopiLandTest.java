import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.awt.geom.Path2D.contains;

public class ShopiLandTest {
    public static void main(String[] args) {

        // Создаем экземпляр драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Шаг 1: Открыть главную страницу сайта shopiland.ru
        driver.get("https://shopiland.ru/");

        // Шаг 2: Найти первую картинку на странице и проверить наличие атрибута alt
        WebElement firstImage = driver.findElement(By.cssSelector("img"));
        String altValue = firstImage.getAttribute("alt");

        // Шаг 3: Проверить, что значение атрибута alt не пустое
        if (!altValue.isEmpty()) {
            System.out.println("Attribute alt is not empty");
        } else {
            System.out.println("Attribute alt is empty");
        }

        // Шаг 4: Перейти на страницу категории товаров
        driver.findElement(By.xpath("//p[contains(text(),'женские сумки')]")).click();

        // Шаг 5: Найти первую картинку на странице категории товаров и проверить наличие атрибута alt
        WebElement firstCategoryImage = driver.findElement(By.cssSelector("img"));
        String categoryAltValue = firstCategoryImage.getAttribute("alt");

        // Шаг 6: Проверить, что значение атрибута alt не пустое
        if (!categoryAltValue.isEmpty()) {
            System.out.println("Attribute alt is not empty");
        } else {
            System.out.println("Attribute alt is empty");
        }

        // Шаг 7: Перейти на страницу конкретного товара
/*
        driver.findElement(By.class("img.css-a68fjf"));
*/

        // Шаг 8: Найти картинку товара на странице и проверить наличие атрибута alt
        WebElement productImage = driver.findElement(By.cssSelector("img"));
        String productAltValue = productImage.getAttribute("alt");

        // Шаг 9: Проверить, что значение атрибута alt не пустое
        if (!productAltValue.isEmpty()) {
            System.out.println("Attribute alt is not empty");
        } else {
            System.out.println("Attribute alt is empty");
        }

     /*   // Шаг 10: Перейти на страницу корзины
        driver.findElement(By.linkText("Корзина")).click();

        // Шаг 11: Найти картинку товара в корзине и проверить наличие атрибута alt
        WebElement cartImage = driver.findElement(By.cssSelector("img"));
        String cartAltValue = cartImage.getAttribute("alt");

        // Шаг 12: Проверить, что значение атрибута alt не пустое
        if (!cartAltValue.isEmpty()) {
            System.out.println("Attribute alt is not empty");
        } else {
            System.out.println("Attribute alt is empty");
        }

        // Шаг 13: Перейти на страницу оформления заказа
        driver.findElement(By.linkText("Оформление заказа")).click();

        // Шаг 14: Найти картинку товара на странице оформления заказа и проверить наличие атрибута alt
        WebElement checkoutImage = driver.findElement(By.cssSelector("img"));
        String checkoutAltValue = checkoutImage.getAttribute("alt");

        // Шаг 15: Проверить, что значение атрибута alt не пустое
        if (!checkoutAltValue.isEmpty()) {
            System.out.println("Attribute alt is not empty");
        } else {
            System.out.println("Attribute alt is empty");
        }
*/
        // Закрываем браузер
        driver.quit();
    }
}
