package com.mygarden.adapter;

import android.view.LayoutInflater;
import android.view.View;

public abstract class ViewHolderBase<ItemDataType> {

	protected int mLastPosition;
	protected int mPosition = -1;

	public abstract View createView(LayoutInflater inflater);

	public abstract void showData(int position, ItemDataType data);

	public void setItemData(int position) {
		mLastPosition = mPosition;
		mPosition = position;
	}

	public boolean stillHoldLastItemData() {
		return mLastPosition == mPosition;
	}
}
