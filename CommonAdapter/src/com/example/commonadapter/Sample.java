package com.example.commonadapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mygarden.adapter.ListViewDataAdapter;
import com.mygarden.adapter.ViewHolderBase;
import com.mygarden.adapter.ViewHolderCreater;

public class Sample extends Activity {

	private ListView mListView;
	private ListViewDataAdapter<String> mAdapter;
	private List<String> mDataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mListView = new ListView(this);
		mAdapter = new ListViewDataAdapter<String>(new ViewHolderCreater<String>() {

			@Override
			public ViewHolderBase<String> createViewHolder() {
				return new MyViewHolder();
			}
		});

		mDataList = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			mDataList.add(String.valueOf(i));
		}
		mAdapter.getDataList().addAll(mDataList);
		mListView.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}

	private class MyViewHolder extends ViewHolderBase<String> {

		private TextView txtView;
		private ImageView imgView;

		@Override
		public View createView(LayoutInflater inflater) {
			View inflate = inflater.inflate(R.layout.adapter, null);
			txtView = (TextView) inflate.findViewById(R.id.txtView);
			imgView = (ImageView) inflate.findViewById(R.id.imgView);
			return inflate;
		}

		@Override
		public void showData(int position, String data) {
			txtView.setText(data);
			imgView.setImageResource(R.drawable.ic_launcher);
		}

	}
}
