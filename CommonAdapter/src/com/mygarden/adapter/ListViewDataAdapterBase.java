package com.mygarden.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ListViewDataAdapterBase<ItemDataType> extends BaseAdapter {

	private ViewHolderCreater<ItemDataType> mViewHolderCreater;

	public ListViewDataAdapterBase(ViewHolderCreater<ItemDataType> viewHolder) {
		mViewHolderCreater = viewHolder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ItemDataType itemData = getItem(position);
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			ViewHolderBase<ItemDataType> viewHolder = mViewHolderCreater.createViewHolder();
			if (viewHolder != null) {
				convertView = viewHolder.createView(inflater);
				if (convertView != null) {
					viewHolder.setItemData(position);
					viewHolder.showData(position, itemData);
					convertView.setTag(viewHolder);
				}
			}
		} else {
			ViewHolderBase<ItemDataType> viewHolder = (ViewHolderBase<ItemDataType>) convertView.getTag();
			if (viewHolder != null) {
				viewHolder.setItemData(position);
				viewHolder.showData(position, itemData);
			}
		}
		return convertView;
	}

	public abstract ItemDataType getItem(int position);
}
