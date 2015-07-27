package com.example.percentlayout.demo;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.percentlayout.R;

/**
 * ����ListView�����뽫item�����ĸ߶�����Ϊ�̶�ֵ�� û�а취ʹ�ðٷֱȣ���Ϊ�丸�ؼ���ListView������Percentϵ��������
 * ��Item�ڲ��Ŀؼ�������ʹ��percentϵ�����ԣ�
 */
public class ListViewTestActivity extends Activity {
	private ListView mListView;
	private LayoutInflater mInflater;

	private List<String> mStr = Arrays.asList("Helloworld", "��Ĺ�ʼ�", "��ʱ����",
			"������", "�绤��");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_test);

		mInflater = LayoutInflater.from(this);

		mListView = (ListView) findViewById(R.id.id_listview);
		mListView.setAdapter(new ArrayAdapter<String>(this, -1, mStr) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView == null) {
					convertView = mInflater.inflate(R.layout.item_music_list,
							parent, false);
				}

				TextView tv = (TextView) convertView
						.findViewById(R.id.id_tv_name);
				tv.setText(mStr.get(position));
				return convertView;
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_list_view_test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
