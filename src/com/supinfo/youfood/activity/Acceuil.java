package com.supinfo.youfood.activity;

import java.util.ArrayList;

import com.supinfo.youfood.activity.R;
import com.supinfo.youfood.adapter.MealListAdapter;
import com.supinfo.youfood.parser.JSONParser;
import com.supinfo.youfood.entity.Meal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Acceuil extends Activity {
    
	private ArrayList<Meal> list_meals = new ArrayList<Meal>();
	private MealListAdapter adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.list_meals = (ArrayList<Meal>) JSONParser.getCurrentMenu().getMeals();
        //XMLParser.getAllCampus();
        
        this.adapter = new MealListAdapter(this, this.list_meals);
		ListView listview = (ListView) findViewById(R.id.listViewMeals);
		listview.setAdapter(this.adapter);
		listview.setOnItemClickListener(clickListener);
		
		SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
		Editor edit = prefs.edit();
		edit.putString("meals","");
		edit.commit();
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    	
    	//SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
    	//Toast.makeText( this,"Le panier contient : " + prefs.getString("meals", ""), 400).show();
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_acceuil, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.menu_panier:
        	   startActivity(new Intent(Acceuil.this,Panier.class));
              return true;
           case R.id.menu_retour:
        	   moveTaskToBack(true);
               return true;
           default:
              return false;
        }
    }
    
    private OnItemClickListener clickListener = new OnItemClickListener() 
    {
		public void onItemClick(AdapterView<?> prent, View v, int position,long id) 
		{
			Intent intent = new Intent(Acceuil.this,DetailMeal.class);
			intent.putExtra("theMeal", Acceuil.this.list_meals.get(position));
			startActivity(intent);
		}
	};
}