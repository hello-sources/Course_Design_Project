package com.xiaoke.accountsoft.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
 
public class MainActivity extends Activity {
	GridView gvInfo;// ����GridView����
	// �����ַ������飬�洢ϵͳ����
	String[] titles = new String[] { "֧��һ��ͨ", "����һ��ͨ", "֧����һ��", "�����һ��", "Ǯ��Ǯȥ",
			"��ȫ����", "��֧��ǩ", "�˳�" };
	// ����int���飬�洢���ܶ�Ӧ��ͼ��  
	int[] images = new int[] { R.drawable.addoutaccount,
			R.drawable.addinaccount, R.drawable.outaccountinfo,
			R.drawable.inaccountinfo1, R.drawable.showinfo, R.drawable.sysset1,
			R.drawable.accountflag1, R.drawable.exit1 }; 

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		gvInfo = (GridView) findViewById(R.id.gvInfo);// ��ȡ�����ļ��е�gvInfo���
		pictureAdapter adapter = new pictureAdapter(titles, images, this);// ����pictureAdapter����
		gvInfo.setAdapter(adapter);// ΪGridView��������Դ
		gvInfo.setOnItemClickListener(new OnItemClickListener() {// ΪGridView��������¼�
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = null;// ����Intent����
				switch (arg2) {
				case 0:
					intent = new Intent(MainActivity.this, AddOutaccount.class);// ʹ��AddOutaccount���ڳ�ʼ��Intent
					startActivity(intent);// ��AddOutaccount
					break;
				case 1:
					intent = new Intent(MainActivity.this, AddInaccount.class);// ʹ��AddInaccount���ڳ�ʼ��Intent
					startActivity(intent);// ��AddInaccount
					break;
				case 2:
					intent = new Intent(MainActivity.this, Outaccountinfo.class);// ʹ��Outaccountinfo���ڳ�ʼ��Intent
					startActivity(intent);// ��Outaccountinfo
					break;
				case 3:
					intent = new Intent(MainActivity.this, Inaccountinfo.class);// ʹ��Inaccountinfo���ڳ�ʼ��Intent
					startActivity(intent);// ��Inaccountinfo
					break;
				case 4:
					intent = new Intent(MainActivity.this, Showinfo.class);// ʹ��Showinfo���ڳ�ʼ��Intent
					startActivity(intent);// ��Showinfo
					break;
				case 5:
					intent = new Intent(MainActivity.this, Sysset.class);// ʹ��Sysset���ڳ�ʼ��Intent
					startActivity(intent);// ��Sysset
					break;
				case 6:
					intent = new Intent(MainActivity.this, Accountflag.class);// ʹ��Accountflag���ڳ�ʼ��Intent
					startActivity(intent);// ��Accountflag
					break;
				case 7:
					finish();// �رյ�ǰActivity
				}
			}
		});
	}
}

class pictureAdapter extends BaseAdapter// ��������BaseAdapter������
{
	private LayoutInflater inflater;// ����LayoutInflater����
	private List<Picture> pictures;// ����List���ͼ���

	// Ϊ�ഴ�����캯��
	public pictureAdapter(String[] titles, int[] images, Context context) {
		super();
		pictures = new ArrayList<Picture>();// ��ʼ�����ͼ��϶���
		inflater = LayoutInflater.from(context);// ��ʼ��LayoutInflater����
		for (int i = 0; i < images.length; i++)// ����ͼ������
		{
			Picture picture = new Picture(titles[i], images[i]);// ʹ�ñ����ͼ������Picture����
			pictures.add(picture);// ��Picture������ӵ����ͼ�����
		}
	}

	@Override
	public int getCount() {// ��ȡ���ͼ��ϵĳ���
		if (null != pictures) {// ������ͼ��ϲ�Ϊ��
			return pictures.size();// ���ط��ͳ���
		} else {
			return 0;// ����0
		}
	}

	@Override
	public Object getItem(int arg0) {
		return pictures.get(arg0);// ��ȡ���ͼ���ָ������������
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;// ���ط��ͼ��ϵ�����
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder viewHolder;// ����ViewHolder����
		if (arg1 == null)// �ж�ͼ���ʶ�Ƿ�Ϊ��
		{
			arg1 = inflater.inflate(R.layout.gvitem, null);// ����ͼ���ʶ
			viewHolder = new ViewHolder();// ��ʼ��ViewHolder����
			viewHolder.title = (TextView) arg1.findViewById(R.id.ItemTitle);// ����ͼ�����
			viewHolder.image = (ImageView) arg1.findViewById(R.id.ItemImage);// ����ͼ��Ķ�����ֵ
			arg1.setTag(viewHolder);// ������ʾ
		} else {
			viewHolder = (ViewHolder) arg1.getTag();// ������ʾ
		}
		viewHolder.title.setText(pictures.get(arg0).getTitle());// ����ͼ�����
		viewHolder.image.setImageResource(pictures.get(arg0).getImageId());// ����ͼ��Ķ�����ֵ
		return arg1;// ����ͼ���ʶ
	}
}

class ViewHolder// ����ViewHolder��
{
	public TextView title;// ����TextView����
	public ImageView image;// ����ImageView����
}

class Picture// ����Picture��
{
	private String title;// �����ַ�������ʾͼ�����
	private int imageId;// ����int��������ʾͼ��Ķ�����ֵ

	public Picture()// Ĭ�Ϲ��캯��
	{
		super();
	}

	public Picture(String title, int imageId)// �����вι��캯��
	{
		super();
		this.title = title;// Ϊͼ����⸳ֵ
		this.imageId = imageId;// Ϊͼ��Ķ�����ֵ��ֵ
	}

	public String getTitle() {// ����ͼ�����Ŀɶ�����
		return title;
	}

	public void setTitle(String title) {// ����ͼ�����Ŀ�д����
		this.title = title;
	}

	public int getImageId() {// ����ͼ�������ֵ�Ŀɶ�����
		return imageId;
	}

	public void setimageId(int imageId) {// ����ͼ�������ֵ�Ŀ�д����
		this.imageId = imageId;
	}
}