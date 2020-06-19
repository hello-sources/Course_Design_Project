package com.xiaoke.accountsoft.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoke.accountsoft.model.*;

public class OutaccountDAO {
	private DBOpenHelper helper;// ����DBOpenHelper����
	private SQLiteDatabase db;// ����SQLiteDatabase����

	public OutaccountDAO(Context context)// ���幹�캯��
	{
		helper = new DBOpenHelper(context);// ��ʼ��DBOpenHelper����
	}

	/**
	 * ���֧����Ϣ
	 * 
	 * @param tb_outaccount
	 */
	public void add(Tb_outaccount tb_outaccount) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ִ�����֧����Ϣ����
		db.execSQL(
				"insert into tb_outaccount (_id,money,time,type,address,mark) values (?,?,?,?,?,?)",
				new Object[] { tb_outaccount.getid(), tb_outaccount.getMoney(),
						tb_outaccount.getTime(), tb_outaccount.getType(),
						tb_outaccount.getAddress(), tb_outaccount.getMark() });
	}

	/**
	 * ����֧����Ϣ
	 * 
	 * @param tb_outaccount
	 */
	public void update(Tb_outaccount tb_outaccount) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ִ���޸�֧����Ϣ����
		db.execSQL(
				"update tb_outaccount set money = ?,time = ?,type = ?,address = ?,mark = ? where _id = ?",
				new Object[] { tb_outaccount.getMoney(),
						tb_outaccount.getTime(), tb_outaccount.getType(),
						tb_outaccount.getAddress(), tb_outaccount.getMark(),
						tb_outaccount.getid() });
	}

	/**
	 * ����֧����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public Tb_outaccount find(int id) {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		Cursor cursor = db
				.rawQuery(
						"select _id,money,time,type,address,mark from tb_outaccount where _id = ?",
						new String[] { String.valueOf(id) });// ���ݱ�Ų���֧����Ϣ�����洢��Cursor����
		if (cursor.moveToNext())// �������ҵ���֧����Ϣ
		{
			// ����������֧����Ϣ�洢��Tb_outaccount����
			return new Tb_outaccount(
					cursor.getInt(cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("address")),
					cursor.getString(cursor.getColumnIndex("mark")));
		}
		return null;// ���û����Ϣ���򷵻�null
	}

	/**
	 * �h��֧����Ϣ
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
			// ִ��ɾ��֧����Ϣ����
			db.execSQL("delete from tb_outaccount where _id in (" + sb + ")",
					(Object[]) ids);
		}
	}

	/**
	 * ��ȡ֧����Ϣ
	 * 
	 * @param start
	 *            ��ʼλ��
	 * @param count
	 *            ÿҳ��ʾ����
	 * @return
	 */
	public List<Tb_outaccount> getScrollData(int start, int count) {
		List<Tb_outaccount> tb_outaccount = new ArrayList<Tb_outaccount>();// �������϶���
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		// ��ȡ����֧����Ϣ
		Cursor cursor = db.rawQuery("select * from tb_outaccount limit ?,?",
				new String[] { String.valueOf(start), String.valueOf(count) });
		while (cursor.moveToNext())// �������е�֧����Ϣ
		{
			// ����������֧����Ϣ��ӵ�������
			tb_outaccount.add(new Tb_outaccount(cursor.getInt(cursor
					.getColumnIndex("_id")), cursor.getDouble(cursor
					.getColumnIndex("money")), cursor.getString(cursor
					.getColumnIndex("time")), cursor.getString(cursor
					.getColumnIndex("type")), cursor.getString(cursor
					.getColumnIndex("address")), cursor.getString(cursor
					.getColumnIndex("mark"))));
		}
		return tb_outaccount;// ���ؼ���
	}

	/**
	 * ��ȡ�ܼ�¼��
	 * 
	 * @return
	 */
	public long getCount() {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		Cursor cursor = db.rawQuery("select count(_id) from tb_outaccount",
				null);// ��ȡ֧����Ϣ�ļ�¼��
		if (cursor.moveToNext())// �ж�Cursor���Ƿ�������
		{
			return cursor.getLong(0);// �����ܼ�¼��
		}
		return 0;// ���û�����ݣ��򷵻�0
	}

	/**
	 * ��ȡ֧�������
	 * 
	 * @return
	 */
	public int getMaxId() {
		db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
		Cursor cursor = db.rawQuery("select max(_id) from tb_outaccount", null);// ��ȡ֧����Ϣ���е������
		while (cursor.moveToLast()) {// ����Cursor�е����һ������
			return cursor.getInt(0);// ��ȡ���ʵ������ݣ��������
		}
		return 0;// ���û�����ݣ��򷵻�0
	}
}
