package com.xiaoke.accountsoft.activity;

import com.xiaoke.accountsoft.dao.PwdDAO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	
	EditText txtlogin;// 创建EditText对象
	Button btnlogin, btnclose;// 创建两个Button对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);// 设置布局文件
		
		txtlogin = (EditText) findViewById(R.id.txtLogin);// 获取密码文本框
		btnlogin = (Button) findViewById(R.id.btnLogin);// 获取登录按钮
		btnclose = (Button) findViewById(R.id.btnClose);// 获取取消按钮

		btnlogin.setOnClickListener(new OnClickListener() {// 为登录按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);// 创建Intent对象
				PwdDAO pwdDAO = new PwdDAO(Login.this);// 创建PwdDAO对象
				// 判断是否有密码及是否输入了密码
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtlogin.getText().toString().isEmpty()) {
					startActivity(intent);// 启动主Activity
				} else {
					// 判断输入的密码是否与数据库中的密码一致
					if (pwdDAO.find().getPassword()
							.equals(txtlogin.getText().toString())) {
						startActivity(intent);// 启动主Activity
					} else {
						// 弹出信息提示
						Toast.makeText(Login.this, "请输入正确的密码！",
								Toast.LENGTH_SHORT).show();
					}
				}
				txtlogin.setText("");// 清空密码文本框
			}
		});

		btnclose.setOnClickListener(new OnClickListener() {// 为取消按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();// 退出当前程序
			}
		});
	}
}
