package com.mygarden.adapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewDataAdapter<ItemDataType> extends ListViewDataAdapterBase<ItemDataType> {

	public ListViewDataAdapter(ViewHolderCreater<ItemDataType> viewHolder) {
		super(viewHolder);
	}

	private List<ItemDataType> mItemDataList = new ArrayList<ItemDataType>();

	public List<ItemDataType> getDataList() {
		return mItemDataList;
	}

	@Override
	public int getCount() {
		return mItemDataList == null ? 0 : mItemDataList.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public ItemDataType getItem(int position) {
		if (mItemDataList.size() <= position || position < 0) {
			return null;
		}
		return mItemDataList.get(position);
	}
}
