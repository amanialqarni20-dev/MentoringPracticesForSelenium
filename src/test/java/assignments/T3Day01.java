package assignments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

    public class T3Day01 {
        public static void main(String[] args) throws InterruptedException {

            //1 Go to the Amazon URL https://www.amazon.com/
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.amazon.com/");

            //2 Print the position and size of the page
            Thread.sleep(3000);
            Point position = driver.manage().window().getPosition();
            Dimension size = driver.manage().window().getSize();
            System.out.println("Current position: " + position);
            System.out.println("Current size: " + size);

            // 3Adjust the position and size of the page as desired
            driver.manage().window().setPosition(new Point(100, 50));
            driver.manage().window().setSize(new Dimension(1024, 768));
            Thread.sleep(3000);

            // 4Test that the page is in the position and size you want
            Point newPosition = driver.manage().window().getPosition();
            Dimension newSize = driver.manage().window().getSize();
            System.out.println("New position: " + newPosition);
            System.out.println("New size: " + newSize);

            // 5Close the page
            driver.quit();
        }
    }




