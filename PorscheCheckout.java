package com.cybertek.PorscheCheckout;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PorscheCheckout {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://www.porsche.com/usa/modelstart/");
    driver.findElement(By.className("b-teaser-preview-wrapper")).click();
    
    String price1=driver.findElement(By.className("m-14-model-price")).getText();
    System.out.println(price1);
    
    String digitPrice="";
    for(int i=0; i<price1.length(); i++) {
      if(Character.isDigit(price1.charAt(i))) {
        digitPrice+=price1.charAt(i);
      }else {
        continue;
      }
    }
    int intPrice1=Integer.parseInt(digitPrice);
    System.out.println(intPrice1);
    
    
    String url2 = "https://cc.porsche.com/icc_pcna/ccCall.do?rt=1529369157&screen=1440x900&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f";
    driver.get(url2);
    
    String basePrice=driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText() + "00";
    System.out.println(basePrice);
    
    String digitPrice2="";
    for(int i=0; i<basePrice.length(); i++) {
      if(Character.isDigit(basePrice.charAt(i))) {
        digitPrice2+=basePrice.charAt(i);
      }else {
        continue;
      }
    }
    int intPrice2=Integer.parseInt(digitPrice2);
    System.out.println(intPrice2);
    
    if(intPrice1 == intPrice2) {
      System.out.println(true);
    }else {
      System.out.println(false);
    }
    

  }

}