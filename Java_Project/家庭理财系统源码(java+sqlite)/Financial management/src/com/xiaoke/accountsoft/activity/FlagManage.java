package com.xiaoke.accountsoft.activity;

import com.xiaoke.accountsoft.dao.FlagDAO;
import com.xiaoke.accountsoft.model.Tb_flag;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FlagManage extends Activity {
	EditText txtFlag;// ����EditText����
	Button btnEdit, btnDel;// ��������Button����
	String strid;// �����ַ�������ʾ��ǩ��id

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flagmanage);// ���ò����ļ�
		txtFlag = (EditText) findViewById(R.id.txtFlagManage);// ��ȡ��ǩ�ı���
		btnEdit = (Button) findViewById(R.id.btnFlagManageEdit);// ��ȡ�޸İ�ť
		btnDel = (Button) findViewById(R.id.btnFlagManageDelete);// ��ȡɾ����ť

		Intent intent = getIntent();// ����Intent����
		Bundle bundle = intent.getExtras();// ��ȡ��ǩid
		strid = bundle.getString(Showinfo.FLAG);// ����ǩidת��Ϊ�ַ���
		final FlagDAO flagDAO = new FlagDAO(FlagManage.this);// ����FlagDAO����
		txtFlag.setText(flagDAO.find(Integer.parseInt(strid)).getFlag());// ���ݱ�ǩid���ұ�ǩ��Ϣ������ʾ���ı�����

		btnEdit.setOnClickListener(new OnClickListener() {// Ϊ�޸İ�ť���ü����¼�
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Tb_flag tb_flag = new Tb_flag();// ����Tb_flag����
				tb_flag.setid(Integer.parseInt(strid));// ���ñ�ǩid
				tb_flag.setFlag(txtFlag.getText().toString());// ���ñ�ǩֵ
				flagDAO.update(tb_flag);// �޸ı�ǩ��Ϣ
				// ������Ϣ��ʾ
				Toast.makeText(FlagManage.this, "����ǩ���ݡ��޸ĳɹ���",
						Toast.LENGTH_SHORT).show();
			}
		});

		btnDel.setOnClickListener(new OnClickListener() {// Ϊɾ����ť���ü����¼�
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				flagDAO.detele(Integer.parseInt(strid));// ����ָ����idɾ����ǩ��Ϣ
				Toast.makeText(FlagManage.this, "����ǩ���ݡ�ɾ���ɹ���",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
