package com.xiaoke.accountsoft.activity;

import com.xiaoke.accountsoft.dao.PwdDAO;
import com.xiaoke.accountsoft.model.Tb_pwd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sysset extends Activity {
	EditText txtpwd;// ����EditText����
	Button btnSet, btnsetCancel;// ��������Button����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sysset);// ���ò����ļ�

		txtpwd = (EditText) findViewById(R.id.txtPwd);// ��ȡ�����ı���
		btnSet = (Button) findViewById(R.id.btnSet);// ��ȡ���ð�ť
		btnsetCancel = (Button) findViewById(R.id.btnsetCancel);// ��ȡȡ����ť

		btnSet.setOnClickListener(new OnClickListener() {// Ϊ���ð�ť��Ӽ����¼�
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO pwdDAO = new PwdDAO(Sysset.this);// ����PwdDAO����
				Tb_pwd tb_pwd = new Tb_pwd(txtpwd.getText().toString());// ������������봴��Tb_pwd����
				if (pwdDAO.getCount() == 0) {// �ж����ݿ����Ƿ��Ѿ�����������
					pwdDAO.add(tb_pwd);// ����û�����
				} else {
					pwdDAO.update(tb_pwd);// �޸��û�����
				}
				// ������Ϣ��ʾ
				Toast.makeText(Sysset.this, "�����롽���óɹ���", Toast.LENGTH_SHORT)
						.show();
			}
		});

		btnsetCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtpwd.setText("");// ��������ı���
				txtpwd.setHint("����������");// Ϊ�����ı���������ʾ
			}
		});
	}
}
