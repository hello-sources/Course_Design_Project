package com.xiaoke.accountsoft.activity;

import java.util.List;

import com.xiaoke.accountsoft.dao.InaccountDAO;
import com.xiaoke.accountsoft.model.Tb_inaccount;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Inaccountinfo extends Activity {
	public static final String FLAG = "id";// ����һ��������������Ϊ������
	ListView lvinfo;// ����ListView����
	String strType = "";// �����ַ�������¼��������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inaccountinfo);// ���ò����ļ�
		lvinfo = (ListView) findViewById(R.id.lvinaccountinfo);// ��ȡ�����ļ��е�ListView���

		ShowInfo(R.id.btnininfo);// �����Զ��巽����ʾ������Ϣ

		lvinfo.setOnItemClickListener(new OnItemClickListener()// ΪListView�������¼�
		{
			// ��дonItemClick����
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String strInfo = String.valueOf(((TextView) view).getText());// ��¼������Ϣ
				String strid = strInfo.substring(0, strInfo.indexOf('|'));// ��������Ϣ�н�ȡ������
				Intent intent = new Intent(Inaccountinfo.this, InfoManage.class);// ����Intent����
				intent.putExtra(FLAG, new String[] { strid, strType });// ���ô�������
				startActivity(intent);// ִ��Intent����
			}
		});
	}

	private void ShowInfo(int intType) {// �������ݴ���Ĺ������ͣ���ʾ��Ӧ����Ϣ
		String[] strInfos = null;// �����ַ������飬�����洢������Ϣ
		ArrayAdapter<String> arrayAdapter = null;// ����ArrayAdapter����
		strType = "btnininfo";// ΪstrType������ֵ
		InaccountDAO inaccountinfo = new InaccountDAO(Inaccountinfo.this);// ����InaccountDAO����
		// ��ȡ����������Ϣ�����洢��List���ͼ�����
		List<Tb_inaccount> listinfos = inaccountinfo.getScrollData(0,
				(int) inaccountinfo.getCount());
		strInfos = new String[listinfos.size()];// �����ַ�������ĳ���
		int m = 0;// ����һ����ʼ��ʶ
		for (Tb_inaccount tb_inaccount : listinfos) {// ����List���ͼ���
			// �����������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
			strInfos[m] = tb_inaccount.getid() + "|" + tb_inaccount.getType()
					+ " " + String.valueOf(tb_inaccount.getMoney()) + "Ԫ     "
					+ tb_inaccount.getTime();
			m++;// ��ʶ��1
		}
		// ʹ���ַ��������ʼ��ArrayAdapter����
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strInfos);
		lvinfo.setAdapter(arrayAdapter);// ΪListView�б���������Դ
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();// ʵ�ֻ����еķ���
		ShowInfo(R.id.btnininfo);// ��ʾ������Ϣ
	}
}
