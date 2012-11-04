package com.supinfo.youfood.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.supinfo.youfood.activity.R;
import com.supinfo.youfood.entity.Meal;
import com.supinfo.youfood.entity.ProductType;

public class MealListAdapter extends BaseAdapter {

	private Context context = null;
	private List<Meal> meals = null;
	private LayoutInflater mInflater = null;

	public MealListAdapter(Context context,
			List<Meal> meals) {
		super();
		this.context = context;
		this.meals = meals;
		mInflater = LayoutInflater.from(this.context);
	}

	public int getCount() {
		return this.meals.size();
	}

	public Meal getItem(int position) {
		return meals.get(position);
	}

	public long getItemId(int position) {
		return getItem(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LinearLayout layoutItem;
		if (convertView == null) 
			layoutItem = (LinearLayout) mInflater.inflate(R.layout.itemtemplate, parent, false);
		else
			layoutItem = (LinearLayout) convertView;

		TextView name = (TextView) layoutItem.findViewById(R.id.item_name);
		TextView price = (TextView) layoutItem.findViewById(R.id.item_price);
		TextView type = (TextView) layoutItem.findViewById(R.id.item_type);
		name.setTextColor(Color.WHITE);
		price.setTextColor(Color.WHITE);
		type.setTextColor(Color.WHITE);

		name.setText(this.meals.get(position).getName());
		price.setText("Price : " + String.valueOf(this.meals.get(position).getPrice()));
		
		String types = "";
		for(ProductType t : this.meals.get(position).getTypes())
		{
			if(types == "")
				t.getName();
			else
				types += ", " + t.getName();
		}
		
		if(types == "")
			type.setText("Type : " + types);
		else
			type.setText("Pas de type précis");

		if (position % 2 == 0)
			layoutItem.setBackgroundColor(Color.DKGRAY);
		else
			layoutItem.setBackgroundColor(Color.BLACK);
		
		return layoutItem;
	}
}
