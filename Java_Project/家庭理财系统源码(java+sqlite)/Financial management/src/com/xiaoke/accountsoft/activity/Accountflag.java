package com.xiaoke.accountsoft.activity;

import com.xiaoke.accountsoft.dao.FlagDAO;
import com.xiaoke.accountsoft.model.Tb_flag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Accountflag extends Activity {
	EditText txtFlag;// ����EditText�������
	Button btnflagSaveButton;// ����Button�������
	Button btnflagCancelButton;// ����Button�������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accountflag);

		txtFlag = (EditText) findViewById(R.id.txtFlag);// ��ȡ��ǩ�ı���
		btnflagSaveButton = (Button) findViewById(R.id.btnflagSave);// ��ȡ���水ť
		btnflagCancelButton = (Button) findViewById(R.id.btnflagCancel);// ��ȡȡ����ť
		btnflagSaveButton.setOnClickListener(new OnClickListener() {// Ϊ���水ť���ü����¼�
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						String strFlag = txtFlag.getText().toString();// ��ȡ��ǩ�ı����ֵ
						if (!strFlag.isEmpty()) {// �жϻ�ȡ��ֵ��Ϊ��
							FlagDAO flagDAO = new FlagDAO(Accountflag.this);// ����FlagDAO����
							Tb_flag tb_flag = new Tb_flag(
									flagDAO.getMaxId() + 1, strFlag);// ����Tb_flag����
							flagDAO.add(tb_flag);// ��ӱ�ǩ��Ϣ
							// ������Ϣ��ʾ
							Toast.makeText(Accountflag.this, "��������ǩ��������ӳɹ���",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(Accountflag.this, "�������ǩ��",
									Toast.LENGTH_SHORT).show();
						}
					}
				});

		btnflagCancelButton.setOnClickListener(new OnClickListener() {// Ϊȡ����ť���ü����¼�
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						txtFlag.setText("");// ��ձ�ǩ�ı���
					}
				});
	}
}
