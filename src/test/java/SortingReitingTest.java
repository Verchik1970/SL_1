import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortingReitingTest {
    private final static WebDriver driver = new ChromeDriver();
/*
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
*/
    public String mainPage = "https://shopiland.ru/";
    private final String KETTLER_POP_MAIN = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/a[1]/div[1]/picture[1]/img[1]";
    private final String ALI_EXCLUDE_BUTTON = "input.PrivateSwitchBase-input.css-1m9pwf3[name=\"al\"][type=\"checkbox\"][aria-label=\"Checkbox demo\"][checked=\"\"]";
    private final String REITING_SORT_BUTTON = "//div[contains(text(),'рейтингу')]";
    private final String BRAND_SORT_BUTTON_FIRST= "a.css-95nm5l:nth-child(1)";
    private final String BRAND_SORT_BUTTON_SEVEN= "a.css-95nm5l:nth-child(7)";
    private final String CARDS_TEXT_VALUE = "p.css-99ww93:nth-child(5)";

        @Test
    void sortingReiting () {
            driver.get(mainPage);
            driver.findElement(By.xpath(KETTLER_POP_MAIN)).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(ALI_EXCLUDE_BUTTON)).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath(REITING_SORT_BUTTON)).click();
            // находим все карточки товара на странице
            List<WebElement> productCards = driver.findElements(By.cssSelector
                    ("div.MuiBox-root.css-bp8b62:nth-child(4) > span.css-1t0tstb"));
// получаем первую и последнюю карточки товара
            WebElement firstProductCard = productCards.get(0);
            String first = firstProductCard.getText();
            System.out.println(first);
            WebElement lastProductCard = productCards.get(productCards.size() - 1);
            String last = lastProductCard.getText();
            System.out.println(last);
        }

        @Test
        @DisplayName("Проверка сортировки по брендам")
       void sortBrendItem() throws InterruptedException {
            driver.get(mainPage);


            driver.findElement(By.xpath(KETTLER_POP_MAIN)).click();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            wait.until(ExpectedConditions.elementToBeClickable
                    (By.cssSelector(BRAND_SORT_BUTTON_FIRST)));
            String brand1 = driver.findElement
                    (By.cssSelector(BRAND_SORT_BUTTON_FIRST)).getText();
            System.out.println(brand1);
            driver.findElement(By.cssSelector(BRAND_SORT_BUTTON_FIRST)).click();

            Thread.sleep(1000);


            List<WebElement> productCards = driver.findElements
                    (By.cssSelector(CARDS_TEXT_VALUE));


            WebElement firstProductCard = productCards.get(0);
            String first = firstProductCard.getText();
            System.out.println(first);


            WebElement lastProductCard = productCards.get(productCards.size() - 1);
            String last = lastProductCard.getText();
            System.out.println(last);
        }
   /* @AfterAll
    public static void tearDown() {
        driver.quit();
    }*/
}

