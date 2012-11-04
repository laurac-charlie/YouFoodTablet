package com.supinfo.youfood.activity;

import com.supinfo.youfood.entity.Meal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMeal extends Activity {

	private Meal currentMeal = null;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        
        Meal meal = (Meal) this.getIntent().getExtras().get("theMeal");
        this.loadMeal(meal);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_panier, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.menu_panier:
        	   clickListener.onClick(getCurrentFocus());
              return true;
           case R.id.menu_retour:
               finish();
               return true;
           default:
              return false;
        }
    }

	private void loadMeal(Meal meal) {
		TextView name = (TextView) findViewById(R.id.txt_name);
        TextView description = (TextView) findViewById(R.id.txt_description);
        TextView price = (TextView) findViewById(R.id.txt_price);
        
        this.currentMeal = (Meal) meal;
    	if(this.currentMeal != null)
		{
    		name.setText(this.currentMeal.getName());
        	description.setText(this.currentMeal.getDescription());
        	price.setText(String.valueOf(this.currentMeal.getPrice()) + " €");
        	if (this.currentMeal.getTypes() != null && !this.currentMeal.getTypes().isEmpty())
        	{
	        	/*nb_mark.setText(Integer.toString( this.currentMeal.getNumberOfMark()));
	        	speaker_mark.setText(Float.toString(this.currentMeal.getAverageSpeakerNote()));
	        	slide_mark.setText(Float.toString(this.currentMeal.getAverageSlideNote()));
	        	global_mark.setText(Float.toString(this.currentMeal.getAverageMark()));*/
        	}
		}
	}
	
	private OnClickListener clickListener = new OnClickListener() {
		public void onClick(View view) {
			if(DetailMeal.this.currentMeal != null)
			{
				SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
				Editor edit = prefs.edit();
				if(prefs.getString("meals", "") == "")
					edit.putString("meals",String.valueOf(DetailMeal.this.currentMeal.getId()));
				else
					edit.putString("meals", prefs.getString("meals", "") + "&" + String.valueOf(DetailMeal.this.currentMeal.getId()));
				edit.commit();
				
				/*String s = "";
				for(String g : prefs.getString("meals", "").split("&"))
					s += g + " et ";*/
				
				Toast.makeText(DetailMeal.this,"Vous avez ajouter le plat : " + DetailMeal.this.currentMeal.getName() + " à votre panier." , 400).show();
				finish();
			}
			else
			{
				Toast.makeText(DetailMeal.this, "Aucun plat chargé.", 400).show();
			}
		}
	};

	/*
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case ACTIVITY_CODE:
			switch (resultCode) {
			case RESULT_CANCELED:
				Toast.makeText(this, "La notation a été annulé.", 400).show();
				break;
			case RESULT_OK:
				if(data.getExtras().getBoolean("markSent"))
				{
					Toast.makeText(this, "Votre notation a bien été pris en compte.", 400).show();
					loadIntervention(data.getExtras());
				}
				else
				{
					Toast t = Toast.makeText(this, "La note n'a pas pu être envoyé.", 400);
					t.show();
				}
				break;
			default:
				break;
			}
		default:
			break;
		}
	}*/

}
