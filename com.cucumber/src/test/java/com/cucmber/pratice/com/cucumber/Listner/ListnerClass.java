package com.cucmber.pratice.com.cucumber.Listner;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import com.cucumber.PageObject.BaseClass;
import com.cucumber.PageObject.ParentBase;

import io.github.qsy7.file.api.service.FileUtil;

public class ListnerClass extends ParentBase implements ITestListener{
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("your tc is pass, genrate the report");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		 WebDriver driver=new ChromeDriver(); 
		System.out.println(result);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("D:\\Automation\\ss\\soss.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 WebDriver driver=new ChromeDriver(); 
		driver.close();
		
	}
	@AfterTest
	public void closeall()
	{
		WebDriver driver= new ChromeDriver();
		driver.quit();
	}

}
