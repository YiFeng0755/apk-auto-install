package com.boyaa.stf.uiautomator;

import java.io.File;

import android.graphics.Rect;
import android.os.Build;
import android.os.RemoteException;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AutoInstall extends UiAutomatorTestCase {
	
	public void testDemo(){
		UiDevice uiDevice = getUiDevice();
		try {
			uiDevice.wakeUp();
			System.out.println(uiDevice.getProductName());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int sdk = Build.VERSION.SDK_INT;
		
		
		UiObject uiObject = null;
		while(true){
			
			try{
				if(sdk >= 18){
					uiObject = new UiObject(new UiSelector().resourceIdMatches("com.coloros.safecenter:id/verify_input|com.coloros.safecenter:id/et_login_passwd_edit"));
					
					if(uiObject.exists()){
						System.out.println("search oppo verify input");
						uiDevice.pressBack();
						System.out.println("uiDevice press back");
						uiObject = new UiObject(new UiSelector().resourceIdMatches("com.coloros.safecenter:id/verify_input|com.coloros.safecenter:id/et_login_passwd_edit"));
						
						uiObject.clearTextField();
						
						System.out.println("clear text field");
						uiObject.click();
						System.out.println("click uiObject");
						uiObject = new UiObject(new UiSelector().resourceIdMatches("com.coloros.safecenter:id/verify_input|com.coloros.safecenter:id/et_login_passwd_edit"));
						uiObject.setText("test12345");
						System.out.println("uiObject set text");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("start click button");
						uiObject = new UiObject(new UiSelector().textMatches("安装"));
						if(uiObject.isClickable()){
							System.out.println("click button");
							uiObject.click();
						}
						continue;
						
					}
				}
				
				
				uiObject = new UiObject(new UiSelector().packageNameMatches("com.coloros.safecenter").textMatches("登录"));
				if(uiObject.exists()){
					uiObject.click();
					uiObject = new UiObject(new UiSelector().resourceIdMatches("com.oppo.usercenter:id/edit_input_content"));
					if(uiObject.exists()){
						uiObject.setText("test12345");
						uiObject = new UiObject(new UiSelector().resourceIdMatches("com.oppo.usercenter:id/btn_login"));
						uiObject.click();
					}
					continue;
				}
				
				uiObject = new UiObject(new UiSelector().textMatches("安装|确认|下一步|确定|完成|替换|同意|允许|继续安装|清理|卸载|立即删除|继续|好|接受|删除").className(Button.class));
				
				if(uiObject.exists()){
					boolean isUiObjectClick = uiObject.click();
					System.out.println("uiObject click button :"+isUiObjectClick);
					continue;
				}
				
				uiObject = new UiObject(new UiSelector().textMatches("我已充分了解.*继续安装").className(CheckBox.class));
				if(uiObject.exists()){
					uiObject.click();
					continue;
				}
				
				if(sdk >= 18){
					uiObject = new UiObject(new UiSelector().resourceId("android:id/message").className(TextView.class));
					if(uiObject.exists()){
						uiObject = new UiObject(new UiSelector().resourceId("android:id/button1").className(Button.class));
						if(uiObject.exists()){
							uiObject.click();
							continue;
						}
					}
				}
				
				
				uiObject = new UiObject(new UiSelector().textMatches("安装|确认|下一步|确定|完成|替换|同意|允许|继续安装|清理|卸载|立即删除|稍后|稍后提醒|继续|好|接受|删除"));
				if(uiObject.exists()){
					uiObject.click();
					continue;
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch(UiObjectNotFoundException e1){
				e1.printStackTrace();
			}
			
			
		}
	}
	
}
