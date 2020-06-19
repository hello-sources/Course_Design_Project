package com.xiaoke.accountsoft.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoke.accountsoft.model.*;

public class InaccountDAO {
	private DBOpenHelper helper;// ����DBOpenHelper����
	private SQLiteDatabase db;// ����SQLiteDatabase����

	public InaccountDAO(Context context)// ���幹�캯��
	{
		helper = new DBOpenHelper(context);// ��ʼ��DBOpenHelper����
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param tb_inaccount
	 */
	public void add(Tb_inaccount tb_inaccount) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ִ�����������Ϣ����
		db.execSQL(
				"insert into tb_inaccount (_id,money,time,type,handler,mark) values (?,?,?,?,?,?)",
				new Object[] { tb_inaccount.getid(), tb_inaccount.getMoney(),
						tb_inaccount.getTime(), tb_inaccount.getType(),
						tb_inaccount.getHandler(), tb_inaccount.getMark() });
	}

	/**
	 * ����������Ϣ
	 * 
	 * @param tb_inaccount
	 */
	public void update(Tb_inaccount tb_inaccount) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ִ���޸�������Ϣ����
		db.execSQL(
				"update tb_inaccount set money = ?,time = ?,type = ?,handler = ?,mark = ? where _id = ?",
				new Object[] { tb_inaccount.getMoney(), tb_inaccount.getTime(),
						tb_inaccount.getType(), tb_inaccount.getHandler(),
						tb_inaccount.getMark(), tb_inaccount.getid() });
	}

	/**
	 * ����������Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public Tb_inaccount find(int id) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		Cursor cursor = db
				.rawQuery(
						"select _id,money,time,type,handler,mark from tb_inaccount where _id = ?",
						new String[] { String.valueOf(id) });// ���ݱ�Ų���������Ϣ�����洢��Cursor����
		if (cursor.moveToNext())// �������ҵ���������Ϣ
		{
			// ����������������Ϣ�洢��Tb_inaccount����
			return new Tb_inaccount(
					cursor.getInt(cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("handler")),
					cursor.getString(cursor.getColumnIndex("mark")));
		}
		return null;// ���û����Ϣ���򷵻�null
	}

	/**
	 * �h��������Ϣ
	 * 
	 * @param ids
	 */
	public void detele(Integer... ids) {
		if (ids.length > 0)// �ж��Ƿ����Ҫɾ����id
		{
			StringBuffer sb = new StringBuffer();// ����StringBuffer����
			for (int i = 0; i < ids.length; i++)// ����Ҫɾ����id����
			{
				sb.append('?').append(',');// ��ɾ��������ӵ�StringBuffer������
			}
			sb.deleteCharAt(sb.length() - 1);// ȥ�����һ����,���ַ�
			db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
			// ִ��ɾ��������Ϣ����
			db.execSQL("delete from tb_inaccount where _id in (" + sb + ")",
					(Object[]) ids);
		}
	}

	/**
	 * ��ȡ������Ϣ
	 * 
	 * @param start
	 *            ��ʼλ��
	 * @param count
	 *            ÿҳ��ʾ����
	 * @return
	 */
	public List<Tb_inaccount> getScrollData(int start, int count) {
		List<Tb_inaccount> tb_inaccount = new ArrayList<Tb_inaccount>();// �������϶���
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ��ȡ����������Ϣ
		Cursor cursor = db.rawQuery("select * from tb_inaccount limit ?,?",
				new String[] { String.valueOf(start), String.valueOf(count) });
		while (cursor.moveToNext())// �������е�������Ϣ
		{
			// ����������������Ϣ��ӵ�������
			tb_inaccount.add(new Tb_inaccount(cursor.getInt(cursor
					.getColumnIndex("_id")), cursor.getDouble(cursor
					.getColumnIndex("money")), cursor.getString(cursor
					.getColumnIndex("time")), cursor.getString(cursor
					.getColumnIndex("type")), cursor.getString(cursor
					.getColumnIndex("handler")), cursor.getString(cursor
					.getColumnIndex("mark"))));
		}
		return tb_inaccount;// ���ؼ���
	}

	/**
	 * ��ȡ�ܼ�¼��
	 * 
	 * @return
	 */
	public long getCount() {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		Cursor cursor = db
				.rawQuery("select count(_id) from tb_inaccount", null);// ��ȡ������Ϣ�ļ�¼��
		if (cursor.moveToNext())// �ж�Cursor���Ƿ�������
		{
			return cursor.getLong(0);// �����ܼ�¼��
		}
		return 0;// ���û�����ݣ��򷵻�0
	}

	/**
	 * ��ȡ���������
	 * 
	 * @return
	 */
	public int getMaxId() {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		Cursor cursor = db.rawQuery("select max(_id) from tb_inaccount", null);// ��ȡ������Ϣ���е������
		while (cursor.moveToLast()) {// ����Cursor�е����һ������
			return cursor.getInt(0);// ��ȡ���ʵ������ݣ��������
		}
		return 0;// ���û�����ݣ��򷵻�0
	}
}
