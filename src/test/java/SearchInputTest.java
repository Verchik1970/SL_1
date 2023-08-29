import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.xpath;

public class SearchInputTest {

    private final static WebDriver driver = new ChromeDriver();
    static String testValue;
    private int resultSearch;
    /*   *****************LOKATORS***************
     **********************************************
     */
    private final String SEARCH_INPUT = "//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]";
    private final String ERROR_FOUND_ITEMS = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]";
    public static final String OZON_COUNT = "//*[@id=\"root\"]/div/div/div[3]/div[1]/fieldset/div/label[1]/span[2]/span";
    public static final String ALI_COUNT = "//*[@id=\"root\"]/div/div/div[3]/div[1]/fieldset/div/label[2]/span[2]/span";
    public static final String WILDBERIES_COUNT = "//*[@id=\"root\"]/div/div/div[3]/div[1]/fieldset/div/label[3]/span[2]/span";
    public static final String YM_COUNT = "//*[@id=\"root\"]/div/div/div[3]/div[1]/fieldset/div/label[4]/span[2]/span";
    public static final String SBER_COUNT = "//*[@id=\"root\"]/div/div/div[3]/div[1]/fieldset/div/label[5]/span[2]/span";
    public static final String KAZAN_COUNT = "//*[@id=\"root\"]/div/div/div[3]/div[1]/fieldset/div/label[6]/span[2]/span";


    /*
     ****************METHOD*****************
     ***********************************************/
    private int countResult(){
        List<WebElement> resultSearch = driver.findElements(By.cssSelector("p.css-99ww93:nth-child(5)"));
/*
        List<WebElement> resultSearch = driver.findElements(By.tagName("p"));
*/
        return resultSearch.size();

    }

    @ParameterizedTest
    @ValueSource(strings = { "кофе зерновой", "coffe", "КОФЕ РАСТВОРИМЫЙ", " кофе ", " ", "@#&(*&%^&%" })
    @DisplayName("Ввод тестовых данных в поле поиска")
    public void testSearchValue(String value) throws IOException {

        driver.get("https://www.shopiland.ru/");
        driver.manage().window().maximize();
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(value + "\n");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertTrue(countResult() > 0, "В маркетплейсе отсутствуют товары с данным поисковым запросом.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "кофе зерновой", "coffe", "КОФЕ РАСТВОРИМЫЙ", " кофе " })
    @DisplayName("сравнение текста")
    public void setAssertTextTest(String value) throws IOException{
        driver.get("https://www.shopiland.ru/");

        driver.manage().window().maximize();
        WebElement searchFields = driver.findElement(xpath(SEARCH_INPUT));
        searchFields.sendKeys(value + "\n");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement productText = driver.findElement(xpath("//p[contains(text(),'Кофе')]"));
        System.out.println(productText.getSize());
    }

    @ParameterizedTest
    @ValueSource(strings = { OZON_COUNT, ALI_COUNT, WILDBERIES_COUNT, YM_COUNT, SBER_COUNT,KAZAN_COUNT })
    @DisplayName("наличие в маркетплейсах")
    public void setAssertMarketplaceTest(String value) throws IOException{
        driver.get("https://www.shopiland.ru/");

        driver.manage().window().maximize();
        WebElement searchFields = driver.findElement(By.xpath(SEARCH_INPUT));
        searchFields.sendKeys("кофе зерновой" + "\n" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement productText = driver.findElement(By.xpath(value));
       String marketSearch = productText.getAttribute("textContent");
        System.out.println(marketSearch);
        assertNotEquals("0 шт", marketSearch,"нет в маркете + value");
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}