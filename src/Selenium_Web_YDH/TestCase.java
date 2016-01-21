package Selenium_Web_YDH;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.support.ui.Select;

import bsh.commands.dir;
/**
 * @author ҿ�Ʋ�����
 * @version  V1.0
 * @see�׶���������������߸���
 * */
public class TestCase {
	 public WebDriver driver;
	 public String baseUrl;
	 boolean acceptNextAlert = true;
	 StringBuffer verificationErrors = new StringBuffer();
	 
	//��������� 
	public void setUp(int browers) throws Exception {
		if(browers==0){
		//Firefox���������
			driver = new FirefoxDriver();	
			driver.manage().window().maximize(); 
		}else if(browers==1){
		//Chrome���������
		 System.setProperty("webdriver.chrome.driver","D:\\WebDriverServer\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize(); 
		}	
		else if(browers==2){
		// IE���������
		System.setProperty("webdriver.ie.driver","D:\\WebDriverServer\\IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);    
		driver = new InternetExplorerDriver(ieCapabilities);
		driver.manage().window().maximize(); 
		}
		baseUrl = "https://sso.dinghuo123.com/login?service=ydh-web";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}  	 
	
	
	//�����л�
	public static boolean switchToWindow(String windowTitle,WebDriver dr){  
	    boolean flag = false;  
	    try { 
//		    	��ҳ�������е�windowshandle������set���ϵ���
	        String currentHandle = dr.getWindowHandle();  
	        Set<String> handles = dr.getWindowHandles();  
	        for (String s : handles) {  
	            if (s.equals(currentHandle))  
	                continue;  
	            else {  
	            	dr.switchTo().window(s);
//		                �͵�ǰ�Ĵ��ڽ��бȽ������ͬ���л���windowhandle
//		                �ж�title�Ƿ��handles��ǰ�Ĵ�����ͬ
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
	//��¼����
	 public void login(String username,String password) throws Exception {

			
			driver.findElement(By.id("username")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("btn-submit")).click();
			Thread.sleep(1000);
		  }
	 
	 //ͨ���˺����ֵ�¼
	 public void login_help(String username,String password) throws Exception {

			
			driver.findElement(By.id("username")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("btn-submit")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//div[3]/div/a/span")).click();
		    Thread.sleep(2000);
			}
	 
	 //ע�᷽��
	 public void enroll() throws Exception {
			
			Random_tel aa = new Random_tel();
			String ss = aa.get_Random_Tel();
			driver.findElement(By.linkText("����ע��")).click();

			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(ss);
			Thread.sleep(1000);
			driver.findElement(By.id("verfCode")).clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			js.executeScript("$.ajax({url: 'https://sso.dinghuo123.com/ajaxChecking?action=getVerifyCode',"
					+ "type: 'get',dataType: 'text',success:function(responseText){"
					+ "$('#verfCode').val(responseText);" + "}})");
			driver.findElement(By.cssSelector("button.btn-getverfycode")).click();
			Thread.sleep(1000);
			String activecode;
			DBread db = new DBread(ss);
			activecode = db.getActiveCode(ss);
			System.out.println("��ȡ�����ֻ���֤��Ϊ:"+activecode);
			driver.findElement(By.id("mobileVerfyCode")).clear();
			driver.findElement(By.id("mobileVerfyCode")).sendKeys(activecode);
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("html body div.r1bg.register-bg div#step1.register-banner div.banner-wrap "
					+ "div.op-box.registerWrapper div.control-box form#validateCodeForm.animated.nice-validator.n-default "
					+ "div.control-group div.control-input.mb10 button#btn-register.ui-btn.ui-btn-theme.btn-register")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("companyName")).clear();
		    driver.findElement(By.name("companyName")).sendKeys("���Ʋ���");//������Ʋ��ԡ�Ϊ��˾���ƣ������޸�
		    Thread.sleep(1000);
		    driver.findElement(By.name("linkman")).clear();
		    driver.findElement(By.name("linkman")).sendKeys("����");//��˾����Ա����
		    Thread.sleep(1000);
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("123456");//��¼����
		    Thread.sleep(1000);
		    //driver.findElement(By.cssSelector("div.icheckbox_flat-blue.hover > ins.iCheck-helper")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("123456789@qq.com");
		    Thread.sleep(1000);
		    driver.findElement(By.id("btn-register2")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("registerToUseBtn")).click();
			Thread.sleep(2000);
			ChangWebDriver.switchToWindow("�ҵĹ���̨", driver);
			driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[2]")).click();
			driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[2]")).click();
			driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[2]")).click();
			driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[3]")).click();		
			Thread.sleep(3000);	
			System.out.println(ss + "���ڱ�ע���ˡ������ٺ�\t ���룺123456");
		}
	 
	 //��¼���˳�(������˳�)
		  public void logout() throws Exception {	
			Thread.sleep(2000);
			WebElement main=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[2]"));
			//��������¼�
			Actions ac=new Actions(driver);
			ac.moveToElement(main).perform();
			
			
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			//js.executeScript("$('.container','.user').show()",main);
			driver.findElement(By.linkText("�˳�")).click();
			Thread.sleep(1000);
		}
		  public void logout1() throws Exception {	
			    Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("$('.container','.user').show()");				
				driver.findElement(By.linkText("�˳�")).click();
				Thread.sleep(1000);
			}
		  
		  public void logout2() throws Exception {
			  driver.findElement(By.xpath("/html/body/div[1]/h1/a")).click();
			  driver.findElement(By.linkText("�˳�")).click();
		  }
		  public void logout3() throws Exception {
			  driver.findElement(By.linkText("�˳�")).click();
		  }
		  
		//�һ�����    ���������ڲ��Ի������һ��������
		  public void findPassword() throws Exception {
			    
			    driver.findElement(By.linkText("�������룿")).click();
			    driver.findElement(By.id("userName")).clear();
			    driver.findElement(By.id("userName")).sendKeys("18720091223");
			    driver.findElement(By.id("verfCode")).clear();
			    Thread.sleep(2000);
			    JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("$.ajax({url: 'https://sso.dinghuo123.com/ajaxChecking?action=getVerifyCode',"
						+ "type: 'get',dataType: 'text',success:function(responseText){"
						+ "$('#verfCode').val(responseText);" + "}})");
				Thread.sleep(1000);
			    driver.findElement(By.id("btn-submit")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.id("activeCode")).clear();
			    String activecode;
				DBread db = new DBread("18720091223");
				activecode = db.getActiveCode("18720091223");
				driver.findElement(By.id("activeCode")).sendKeys(activecode);				
			    driver.findElement(By.id("btn-submit")).click();
			    driver.findElement(By.id("password")).clear();
			    driver.findElement(By.id("password")).sendKeys("123456");
			    driver.findElement(By.id("password1")).clear();
			    driver.findElement(By.id("password1")).sendKeys("123456");
			    driver.findElement(By.id("btn-submit")).click();
			    Thread.sleep(3000);
			    driver.findElement(By.id("btn-quickLogin")).click();
			    Thread.sleep(2000); 
			  }
		  
		     //�һ��û������� 
		   public void findUsername(String email) throws Exception {
			    
			    driver.findElement(By.linkText("�������룿")).click();
			    driver.findElement(By.linkText("����һ�")).click();
			   // driver.findElement(By.cssSelector("img.auth-image")).click();
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys(email);
			    Thread.sleep(1000);
			    driver.findElement(By.id("verfCode")).clear();		    
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    Thread.sleep(1000);
				js.executeScript("$.ajax({url: 'https://sso.dinghuo123.com/ajaxChecking?action=getVerifyCode',"
						+ "type: 'get',dataType: 'text',success:function(responseText){"
						+ "$('#verfCode').val(responseText);" + "}})");
			    driver.findElement(By.id("btn-submit")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.linkText("������¼�����һ��û���")).click();
			    Thread.sleep(2000);
			  }
		  //�ر����������
		  public void tearDown() throws Exception {
				driver.quit();
				String verificationErrorString = verificationErrors.toString();
				if (!"".equals(verificationErrorString)) {
					fail(verificationErrorString);
				}
			}
		  
		  //��������
		  public void orderSearch() throws Exception {
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.id("search")).clear();
			    driver.findElement(By.id("search")).sendKeys("DH-O-201512");
			    driver.findElement(By.id("op-search")).click();
			    driver.findElement(By.xpath("//*[@id='searchComboWrap']/i")).click();
			    driver.findElement(By.xpath("//div[@id='COMBO_WRAP']/div[2]/div/div[2]")).click();
			    driver.findElement(By.id("search")).click();
			    driver.findElement(By.id("search")).clear();
			    driver.findElement(By.id("search")).sendKeys("DH-R-201512");
			    driver.findElement(By.id("op-search")).click();		    
			  }
		  
		  
		  //�����߼�����
		  public void advancedSearch() throws Exception {
			    driver.findElement(By.linkText("����")).click();			  
			    driver.findElement(By.cssSelector("#advanceSearchLink")).click();
			    driver.findElement(By.name("customerNameLike")).clear();
			    driver.findElement(By.name("customerNameLike")).sendKeys("����");
			    driver.findElement(By.xpath("(//input[@name='status'])[3]")).click();
			    driver.findElement(By.linkText("����")).click();
		  }
		  //����˴��µ�
		  public void order_replaceAgent() throws Exception {	
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.xpath("//form[@id='myForm']/div/div/a[2]/span[2]")).click();
			    driver.findElement(By.cssSelector("input.input-txt.agentAuto")).click();
			    driver.findElement(By.cssSelector("div.list-item.on")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.cssSelector("td.tip1-3")).click();
			    Thread.sleep(1000);
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("(function(){for(var i =0;i<3;i++){$(\".tip\"+(i+1)+\"-3\").click();$(\".list-item-product\")[Math.round("
			    		+ "Math.random()*$(\".list-item-product\").length)].click()}$(\"body\").click();})()");
			    Thread.sleep(1000); 
			    driver.findElement(By.xpath("//button")).click();	
			    Thread.sleep(1000); 
			  }
		  //����˴����˻���
		  public void returnOrder_replaceAgent() throws Exception {
			   Thread.sleep(1000);
			   // WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
				String jsp="$('.side-menu-a').eq(0).trigger('mouseenter')";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(jsp);			  
			    driver.findElement(By.linkText("�˻���")).click();
			    driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
			    driver.findElement(By.cssSelector("input.input-txt.agentAuto")).click();			    
			    driver.findElement(By.cssSelector("div.list-item.on")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.cssSelector("td.tip1-3")).click();
			    Thread.sleep(500);
			    JavascriptExecutor js1 = (JavascriptExecutor) driver;
			    js1.executeScript("(function(){for(var i =0;i<3;i++){$(\".tip\"+(i+1)+\"-3\").click();$(\".list-item-product\")[Math.round(Math.random()*$(\".list-item-product\").length)].click()}$(\"body\").click();})()");
			    Thread.sleep(1000); 
			    driver.findElement(By.cssSelector("div.total-l.chks")).click();
			    driver.findElement(By.id("inp-discount-order")).clear();
			    driver.findElement(By.id("inp-discount-order")).sendKeys("250");
			    driver.findElement(By.xpath("//textarea")).clear();
			    driver.findElement(By.xpath("//textarea")).sendKeys("��ע������һһ�ʹ���˴����˻���������"+this.getDate());
			    driver.findElement(By.xpath("//button")).click();
			  }
		  
		  
		  //���ﳵ�µ�
		  public void testShopcat() throws Exception  {
			    Thread.sleep(1000); 
			    driver.findElement(By.linkText("��Ʒ")).click();
			    driver.findElement(By.cssSelector("a.btn-away.btn-away-line")).click();
			    Thread.sleep(1000); 
			    driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
			    		+ "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).clear();
			    driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
			    		+ "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).sendKeys("8");
			    Thread.sleep(1000); 
			    driver.findElement(By.cssSelector("a.shopCart")).click();
				Thread.sleep(1000); 
				driver.findElement(By.linkText("�����µ�")).click();
				Thread.sleep(1000); 
				   // driver.findElement(By.xpath("//label[2]")).click();
				  //  driver.findElement(By.id("inp-discount-order")).clear();
				  //  driver.findElement(By.id("inp-discount-order")).sendKeys("324.00");
				Thread.sleep(1000); 
				driver.findElement(By.xpath("//textarea")).clear();
			    driver.findElement(By.xpath("//textarea")).sendKeys("��ע������һ������������������"+this.getDate());
				Thread.sleep(1000); 
                //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/div[1]/div[1]/div/label[2]")).click();
			    driver.findElement(By.xpath("//button")).click();
			    Thread.sleep(1000); 
		  }
		  
		  
		//���ﳵ���˻���	  
		  public void  backOrder() throws Exception {
			   // Thread.sleep(1000); 
			    driver.findElement(By.linkText("��Ʒ")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
			    Thread.sleep(1000); 
			   //driver.findElement(By.xpath("//input[@value='0']")).clear();
			   // driver.findElement(By.xpath("//input[@value='0']")).sendKeys("6");
			    driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
			    		+ "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).clear();
			    driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
			    		+ "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).sendKeys("8");
			    Thread.sleep(1000); 
			    driver.findElement(By.cssSelector("a.shopCart")).click();
			    Thread.sleep(1000); 
			    driver.findElement(By.linkText("�����µ�")).click();
			    Thread.sleep(1000); 
			    driver.findElement(By.xpath("//label[2]")).click();
			    driver.findElement(By.id("inp-discount-order")).clear();
			    driver.findElement(By.id("inp-discount-order")).sendKeys("324.00");
			    Thread.sleep(1000); 
			    driver.findElement(By.xpath("//textarea")).clear();
			    driver.findElement(By.xpath("//textarea")).sendKeys("��ע������һ���˻���������"+this.getDate());
			    Thread.sleep(1000); 
			    driver.findElement(By.xpath("//button")).click();
			    Thread.sleep(1000); 
		  }
		    
		  
		  //�������(�������µ�֮��������˶���)
		  public void orderCheck() throws Exception {
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.id("outStorage")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		   //�˻������(�������µ�֮��������̶���)
		  public void ruturnOrderCheck() throws Exception {
			    WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
				String jsp="$('.side-menu-a').eq(0).trigger('mouseenter')";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp, main);
			  
			    driver.findElement(By.linkText("�˻���")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		  //�������˻ز���
		  public void orderBack() throws Exception {			    
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			    Thread.sleep(500);
			    driver.findElement(By.linkText("�˻�")).click();
			    driver.switchTo().frame("iframe-back");
			    Thread.sleep(500);
			    driver.findElement(By.id("remarkText")).clear();
			    driver.findElement(By.id("remarkText")).sendKeys("����һ�ʶ����� ,�˻��Ĳ���������."+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.xpath("/html/body/div[1]/table")).findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		  //������������ɾ��
		  public void OrderCancelDelete() throws Exception {
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			    driver.findElement(By.linkText("����")).click();
			    driver.switchTo().frame("iframe-cancel");
			    driver.findElement(By.id("remarkText")).clear();
			    driver.findElement(By.id("remarkText")).sendKeys("�������ϲ�������������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("ɾ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		  //�˻���������ɾ��
		  public void returnOrderCancelDelete() throws Exception {
			    //WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
				String jsp="$('.side-menu-a').eq(0).trigger('mouseenter')";
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(jsp);		  
			    driver.findElement(By.linkText("�˻���")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			    driver.findElement(By.linkText("����")).click();
			    driver.switchTo().frame("iframe-cancel");//����������û���ϴ�20151215����������������������
			    driver.findElement(By.id("remarkText")).clear();
			    driver.findElement(By.id("remarkText")).sendKeys("����һ�������˻�����������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("ɾ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		  //����˶�������ҳ�������Ʒ��ע
		  public void goodRemark() throws Exception {
			   driver.findElement(By.cssSelector("i.icon")).click();
			   driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();    
			   driver.findElement(By.linkText("���")).click();
		       driver.switchTo().frame(0);
			   driver.findElement(By.id("remarkCon")).clear();
			   driver.findElement(By.id("remarkCon")).sendKeys("����һ����Ʒ��ע����������"+this.getDate());
			   Thread.sleep(2000);
			   driver.switchTo().defaultContent();
			   driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			   driver.findElement(By.cssSelector("i.icon")).click();
			  }
		  //�������Ӷ�����ע
		  public void testOrderRemark() throws Exception {
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();   
			    driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.id("remarkCon")).clear();
			    driver.findElement(By.id("remarkCon")).sendKeys("����һ��������עŶ��������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.cssSelector("i.icon")).click();
			  }
		  //�������޸�
		  public void testOrderModify() throws Exception {
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click(); 
			    driver.findElement(By.linkText("�޸�")).click();
			    Thread.sleep(1000);
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("(function(){for(var i =0;i<1;i++){$(\".tip\"+(i+1)+\"-3\").click();$(\".list-item-product\")"
			    		+ "[Math.round(Math.random()*$(\".list-item-product\").length)].click()}$(\"body\").click();})()");//��Ʒ���޸�
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
			    // driver.findElement(By.xpath("//*[@id='1']/td[5]")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("3");//��Ʒ�����޸�
			    Thread.sleep(500);
			    driver.findElement(By.xpath("//button")).click();    
			    driver.findElement(By.cssSelector("i.icon")).click();
		  }
		  //�˻����˻ز���
		  public void testReturnOrderBack() throws Exception {
			    WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
				String jsp="$('.side-menu-a').eq(0).trigger('mouseenter')";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp, main);	
			    driver.findElement(By.linkText("�˻���")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			    driver.findElement(By.linkText("ͨ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			    driver.findElement(By.linkText("�˻�")).click();			    
			    driver.switchTo().frame("iframe-back");
			    driver.findElement(By.id("remarkText")).clear();
			    driver.findElement(By.id("remarkText")).sendKeys("����һ���˻����˻ز�����������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		  //�˻�����ע
		  public void testReturnOrderRemark() throws Exception {
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.linkText("�˻���")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
			    driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.id("remarkCon")).clear();
			    driver.findElement(By.id("remarkCon")).sendKeys("�����˻�����ע��������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.cssSelector("i.icon")).click();
			  }
		  //������޸Ķ����ջ���ַ������ջ���ַ�ڶ�������ֻ���ģ������������ֻʵ���ջ���ַ�л���
		  public void orderModifyAddress() throws Exception {			   
			    driver.findElement(By.cssSelector("i.icon")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();   
			    driver.findElement(By.cssSelector("#address-edit > span.ui-btn-txt")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.linkText("��ΪĬ��")).click();
			    Thread.sleep(500);
			    driver.findElement(By.name("addressId")).click();
			    Thread.sleep(500);   
			    driver.switchTo().defaultContent();
			    driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			    driver.findElement(By.cssSelector("i.icon")).click();
		  }
		  //��������������
		  public void testAgentNewOrder() throws Exception {	
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.cssSelector("td.tip1-3")).click();
			    driver.findElement(By.xpath("//*[@id='1']/td[4]/span/span")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[2]/td[1]")).click();
			    driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[3]/td[1]")).click();
			    driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[4]/td[1]")).click();
			    driver.switchTo().defaultContent();
			    driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			    Thread.sleep(2000); 
			    driver.findElement(By.xpath("//div[2]/div/label")).click();
			    driver.findElement(By.id("inp-discount-order")).clear();
			    driver.findElement(By.id("inp-discount-order")).sendKeys("250.5");
			    driver.findElement(By.xpath("//textarea")).clear();
			    driver.findElement(By.xpath("//textarea")).sendKeys("������������������������"+this.getDate());
			    driver.findElement(By.xpath("//button")).click();
			    Thread.sleep(1000); 

			  }
		  //�����������˻���
		  public void testAgentNewReturnOrder() throws Exception {	
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.linkText("�˻���")).click();
			    driver.findElement(By.linkText("����")).click();
			    
			    
			    
			    
			    
			    driver.findElement(By.cssSelector("td.tip1-3")).click();
			    driver.findElement(By.xpath("//*[@id='1']/td[4]/span/span")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[2]/td[1]")).click();
			    driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[3]/td[1]")).click();
			    driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[4]/td[1]")).click();
			    driver.switchTo().defaultContent();
			    driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			   
			    
			    Thread.sleep(500); 
			    driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
			    driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("3");//�޸ĵ�һ����Ʒ����
			    driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
			    driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("6");//�޸ĵڶ�����Ʒ����
			    driver.findElement(By.id("inp-discount-order")).clear();
			    driver.findElement(By.id("inp-discount-order")).sendKeys("38.55");
			    driver.findElement(By.xpath("//textarea")).clear();
			    driver.findElement(By.xpath("//textarea")).sendKeys("�����������˻�����������"+this.getDate());
			    driver.findElement(By.xpath("//button")).click();
			    Thread.sleep(1000); 
			  }
		  //�����˶����޸Ķ�����ַ
		  public void testAgentModifyAddress() throws Exception{
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();    
			  driver.findElement(By.cssSelector("#address-edit > span.ui-btn-txt")).click();
			  driver.switchTo().frame(0);
			  driver.findElement(By.linkText("��ΪĬ��")).click();
			  Thread.sleep(500);
			  driver.findElement(By.name("addressId")).click();
			  Thread.sleep(500);   
			  driver.switchTo().defaultContent();
			  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  driver.findElement(By.linkText("����")).click();
		  }
		  
		 //������ע
		  public void testAgentOrderAddNote() throws Exception{
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();    
			  driver.findElement(By.linkText("��ӱ�ע")).click();
			  driver.switchTo().frame("iframe-remark");
			  driver.findElement(By.id("remarkCon")).clear();
			  driver.findElement(By.id("remarkCon")).sendKeys("����һ�������˶�����עŶ��������"+this.getDate());
			  driver.switchTo().defaultContent();
			  driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  driver.findElement(By.linkText("����")).click();
		  }
		  //��������
		  public void testAgentOrderCancel() throws Exception{
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();    
			  driver.findElement(By.linkText("����")).click();
			  driver.switchTo().frame("iframe-cancel");
			  driver.findElement(By.id("remarkText")).clear();
			  driver.findElement(By.id("remarkText")).sendKeys("����һ�������˶������ϲ���Ŷ��������"+this.getDate());
			  driver.switchTo().defaultContent();
			  driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  driver.findElement(By.linkText("����")).click();
		  }
		  //�˻�����ӱ�ע
		  public void testAgentReturnOrderAddNote() throws Exception{
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.linkText("�˻���")).click();		  
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();    
			  driver.findElement(By.linkText("��ӱ�ע")).click();
			  driver.switchTo().frame("iframe-remark");
			  driver.findElement(By.id("remarkCon")).clear();
			  driver.findElement(By.id("remarkCon")).sendKeys("����һ���������˻��˶�����עŶ��������"+this.getDate());
			  driver.switchTo().defaultContent();
			  driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  driver.findElement(By.linkText("����")).click(); 
			  
		  }
		  public void testAgentReturnOrderCancel() throws Exception{
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.linkText("�˻���")).click();	
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();    
			  driver.findElement(By.linkText("����")).click();
			  driver.switchTo().frame("iframe-cancel");
			  driver.findElement(By.id("remarkText")).clear();
			  driver.findElement(By.id("remarkText")).sendKeys("����һ���������˻������ϲ���Ŷ��������������"+this.getDate());
			  driver.switchTo().defaultContent();
			  driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  //driver.findElement(By.linkText("����")).click();
					  
		  }
		  
		 //������Ʒ
		  public void testAddGood() throws Exception {
			    String goodName="������Ʒ"+this.getRandomString(5);
			    driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
			    driver.findElement(By.xpath("//a[3]/span[2]")).click();
			    driver.findElement(By.name("productName")).clear();
			    driver.findElement(By.name("productName")).sendKeys(goodName);
			    driver.findElement(By.name("productTypeName")).click();			    
			    driver.findElement(By.linkText("ͨ��")).click();			    
			    driver.findElement(By.name("productUnitName")).click();			    
			    driver.findElement(By.cssSelector("div.list-item.on")).click();
			    driver.findElement(By.name("keywords")).click();
			    driver.findElement(By.name("keywords")).clear();
			    driver.findElement(By.name("keywords")).sendKeys("0000");
			    driver.findElement(By.name("sortNum")).clear();
			    driver.findElement(By.name("sortNum")).sendKeys("1");
			    driver.switchTo().frame("ueditor_0");
			    driver.findElement(By.xpath("/html/body")).click();
			    driver.findElement(By.xpath("/html/body")).clear();
			    driver.findElement(By.xpath("/html/body")).sendKeys(this.getDate()+"  ���ǲ�����Ʒ0000�����������ٶ���Ŵ�ʦ��IDS���ٴ�\n҅USA��ISA�Ŵ������"
			    		+ "��Ŷ�Ŵ��췢���ط���\ndsajdashddkjsadhsj���ۿ϶������������������Ź��ط�\n�����÷�ط�"
			    		+ "��˹��fdfdasfsadfdjklfkjlhlkjkjdfdkj \n�ĵط�˼������ɶ�ط��Ϳ����� ��ռ���Ĵ��з���ʿ�ٷſ��ɷ���ʿ�ٿ��� \ngfd���췢��");
			    driver.switchTo().defaultContent();
			    driver.findElement(By.id("marketPriceMain")).clear();
			    driver.findElement(By.id("marketPriceMain")).sendKeys("20");
			    driver.findElement(By.id("costPriceMain")).clear();
			    driver.findElement(By.id("costPriceMain")).sendKeys("10");
			    Thread.sleep(800);
			    driver.findElement(By.xpath("//button")).click();
			    Thread.sleep(1000);
			  }
		//������Ʒ(2)������ӵ���Ʒû����Ʒ����
		  public void testAddGood2() throws Exception {
			    String goodName="������Ʒ"+this.getRandomString(5);
			    driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
			    driver.findElement(By.xpath("//a[3]/span[2]")).click();
			    driver.findElement(By.name("productName")).clear();
			    driver.findElement(By.name("productName")).sendKeys(goodName);
			    driver.findElement(By.name("productTypeName")).click();
			    driver.findElement(By.linkText("ͨ��")).click();	
			    driver.findElement(By.name("productUnitName")).click();
			    driver.findElement(By.cssSelector("div.list-item.on")).click();
			    driver.findElement(By.name("keywords")).click();
			    driver.findElement(By.name("keywords")).clear();
			    driver.findElement(By.name("keywords")).sendKeys("shangping01");
			    driver.findElement(By.name("sortNum")).clear();
			    driver.findElement(By.name("sortNum")).sendKeys("1");
			    driver.findElement(By.id("marketPriceMain")).clear();
			    driver.findElement(By.id("marketPriceMain")).sendKeys("25");
			    driver.findElement(By.id("costPriceMain")).clear();
			    driver.findElement(By.id("costPriceMain")).sendKeys("15");
			    Thread.sleep(800);
			    driver.findElement(By.xpath("//button")).click();
			    Thread.sleep(1000);
			  }
		  //ɾ����Ʒ
		  public void testDeleteGood(){
			  driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
			  driver.findElement(By.linkText("ɾ��")).click();
			  driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
		  }
		  //�޸���Ʒ
		  public void testModifyGood() throws Exception{
			  driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
			  driver.findElement(By.linkText("�޸�")).click();
			  ChangWebDriver.switchToWindow("�޸���Ʒ", driver);//�����л����ڵ�
			  //String goodName1="�޸���Ʒ"+this.getRandomString(6);			  
			  //driver.findElement(By.className("productaddMain")).findElement(By.name("productName")).clear();
			  //driver.findElement(By.className("productaddMain")).findElement(By.name("productName")).sendKeys( goodName1);
			  driver.findElement(By.name("productTypeName")).click();
			  driver.findElement(By.linkText("���Է���")).click();
			  driver.findElement(By.name("keywords")).click();
			  driver.findElement(By.name("keywords")).clear();
			  driver.findElement(By.name("keywords")).sendKeys("�޸���Ʒ01");
			  driver.findElement(By.name("sortNum")).clear();
			  driver.findElement(By.name("sortNum")).sendKeys("8");
			  driver.findElement(By.cssSelector("label.productLabelItem")).click();
			  driver.findElement(By.xpath("//label[2]")).click();
			  driver.findElement(By.xpath("//label[3]")).click();
			  driver.findElement(By.id("marketPriceMain")).clear();
			  driver.findElement(By.id("marketPriceMain")).sendKeys("99");
			  driver.findElement(By.id("costPriceMain")).clear();
			  driver.findElement(By.id("costPriceMain")).sendKeys("70");
			  driver.findElement(By.xpath("//button")).click();
			  driver.findElement(By.linkText("��Ʒ")).click();
		  }
		  //��Ʒ����
		  public void testSearchGood() throws Exception {
			    driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
			    driver.findElement(By.id("search")).clear();
			    driver.findElement(By.id("search")).sendKeys("ƻ��");
			    driver.findElement(By.id("op-search")).click();
			    driver.findElement(By.id("search")).clear();
			    driver.findElement(By.id("search")).sendKeys("P60942451");
			    driver.findElement(By.id("op-search")).click();
			  }
		  //�����Ʒ������λ
		  public void testAddUnit() throws Exception {
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		
				String goodUnit=this.getRandomString(5);
			    driver.findElement(By.linkText("������λ")).click();
			    driver.findElement(By.cssSelector("button.ui-btn.ui-btn-blue")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.id("productUnitName")).clear();
			    driver.findElement(By.id("productUnitName")).sendKeys(goodUnit);
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.linkText("ɾ��")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			  }
		  public void testShareGood() throws Exception {
			  driver.findElement(By.linkText("��Ʒ")).click();		 
			  driver.findElement(By.xpath("//*[@id='productEntries']/tr[1]/td[2]/div/a[2]")).click();
			  Thread.sleep(5000);
			  driver.findElement(By.id("btn-product-share")).click();			    
			  driver.switchTo().frame(0);
			  driver.findElement(By.cssSelector("i")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.cssSelector("a.btn-share.btn-share-weixin > i")).click();
			  Thread.sleep(1000);
			  driver.switchTo().defaultContent();
			  driver.findElement(By.linkText("��")).click();
			  driver.findElement(By.linkText("��Ʒ")).click();
			  } 
         public void testSearchWarehouse() throws Exception{
        	 WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        	 String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
		     JavascriptExecutor js = (JavascriptExecutor) driver;
		     Thread.sleep(1000);
		     js.executeScript(jsp,main);		
		     driver.findElement(By.linkText("��Ʒ���")).click();
		     driver.findElement(By.xpath("//*[@id='search']")).click();
		     driver.findElement(By.xpath("//*[@id='search']")).clear();
		     driver.findElement(By.xpath("//*[@id='search']")).sendKeys("ƻ��");
		     driver.findElement(By.id("op-search")).click();    	 
         }
         //�ɹ����
		  public void testProcurement() throws Exception{
			  WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
			  String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript(jsp,main);		
			  driver.findElement(By.linkText("��Ʒ���")).click();
			  driver.findElement(By.linkText("����")).click();
			  Thread.sleep(500);
			  JavascriptExecutor js1 = (JavascriptExecutor) driver;
			  js1.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
				    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
		      Thread.sleep(500); 
			  driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
			  driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("500");//�޸ĵ�һ����Ʒ����
			  driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
			  driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("������Ʒ��ע");//�޸ĵ�һ����Ʒ����
			  driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
			  driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("635");//�޸ĵڶ�����Ʒ����
			  Thread.sleep(500); 
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("��Ʒ�ɹ���ⱸעŶŶ������������"+this.getDate());
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
			  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("TryMax_WuPeng");			  
			  driver.findElement(By.xpath("//button")).click();		
			  Thread.sleep(1000); 
		  }
		  //�������
		  public void testInWareHouse() throws Exception {
			  WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
			  String js1="$('.side-menu-a').eq(2).trigger('mouseenter')";
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript(js1,main);	
			  driver.findElement(By.linkText("��Ʒ���")).click();
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.cssSelector("span.trigger")).click();
			  driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2)"))
			        .findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();//����ѡ�������ѡ����	
			  driver.findElement(By.id("inventoryDate")).click();
			  driver.findElement(By.xpath("//button[@type='button']")).click();
			  driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			  Thread.sleep(500); 
			  js.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
			    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
	         Thread.sleep(500); 
		     driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
	   	     driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("660");//�޸ĵ�һ����Ʒ����
		     driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
		     driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("������Ʒ��ע");//�޸ĵ�һ����Ʒ����
	   	     driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
		     driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("850");//�޸ĵڶ�����Ʒ����
		     Thread.sleep(500); 
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("������Ʒ������ⱸע������������"+this.getDate());
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("Try_WuPeng");		     
		     driver.findElement(By.xpath("//button")).click();	
		     Thread.sleep(1000); 
			  }
		  //���۳���
		  public void testSellOut() throws Exception {
			  WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
			  String js1="$('.side-menu-a').eq(2).trigger('mouseenter')";
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript(js1,main);	
			  driver.findElement(By.linkText("��Ʒ����")).click();
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.cssSelector("span.trigger")).click();
			  driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2)"))
			        .findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(1)")).click();//����ѡ�������ѡ����	
			  driver.findElement(By.id("inventoryDate")).click();//ʱ��ѡ��ѡ��ǰʱ��
			  driver.findElement(By.xpath("//button[@type='button']")).click();
			  driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			  Thread.sleep(500); 
			  js.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
			    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
	         Thread.sleep(500); 
		     driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
	   	     driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("10");//�޸ĵ�һ����Ʒ����
		     driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
		     driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("������Ʒ��ע");//�޸ĵ�һ����Ʒ����
	   	     driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
		     driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("25");//�޸ĵڶ�����Ʒ����
		     driver.findElement(By.xpath("//*[@id='3']/td[5]")).click();
		     driver.findElement(By.xpath("//*[@id='3']/td[5]")).findElement(By.id("3_count")).sendKeys("15");//�޸�������Ʒ����
		     Thread.sleep(500); 
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("������Ʒ���۳��ⱸע������������"+this.getDate());
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("Try_WuPeng");
		     Thread.sleep(1000); 
		     driver.findElement(By.xpath("//button")).click();		  
			  } 	  
		  //��������
		  public void testOutWareHouse() throws Exception {
			  WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
			  String js1="$('.side-menu-a').eq(2).trigger('mouseenter')";
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript(js1,main);	
			  driver.findElement(By.linkText("��Ʒ����")).click();
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.cssSelector("span.trigger")).click();
			  driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2)"))
			        .findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();//����ѡ�������ѡ����	
			  driver.findElement(By.id("inventoryDate")).click();
			  driver.findElement(By.xpath("//button[@type='button']")).click();
			  driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			  Thread.sleep(500); 
			  js.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
			    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
	         Thread.sleep(500); 
		     driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
	   	     driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("500");//�޸ĵ�һ����Ʒ����
		     driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
		     driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("������Ʒ��ע");//�޸ĵ�һ����Ʒ����
	   	     driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
		     driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("635");//�޸ĵڶ�����Ʒ����
		     Thread.sleep(500); 
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("������Ʒ���ⱸע������������"+this.getDate());
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
		     driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("Try_WuPeng");
		     Thread.sleep(1000); 
		     driver.findElement(By.xpath("//button")).click();		  
			  }
		  //������Ʒ���������۴�����
		  public void testSaleDiscount() throws Exception{
			    driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����Ʒ����")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	
				Thread.sleep(1000); 
				js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
				    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
			    Thread.sleep(500);	
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();    
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
				driver.findElement(By.xpath("//label[3]")).click();
				driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).clear();
				driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).sendKeys("85");	    
				driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
				    		                          + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
				driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[2]/div/div[3]")).click();	    
				driver.findElement(By.xpath("//button")).click();
				Thread.sleep(1000);
		  }
		  //������Ʒ������ֱ����
		  public void testSalePromotion() throws Exception{
			    //driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����Ʒ����")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	
				Thread.sleep(1000); 
				js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
				    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
			    Thread.sleep(500);	
				//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();    
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
				driver.findElement(By.xpath("//label[2]")).click();
				driver.findElement(By.cssSelector("input.ui-input-line.promotionMoney")).clear();
				driver.findElement(By.cssSelector("input.ui-input-line.promotionMoney")).sendKeys("5");   
				driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();	//�й�
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.province > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.city > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.district > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();	//۶��	    
                Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				driver.findElement(By.linkText("��Ʒ")).click();
				Thread.sleep(1000);
		  }
		  //������Ʒ������������û��ѡ��������Ʒ������ֻ�����Լ�����
		  public void testSalePresent() throws Exception{
			   // driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����Ʒ����")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	
				Thread.sleep(1000); 
				js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
				    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
			    Thread.sleep(2000);	
				//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();    
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[4]/div[2]/label[1]")).click();
				driver.findElement(By.cssSelector("input.ui-input-line.meetCount")).clear();
			    driver.findElement(By.cssSelector("input.ui-input-line.meetCount")).sendKeys("20");
			    driver.findElement(By.cssSelector("input.ui-input-line.promotionGiftCount")).clear();
			    driver.findElement(By.cssSelector("input.ui-input-line.promotionGiftCount")).sendKeys("1");
				driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();	//�й�
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.province > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.city > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.district > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();	//۶��	    
                Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				Thread.sleep(1000);
		  }
		//������Ʒ���������ݴ��۴�����
		  public void testSaleDiscount2() throws Exception{
			    driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����Ʒ����")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	
				Thread.sleep(1000); 
				js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
				    		+ "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
			    Thread.sleep(500);	
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();    
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
				driver.findElement(By.xpath("//label")).click();
			    driver.findElement(By.xpath("//label[3]")).click();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetCount")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetCount")).sendKeys("20");
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).sendKeys("98");
			    driver.findElement(By.linkText("+�������")).click();
			    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
			    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("50");
			    driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
			    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("90");
			    driver.findElement(By.linkText("+�������")).click();
			    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
			    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("100");
			    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
			    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("85");

				driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();	//�й�
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.province > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.city > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                        + "div:nth-child(6) > div.control-input > div > div.district > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();	//۶��	    
                Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				driver.findElement(By.linkText("��Ʒ")).click();
				Thread.sleep(1000);
		  }
		  //�������������ۣ�
		  public void testOrderSaleDiscount() throws Exception{
			    driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����������")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	  
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
			    driver.findElement(By.xpath("//label[3]")).click();
			    driver.findElement(By.cssSelector("input.ui-input-line.meetMoney")).clear();
			    driver.findElement(By.cssSelector("input.ui-input-line.meetMoney")).sendKeys("2000");
			    driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).clear();
			    driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).sendKeys("95");
			    driver.findElement(By.xpath("//div[4]/div[2]/label[1]")).click();
			    driver.findElement(By.xpath("//div[4]/div[2]/label[2]")).click();		    
				driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
						                          + "div.country > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(3)")).click();	//��������    
                Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				driver.findElement(By.linkText("��Ʒ")).click();
				Thread.sleep(1000);
		  }
		  //����������������
		  public void testOrderSalePromotion() throws Exception{
			    driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����������")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	
				//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();    
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
			    driver.findElement(By.xpath("//label[2]")).click();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).sendKeys("2000");
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minusMoney")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minusMoney")).sendKeys("80");
			    driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                                                    + "div.country > span > input")).click();
              driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(1)")).click();	//ȫ������  
              Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				driver.findElement(By.linkText("��Ʒ")).click();
				Thread.sleep(1000);
		  }
		  //����������������
		  public void testOrderSalePresent() throws Exception{
			    driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����������")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	  
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/label[1]")).click();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).sendKeys("5000");		    			    			    
			    //ѡ��������Ʒ
			    driver.findElement(By.linkText("ѡ��������Ʒ")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.xpath("//input[@type='text']")).clear();
			    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ƻ��2");
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.id("goodsContainer")).findElement(By.cssSelector("#goodsContainer > tr:nth-child(2)")).click();
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
		    
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionGiftCount")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionGiftCount")).sendKeys("20");
			    driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                                                    + "div.country > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();	//�й�
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                		                           + "div.province > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                	                        	+ "div.city > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                		                         + "div.district > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();	//۶��	    
                Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				driver.findElement(By.linkText("��Ʒ")).click();
				Thread.sleep(1000);
		  }
		  //�������������ݴ�����
		  public void testOrderSaleDiscount2() throws Exception{
			    driver.findElement(By.linkText("��Ʒ")).click();
			    String jsp="$('.side-menu-a').eq(2).trigger('mouseenter')";
			    WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript(jsp,main);		  
				driver.findElement(By.linkText("����������")).click();
				driver.findElement(By.cssSelector("span.ui-btn-txt")).click();	  
			    driver.findElement(By.name("startTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();  
				driver.findElement(By.name("endTime")).click();
				driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();	  	    
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
				driver.findElement(By.xpath("//label")).click();
			    driver.findElement(By.xpath("//label[3]")).click();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetMoney")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetMoney")).sendKeys("1000");
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).clear();
			    driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).sendKeys("98");
			    driver.findElement(By.linkText("+�������")).click();
			    driver.findElement(By.xpath("(//input[@value=''])[9]")).clear();
			    driver.findElement(By.xpath("(//input[@value=''])[9]")).sendKeys("5000");
			    driver.findElement(By.xpath("(//input[@value=''])[10]")).clear();
			    driver.findElement(By.xpath("(//input[@value=''])[10]")).sendKeys("90");
			    driver.findElement(By.linkText("+�������")).click();
			    driver.findElement(By.xpath("(//input[@value=''])[11]")).clear();
			    driver.findElement(By.xpath("(//input[@value=''])[11]")).sendKeys("10000");
			    driver.findElement(By.xpath("(//input[@value=''])[12]")).clear();
			    driver.findElement(By.xpath("(//input[@value=''])[12]")).sendKeys("85");		    		    
			    driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                                                    + "div.country > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();	//�й�
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                		                           + "div.province > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                	                        	+ "div.city > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();	//����
                driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                		                         + "div.district > span > input")).click();
                driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();	//۶��	    
                Thread.sleep(1000);
				driver.findElement(By.xpath("//button")).click();
				driver.findElement(By.linkText("��Ʒ")).click();
				Thread.sleep(1000);
		  }
		  //��������Ʒ��������Ʒ����,������Ʒ���𣬼��������Ʒ�����ﳵ�������ղأ������ղ��б����������������� ��
		  public void testAgentGoods(int k) throws Exception{	
			    if(k==0)
			    driver.findElement(By.linkText("��Ʒ")).click();
			    if(k==1)
			    driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a")).click();
			    driver.findElement(By.id("search")).clear();
			    driver.findElement(By.id("search")).sendKeys("ƻ��2");
			    driver.findElement(By.id("op-search")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
			    driver.findElement(By.xpath("//*[@id='productEntries']/tr/td[1]/div/a[2]")).click();
			    ChangWebDriver.switchToWindow("��Ʒ����", driver);//�����л����ڵ�
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[1]/input")).clear();
			    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[1]/input")).sendKeys("2");			    
			    driver.findElement(By.cssSelector("#addtocart > span")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.cssSelector("#addtofav > span")).click();				    
			    driver.findElement(By.className("shopCart")).click();
			    Thread.sleep(1000);	  
			    driver.findElement(By.linkText("��չ��ﳵ")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();			    			    
			    driver.findElement(By.linkText("��Ʒ")).click();
			    driver.findElement(By.linkText("��Ʒ�ղؼ�")).click();
			    driver.findElement(By.id("search")).clear();
			    driver.findElement(By.id("search")).sendKeys("ƻ��2");
			    driver.findElement(By.id("op-search")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.cssSelector("img.product-img")).click();
			    ChangWebDriver.switchToWindow("��Ʒ����", driver);//�����л����ڵ�
			    driver.findElement(By.cssSelector("#addtofav > span")).click();		  
			    Thread.sleep(1000);
		  }
		  //�رջ����ʽ��˺�
		  public void closeOpenFund() throws Exception{
			     
			    Thread.sleep(1000);
			    WebElement main=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div"));
			    JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("$('.container','.setting').show()",main);
				Thread.sleep(1000);
			    driver.findElement(By.linkText("ϵͳ����")).click();
			    Thread.sleep(1000);
			    js.executeScript("$('#myForm > div > div > div:nth-child(8) > div > div.control-input > div > span > label').click()");
			    driver.findElement(By.xpath("//button")).click();
			    driver.findElement(By.xpath("/html/body/div[1]/h1/a/img")).click();//�ص���ҳ����
		  }
		  //�ʽ��˺ų�ʼ��
		  public  void fundInitialize(){
			    driver.findElement(By.linkText("�ʽ�")).click();
			    driver.findElement(By.name("searchValue")).clear();
			    driver.findElement(By.name("searchValue")).sendKeys("����");
			    driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
			    driver.findElement(By.linkText("��ʼ��")).click();
			    driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();   	
			    driver.findElement(By.xpath("/html/body/div[1]/h1/a/img")).click();
		  }
		  //�ʽ��˺ų�ֵ(ǰ���ǿ����ʽ��˺����ʼ��)
		  public void fundRecharge(){
			    driver.findElement(By.linkText("�ʽ�")).click();
			    driver.findElement(By.name("searchValue")).clear();
			    driver.findElement(By.name("searchValue")).sendKeys("����");
			    driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
			    driver.findElement(By.linkText("��ֵ")).click();
			    driver.switchTo().frame(0);
			    driver.findElement(By.id("payTime")).click();
			    driver.findElement(By.linkText("19")).click();
			    driver.findElement(By.id("money")).clear();
			    driver.findElement(By.id("money")).sendKeys("2000");
			    driver.findElement(By.id("remark")).clear();
			    driver.findElement(By.id("remark")).sendKeys("Ԥ�����˺ų�ֵ��ע��������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();		
			    driver.findElement(By.xpath("/html/body/div[1]/h1/a/img")).click();
		  }
		  //�ʽ��˺ſۿ�
		  public void backRecharge(){
			    driver.findElement(By.linkText("�ʽ�")).click();
			    driver.findElement(By.name("searchValue")).clear();
			    driver.findElement(By.name("searchValue")).sendKeys("����");
			    driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
			    driver.findElement(By.linkText("�ۿ�")).click();
			    driver.switchTo().frame(0);		    
			    driver.findElement(By.id("payTime")).click();
			    driver.findElement(By.linkText("16")).click();
			    driver.findElement(By.id("money")).clear();
			    driver.findElement(By.id("money")).sendKeys("250");
			    driver.findElement(By.id("remark")).clear();
			    driver.findElement(By.id("remark")).sendKeys("�ʽ��˺ſۿע��������"+this.getDate());
			    driver.switchTo().defaultContent();
			    driver.findElement(By.cssSelector("input.ui_state_highlight")).click();	
		  }
		  //��壨��ʼ���ʽ��˺š��ʽ��ֵ���ʽ�ۿ���ʽ������ſ��Բ�����壩
		  public void hongChong(){
			    driver.findElement(By.linkText("�ʽ�")).click();
			    driver.findElement(By.name("searchValue")).clear();
			    driver.findElement(By.name("searchValue")).sendKeys("����");
			    driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
			    driver.findElement(By.linkText("��֧��ϸ")).click();
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.linkText("���")).click();
			    driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
		  }
		  //����������ڶ�����ɵĻ��˸��
		  public void orderPay() throws Exception{
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.linkText("����")).click();
			    this.switchToWindow("��������", driver);
			    driver.findElement(By.linkText("����֧��")).click();
			    driver.findElement(By.id("payTime")).click();
			    driver.findElement(By.linkText("18")).click();
			    driver.findElement(By.id("remark")).clear();
			    driver.findElement(By.id("remark")).sendKeys("���Ƕ�������ı�ע��������"+this.getDate());
			    Thread.sleep(1000);
			    driver.findElement(By.linkText("����֧��")).click();
			   // driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			    this.switchToWindow("�������б�", driver);
		  }
		  //�����������տ�ȷ��
		  public void  confirmPay() throws Exception{
			   driver.findElement(By.linkText("�ʽ�")).click();
			   Thread.sleep(1000);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");	
			   driver.findElement(By.linkText("�տ�ȷ��")).click();
			   driver.findElement(By.linkText("ȷ���տ�")).click();
			   driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();		 
			  
		  }
		  //��������˺�
		  public  void  addBankAccount() throws Exception{
			 //  driver.findElement(By.linkText("�ʽ�")).click();
			   Thread.sleep(1000);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");	
			   Thread.sleep(1000);
			   driver.findElement(By.linkText("�����˺�")).click();
			   driver.findElement(By.id("addBank")).click();
			   Thread.sleep(1000);
			   driver.findElement(By.id("bankAccountName")).clear();
			   driver.findElement(By.id("bankAccountName")).sendKeys("�Զ������������˺�");
			   driver.findElement(By.id("bankName")).clear();
			   driver.findElement(By.id("bankName")).sendKeys("�׶�������");
			   driver.findElement(By.id("bankAccount")).clear();
			   driver.findElement(By.id("bankAccount")).sendKeys("7896564546545877978");
			   driver.findElement(By.id("saveBank")).click();			   
		  }
		  //ɾ�������˺�
		  public  void  deleteBankAccount() throws Exception{
			   driver.findElement(By.linkText("�ʽ�")).click();
			   Thread.sleep(1000);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");	
			   driver.findElement(By.linkText("�����˺�")).click();
			   driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/a")).click();
			   driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
		  }
		  //����ͳ�ƣ��������������֧��ϸ�������տ�ͳ����ʾ�鿴������
		  public void statisticsDeliverGoods() throws Exception{
			   driver.findElement(By.linkText("�ʽ�")).click();
			   Thread.sleep(1000);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");	
			   driver.findElement(By.linkText("��֧��ϸ")).click();
			   Thread.sleep(2000);
			   js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
			   driver.findElement(By.linkText("�����տ�ͳ��")).click();
			   Thread.sleep(2000);
			   js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
			   driver.findElement(By.linkText("����ͳ��")).click();
			   driver.findElement(By.id("report_dateFrom")).click();
			   driver.findElement(By.linkText("1")).click();
			   driver.findElement(By.id("report_dateTo")).click();
			   driver.findElement(By.linkText("30")).click();
			   driver.findElement(By.id("queryContent")).click();
			   Thread.sleep(2000);
			   driver.findElement(By.linkText("�����ѯ����")).click();
			   driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[2]/div/div[2]/input")).clear();
			   driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[2]/div/div[2]/input")).sendKeys("����");
			   driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[5]/div/div[2]/input")).clear();
			   driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[5]/div/div[2]/input")).sendKeys("ţ��");
			   driver.findElement(By.id("queryContent")).click();
			   Thread.sleep(2000);			   
		  }
		  //�������ʽ��˺ų�ֵ
		  public void testAgentFundRecharge() throws Exception{
			  driver.findElement(By.linkText("�ʽ�")).click();
			  driver.findElement(By.linkText("��ֵ")).click();
			  this.switchToWindow("�˺ų�ֵ", driver);
			  driver.findElement(By.linkText("����֧��")).click();
			  driver.findElement(By.name("txtOfflineRechargeMoney")).clear();
			  driver.findElement(By.name("txtOfflineRechargeMoney")).sendKeys("888");
			  driver.findElement(By.id("payTime")).click();
			  driver.findElement(By.linkText("17")).click();
			  driver.findElement(By.id("remark")).clear();
			  driver.findElement(By.id("remark")).sendKeys("�������ʽ��˺ų�ֵ��������"+this.getDate());
			  Thread.sleep(1000);
			  driver.findElement(By.linkText("������ֵ")).click();
		  }
		  //�ͻ���������
		  public void testClientlevel() throws Exception{
			   driver.findElement(By.linkText("�ͻ�")).click();
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   Thread.sleep(1000);
			   js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
			   driver.findElement(By.linkText("�ͻ���������")).click();
			   driver.findElement(By.cssSelector("button.ui-btn.ui-btn-theme")).click();
			   driver.switchTo().frame(0);
			   driver.findElement(By.id("newName")).clear();
			   driver.findElement(By.id("newName")).sendKeys(this.getRandomString(3)+"����");
			   driver.findElement(By.id("discountrate")).clear();
			   driver.findElement(By.id("discountrate")).sendKeys("85");
			   driver.switchTo().defaultContent();
			   driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			   Thread.sleep(1000);
		  }
		  //�ͻ������޸�
		  public void testModifyClientlevel() throws Exception{
			   driver.findElement(By.linkText("�ͻ�")).click();
			   Thread.sleep(1000);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
			   driver.findElement(By.linkText("�ͻ���������")).click();
			   driver.findElement(By.linkText("�޸�")).click();
			   driver.switchTo().frame(0);
			   driver.findElement(By.id("newName")).clear();
			   driver.findElement(By.id("newName")).sendKeys("�޸�"+this.getRandomString(3));
			   driver.findElement(By.id("discountrate")).clear();
			   driver.findElement(By.id("discountrate")).sendKeys("82");
			   driver.switchTo().defaultContent();
			   driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
			   Thread.sleep(1000);
		  }
		  //ɾ���ͻ�����
		  public void testDeleteClientlevel() throws Exception{
			  driver.findElement(By.linkText("�ͻ�")).click();
			  Thread.sleep(1000);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
			  driver.findElement(By.linkText("�ͻ���������")).click();
		      driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody[2]/tr[1]/td[3]/span/a[2]")).click();
		      driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();	      
		      Thread.sleep(1000);
		  }
		  //�ͻ������ö�
		  public void testTopClientlevel() throws Exception{
			  driver.findElement(By.linkText("�ͻ�")).click();
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
			  driver.findElement(By.linkText("�ͻ���������")).click();
		      driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody[2]/tr[1]/td[3]/span/a[3]")).click(); 
		      Thread.sleep(1000);
		  }
		  //�ͻ�������Ϣ�鿴
		  public void testSeeClientMessage() throws Exception{
			  driver.findElement(By.linkText("�ͻ�")).click();
			  Thread.sleep(1000);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");			  
			  driver.findElement(By.linkText("������Ϣ")).click();
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
		  }
		  //����/ɾ����������(�����������������µ�������������)
		  public void testAddArea() throws Exception{
			  driver.findElement(By.linkText("�ͻ�")).click();
			  Thread.sleep(1000);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");			  
			  driver.findElement(By.linkText("������������")).click();
			  driver.findElement(By.className("icon-plus")).click();
			  driver.findElement(By.name("typeName")).clear();
			  driver.findElement(By.name("typeName")).sendKeys("��������");
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.cssSelector("#typeManage > div:nth-child(1) > span > a.deleteType")).click();
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  Thread.sleep(1000);
		  }
		  //�����ͻ�
		  public  void testAddClient() throws Exception{
			    driver.findElement(By.linkText("�ͻ�")).click();
			    driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.id("name")).clear();
			    driver.findElement(By.id("name")).sendKeys(this.getRandomString(4)+"�ͻ�");
			    driver.findElement(By.id("code")).clear();
			    driver.findElement(By.id("code")).sendKeys(this.getRandomString(8));
			    driver.findElement(By.name("countryName")).click();
			    driver.findElement(By.cssSelector("div.list-item.on")).click();//�й�
			    driver.findElement(By.xpath("//div[@id='sel-city']/div[2]/div/div[3]/span/i")).click();
			    driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[3]/div/div[14]")).click();//����  
			    driver.findElement(By.xpath("//div[@id='sel-city']/div[2]/div/div[4]/span/i")).click();
			    driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[4]/div/div[11]")).click();//����
			    driver.findElement(By.xpath("//div[@id='sel-city']/div[2]/div/div[5]/span/i")).click();
			    driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[5]/div/div[9]")).click();//۶�� 
			    driver.findElement(By.id("address")).clear();
			    driver.findElement(By.id("address")).sendKeys("�Ͷս����ɸ���66��");
			    driver.findElement(By.xpath("//*[@id='customRegion']/i")).click();
			    driver.findElement(By.xpath("//*[@id='form1']/div[1]/div/div[1]/div[5]/div[2]/div/div/div[1]")).click();
			    driver.findElement(By.name("zipcode")).clear();
			    driver.findElement(By.name("zipcode")).sendKeys("333119");
			    driver.findElement(By.name("phone")).clear();
			    driver.findElement(By.name("phone")).sendKeys("18607099149");
			    driver.findElement(By.xpath("//*[@id='customerTypeName']/i")).click();
			    driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[6]/div[1]/div[2]")).click();//��ͨ�ͻ�����λ�ڵڶ���
			    driver.findElement(By.id("contactor")).clear();
			    driver.findElement(By.id("contactor")).sendKeys("����");
			    driver.findElement(By.name("position")).clear();
			    driver.findElement(By.name("position")).sendKeys("���Թ���ʦ");
			    driver.findElement(By.id("mobileNum")).clear();
			    driver.findElement(By.id("mobileNum")).sendKeys("18607099149");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("164553538@qq.com");
			    driver.findElement(By.name("qq")).clear();
			    driver.findElement(By.name("qq")).sendKeys("164553538");
			    driver.findElement(By.id("activeCustomer")).click();
			    driver.findElement(By.id("userName")).clear();
			    driver.findElement(By.id("userName")).sendKeys("cskh"+this.getRandomString(4));
			    driver.findElement(By.id("password")).clear();
			    driver.findElement(By.id("password")).sendKeys("123456");
			    driver.findElement(By.id("confirmpwd")).clear();
			    driver.findElement(By.id("confirmpwd")).sendKeys("123456");
			    driver.findElement(By.id("bank")).clear();
			    driver.findElement(By.id("bank")).sendKeys("�������в���֧��");
			    driver.findElement(By.id("bankAccount")).clear();
			    driver.findElement(By.id("bankAccount")).sendKeys("555555555555666");
			    driver.findElement(By.id("taxNum")).clear();
			    driver.findElement(By.id("taxNum")).sendKeys("78977");   
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//*[@id='form1']/div[2]/button[1]")).click();
			    Thread.sleep(2000);
		  }
		 //�޸Ŀͻ�
		  public  void testModifyClient() throws Exception{
			    driver.findElement(By.linkText("�ͻ�")).click();
			    driver.findElement(By.linkText("�޸�")).click();
			    this.switchToWindow("�޸Ŀͻ�", driver);
			    driver.findElement(By.id("name")).clear();
			    driver.findElement(By.id("name")).sendKeys("�����޸Ĵ�����");
			    driver.findElement(By.id("code")).clear();
			    driver.findElement(By.id("code")).sendKeys("haha4455");
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//*[@id='form1']/div[2]/button[1]")).click();
			    Thread.sleep(2000);
			    }
		  
		 //ɾ���ͻ�
		 public void testDeleteClient() throws Exception{
			 driver.findElement(By.linkText("�ͻ�")).click();
			 driver.findElement(By.linkText("ɾ��")).click();
			 driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			 Thread.sleep(2000);
		 } 
		  //����֪ͨ����
		 public void testAddNotifyClass() throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
			  driver.findElement(By.linkText("֪ͨ�������")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div/a")).click();
			  driver.switchTo().frame(0);
			  driver.findElement(By.id("noticeTypeName")).clear();
			  driver.findElement(By.id("noticeTypeName")).sendKeys("����"+this.getRandomString(4));
			  driver.switchTo().defaultContent();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  Thread.sleep(3000);
		 }
		 //֪ͨ�ö�
		 public void testTopNotifyClass()throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  Thread.sleep(1000);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");			  
			  driver.findElement(By.linkText("֪ͨ�������")).click();
			  //���������ö����Σ��ظ���ʼ˳��
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[3]")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[3]")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[3]")).click();//�ö�����������
			  Thread.sleep(2000);
		 }
		 //֪ͨ�޸�(�޸ĵ���������)
		 public void testModifyNotifyClass()throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");			  
			  driver.findElement(By.linkText("֪ͨ�������")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[1]")).click();
			  driver.switchTo().frame(0);
			  driver.findElement(By.id("noticeTypeName")).clear();
			  driver.findElement(By.id("noticeTypeName")).sendKeys("�޸�֪ͨ����");
			  driver.switchTo().defaultContent();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  Thread.sleep(3000);
		 }
		 //ɾ��֪ͨ����(ɾ������������)
		 public void testDeleteNotifyClass() throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  Thread.sleep(1000);
			  js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");			  
			  driver.findElement(By.linkText("֪ͨ�������")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[2]")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  Thread.sleep(2000);
		 }
		 //����֪ͨ����(���ı�����)
		 public void testNewNotify() throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[1]/a")).click();
			  driver.findElement(By.id("title")).clear();
			  driver.findElement(By.id("title")).sendKeys("����֪ͨ"+this.getRandomString(3));			  
			  driver.findElement(By.xpath("//*[@id='noticeTypeCombo']/span")).click();
			  driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[3]/div[1]/div[1]")).click();
			  driver.switchTo().frame("ueditor_0");
			  driver.findElement(By.xpath("/html/body")).clear();
			  driver.findElement(By.xpath("/html/body")).sendKeys(this.getDate()+"\t  ����֪ͨ���������\n    \t"+this.getRandomString(115));
			  driver.switchTo().defaultContent();
			  driver.findElement(By.xpath("//*[@id='myForm']/div[1]/div[2]/div/div[5]/div[2]/label[1]")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div[1]/div[2]/div/div[5]/div[2]/label[2]")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id='myForm']/div[2]/button[1]")).click();
			  Thread.sleep(2000);
		 }
		 //ɾ��֪ͨ
		 public void testDeleteNotify() throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[5]/a[2]")).click();
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  Thread.sleep(2000);
		 }
		 //����˶�����������
		 public void testMakeNotify()throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();		 
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[1]/a")).click();//�鿴����
			  Thread.sleep(2000);
			  driver.findElement(By.linkText("����")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[4]/a")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();//�鿴�Ѷ�
			  Thread.sleep(2000);
		 }
		 //�����˶����鿴����
		 public void testAgentMakeNotify()throws Exception{
			  driver.findElement(By.linkText("֪ͨ")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();//�鿴����
			  Thread.sleep(2000);
			  driver.findElement(By.linkText("����")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/label")).click();
			  driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tfoot/tr/td[1]/label/input")).click();
			  driver.findElement(By.linkText("��Ϊ�Ѷ�")).click();
			  driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			  driver.findElement(By.linkText("֪ͨ")).click();
			  Thread.sleep(1000);
		 }
		 //�������������ύ������������в�����
		 public void testAgentToAdminSuggest(int i) throws Exception{//�������ò�����Ϊ���������״ε�½�����ٴε�¼�����İ���Ϣ�͵���ϵͳ����
			  if(i==0){
				this.login("ku123456", "123456");  
				this.closeBoundMessage();
				this.closeSystemInform();
			  }
			  if(i==1){
				  this.login("autotest1", "123456");  
				  this.closeBoundMessage();
			  }
			  if(i==3){
					this.login("ku123456", "123456");  
				  }
			  if(i==4){
				  this.login("autotest1", "123456");  				
			  }
				driver.findElement(By.linkText("����")).click();
				driver.findElement(By.name("sendContentYdh")).clear();
				driver.findElement(By.name("sendContentYdh")).sendKeys(this.getDate()+"�Զ������Է������������������"+this.getRandomString(24));
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[1]/a")).click();
				this.logout2();
				if(i==0||i==3)
				this.login("310007707", "123456");  
				if(i==1||i==4)
			    this.login("310021564", "123456"); 
				driver.findElement(By.linkText("֪ͨ")).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");			  
				driver.findElement(By.linkText("�ͻ�����")).click();
				driver.findElement(By.linkText("�����ظ�")).click();
				driver.findElement(By.name("replyContent")).clear();
				driver.findElement(By.name("replyContent")).sendKeys(this.getDate()+"����˻ظ��������������������������"+this.getRandomString(26));
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[1]/dd/div[2]/button")).click();
				Thread.sleep(2000);
				this.logout();
				if(i==0||i==3){
					this.login("ku123456", "123456");  
					//this.closeBoundMessage();
					//this.closeSystemInform();
				 }		
				 if(i==1||i==4){
					  this.login("autotest1", "123456");  
					 // this.closeBoundMessage();
				 }
				 driver.findElement(By.linkText("����")).click();
				 driver.findElement(By.linkText("δ�������������")).click();
				 driver.findElement(By.name("replyContent")).clear();
				 driver.findElement(By.name("replyContent")).sendKeys(this.getDate()+"�����������˼������ʡ������������� ");
				 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/dd/div[2]/button")).click();
				 this.logout2();
				 if(i==0||i==3)
				 this.login("310007707", "123456");  
	    		 if(i==1||i==4)
			     this.login("310021564", "123456"); 
				 driver.findElement(By.linkText("֪ͨ")).click();
				 js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");			  
				 driver.findElement(By.linkText("�ͻ�����")).click();
				 driver.findElement(By.linkText("�����ظ�")).click();
				 driver.findElement(By.name("replyContent")).clear();
				 driver.findElement(By.name("replyContent")).sendKeys(this.getDate()+"������ٴλظ������˼������ʷ������������������");
				 driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[1]/dd/div[2]/button")).click();
				 Thread.sleep(2000);
				 this.logout();
				 if(i==0||i==3){
						this.login("ku123456", "123456");  
						//this.closeBoundMessage();
						//this.closeSystemInform();
					 }
				if(i==1||i==4){
						  this.login("autotest1", "123456");  
						 // this.closeBoundMessage();
					 }
				driver.findElement(By.linkText("����")).click();
			    driver.findElement(By.linkText("�ѽ��")).click();
			    Thread.sleep(5000);
		}
		 //�����ɾ�������˷������
		 public void testDeleteSuggest()throws Exception{
			 driver.findElement(By.linkText("֪ͨ")).click();
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 Thread.sleep(1000);
			 js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");			  
			 driver.findElement(By.linkText("�ͻ�����")).click();
			 driver.findElement(By.linkText("ɾ��")).click();
			 driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
			 Thread.sleep(2000);
			 
		 }	 
		 //�������ҿ��ϵͳ�������
		 public void testToSystemSuggest()throws Exception{
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    Thread.sleep(1000);
			js.executeScript("$('.container','.headerService').show()");
		    Thread.sleep(1000);	  
		    driver.findElement(By.linkText("�������")).click();
		    driver.findElement(By.name("sendContent")).clear();
		    driver.findElement(By.name("sendContent")).sendKeys(this.getDate()+"�������ҿ��ϵͳ����������ԡ�����");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/button")).click();
			Thread.sleep(2000);		 
		 }	
		 //��������ҿ��ϵͳ�������
		 public void testAgentToSystemSuggest()throws Exception{
			driver.findElement(By.linkText("����")).click();
			driver.findElement(By.linkText("��Ҫ����")).click();
		    driver.findElement(By.name("sendContentAdmin")).clear();
			driver.findElement(By.name("sendContentAdmin")).sendKeys(this.getDate()+"��������ҿ��ϵͳ����������ԡ�����������\n"+this.getRandomString(24));
		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
			Thread.sleep(2000);
		 }
		 
		 
		  //�رյ������ֻ�������ʾ
		  public void  closeBoundMessage(){
			  driver.findElement(By.linkText("ȡ��")).click();			  
		  }
		  //�ر�ϵͳ֪ͨ
		  public void  closeSystemInform(){
			  driver.findElement(By.linkText("��")).click();			  
		  }
		  //�������һ���ַ�������Ҫ��������һЩ����ʱ ʹ�ã�
			public  String getRandomString(int length) {
				StringBuffer buffer = new StringBuffer(
						"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
				StringBuffer sb = new StringBuffer();
				Random random = new Random();
				int range = buffer.length();
				for (int i = 0; i < length; i++) {
					sb.append(buffer.charAt(random.nextInt(range)));
				}
				return sb.toString();
	    	}	
		  //��ȡ��ǰʱ��
	      public String getDate(){
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy��MM��dd��    HH:mm:ss");//����ʱ���ʽ
				String time=format.format(date);
				return time;
			}
		  //����˵��������ҳ���ϵ�Ԫ�أ����ײ�Ҫʹ�û��Ӱ��Ч�ʣ�ʹ�÷���     isElementPresent(By.xpath(String))
		  private boolean isElementPresent(By by) {
				try {
					driver.findElement(by);
					return true;
				} catch (NoSuchElementException e) {
					return false;
				}
			}
		  private boolean isAlertPresent() {
			    try {
			      driver.switchTo().alert();
			      return true;
			    } catch (NoAlertPresentException e) {
			      return false;
			    }
			  }

		private String closeAlertAndGetItsText() {
			    try {
			      Alert alert = driver.switchTo().alert();
			      String alertText = alert.getText();
			      if (acceptNextAlert) {
			        alert.accept();
			      } else {
			        alert.dismiss();
			      }
			      return alertText;
			    } finally {
			      acceptNextAlert = true;
			    }
			  }
}
