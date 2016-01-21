package Selenium_Web_YDH;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class ChangWebDriver {
public static boolean switchToWindow(String windowTitle,WebDriver dr){  
    boolean flag = false;  
    try { 
//	    	��ҳ�������е�windowshandle������set���ϵ���
        String currentHandle = dr.getWindowHandle();  
        Set<String> handles = dr.getWindowHandles();  
        for (String s : handles) {  
            if (s.equals(currentHandle))  
                continue;  
            else {  
            	dr.switchTo().window(s);
//	                �͵�ǰ�Ĵ��ڽ��бȽ������ͬ���л���windowhandle
//	                �ж�title�Ƿ��handles��ǰ�Ĵ�����ͬ
                if (dr.getTitle().contains(windowTitle)) {  
                    flag = true;  
                    System.out.println("Switch to window: "  
                            + windowTitle + " successfully!");  
                    break;  
                } else  
                    continue;  
            }  
        }  
    } catch (Exception e) {  
        System.out.printf("Window: " + windowTitle  
                + " cound not found!", e.fillInStackTrace());  
        flag = false;  
    }  
    return flag;  
} 
public static void main(String args[]){
System.setProperty("webdriver.chrome.driver", "D:\\WebDriverServer\\chromedriver.exe");
 
WebDriver driver = new ChromeDriver();
driver.get("http://www.bignox.com");
driver.findElement(By.linkText("��Ϸ��̳")).click();
driver.findElement(By.linkText("��Ϸ����")).click();
try {
Thread.sleep(5000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
ChangWebDriver.switchToWindow("��Ϸ����_ҹ��׿ģ����", driver);
driver.findElement(By.linkText("�������ύ��Ϸ")).click();
try {
Thread.sleep(5000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
driver.quit();
}
 
}