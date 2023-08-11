package suport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import java.util.Random;

public class Utils extends RunCucumberTest {

    public static String getEmailAleatorio() {

        String email_inicial = "usuariotest";
        String email_final = "@testeexemplo.com";

        Random random = new Random ();
        int minimo = 1;
        int maximo = 9999999;
        int resultado = random.nextInt(maximo-minimo) + minimo + minimo;

        return email_inicial + resultado + email_final;
    }

    public static void scrollDown () throws InterruptedException  {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript ("window.scrollTo (0,10000)");
        Thread.sleep(40000);
    }

    public static void esperarElementoEstarPresenteTela(By element, int tempo) {
        WebDriverWait wait = new WebDriverWait (getDriver(), tempo);
        wait.until (ExpectedConditions.elementToBeClickable (element));
    }

}
