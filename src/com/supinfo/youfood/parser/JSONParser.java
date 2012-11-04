package com.supinfo.youfood.parser;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.supinfo.youfood.entity.Menu;
import com.supinfo.youfood.entity.Meal;
import com.supinfo.youfood.entity.ProductType;

import android.util.Log;

public class JSONParser extends Parser{

	private static final String CONTENT_TYPE = "application/json";

	public static Menu getCurrentMenu()
	{
		JSONObject object = null;
		JSONObject o = null;
		JSONArray array = null;
		int no_meal = 0;
		Menu menu = new Menu();
		ArrayList<Meal> list_meals = new ArrayList<Meal>();
		
		try 
		{
			object = new JSONObject(sendGetRequest(site + JSONParser.res_menu,CONTENT_TYPE));
			
			try
			{
				o = object.getJSONObject("meals").getJSONObject("meal");
				list_meals.add(loadMeals(o));
			}
			catch(JSONException j){
				no_meal++;
				//Log.d("Erreur", j.getMessage());
			}
			
			try
			{
				array = object.getJSONObject("meals").getJSONArray("meal");
				
				for (int i = 0; i < array.length(); i++) 
				{
					o = (JSONObject) array.get(i);
					list_meals.add(loadMeals(o));
				}
			}
			catch(JSONException j){
				no_meal++;
				//Log.d("Erreur", j.getMessage());
			}
			
			if(no_meal != 1)
				menu.setMeals(list_meals);
			else
				menu.setMeals(list_meals);

			menu.setId(object.getInt("@id"));
			menu.setName(new String(object.getString("name").getBytes(),"UTF-8"));
			return menu;
		} 
		catch (Exception e) {
			Log.d("ErreurM", e.getMessage());
			return null;
		}
	}

	private static Meal loadMeals(JSONObject o) throws JSONException, UnsupportedEncodingException {
		int no_type = 0;
		JSONObject object = o;
		JSONArray array = null;
		Meal meal= new Meal();
		ArrayList<ProductType> list_types = new ArrayList<ProductType>();
		
		meal.setId(o.getInt("@id"));
		meal.setName(new String(o.getString("name").getBytes(),"UTF-8"));
		meal.setDescription(new String(o.getString("description").getBytes(),"UTF-8"));
		meal.setAvailable(Boolean.valueOf(o.getString("available")));		
		try
		{
			meal.setPrice(Float.parseFloat(o.getString("price")));
		}
		catch(IllegalArgumentException e)
		{
			meal.setPrice(0);
		}
		
		try
		{
			o = object.getJSONObject("types").getJSONObject("type");
			list_types.add(loadTypes(o));
		}
		catch(JSONException j){
			no_type++;
			//Log.d("Erreur", j.getMessage());
		}
		
		try
		{
			array = object.getJSONObject("types").getJSONArray("type");
			
			for (int i = 0; i < array.length(); i++) 
			{
				o = (JSONObject) array.get(i);
				list_types.add(loadTypes(o));
			}
		}
		catch(JSONException j){
			no_type++;
			//Log.d("Erreur", j.getMessage());
		}
		
		if(no_type != 1)
			meal.setTypes(list_types);
		else
			meal.setTypes(list_types);
		
		return meal;
	}
	
	private static ProductType loadTypes(JSONObject o) throws JSONException, UnsupportedEncodingException {
		ProductType type= new ProductType();
		type.setId(o.getInt("@id"));
		type.setName(new String(o.getString("name").getBytes(),"UTF-8"));
		return type;
	}
	
	/*
	public static ArrayList<Campus> getAllCampus()
	{
		ArrayList<Campus> list = new ArrayList<Campus>();
		JSONObject object = null;
		JSONObject o = null;
		
		try 
		{
			object = new JSONObject(sendGetRequest(site + JSONParser.res_campus,CONTENT_TYPE));
			try
			{
				JSONArray array = object.getJSONArray("campus");
				
				for (int i = 0; i < array.length(); i++) 
				{
					o = (JSONObject) array.get(i);
					list.add(loadCampus(o));
				}
				return list;
			}
			catch(JSONException j){}
			
			try
			{
				o = object.getJSONObject("campus");
				list.add(loadCampus(o));
				return list;
			}
			catch(JSONException j){}
			return null;
			
		} 
		catch (JSONException e) {
			Log.d("Erreur", e.getMessage());
			return null;
		}
	}

	private static Campus loadCampus(JSONObject o) throws JSONException {
		Campus campus = new Campus();
		campus.setId(o.getInt("@id"));
		campus.setName(o.getString("name"));
		return campus;
	}
	
	public static ArrayList<Intervention> getCampusInterventions(Campus campus)
	{
		ArrayList<Intervention> list = new ArrayList<Intervention>();
		JSONObject object = null;
		JSONObject o = null;
		
		try 
		{
			object = new JSONObject(sendGetRequest(site + JSONParser.res_intervention + JSONParser.res_campus + campus.getName(),CONTENT_TYPE));
			
			try
			{
				JSONArray array = object.getJSONArray("intervention");
				
				for (int i = 0; i < array.length(); i++) 
				{
					o = (JSONObject) array.get(i);
					list.add(loadIntervention(o));
				}
				return list;
			}
			catch(JSONException j){}
			
			try
			{
				o = object.getJSONObject("intervention");
				list.add(loadIntervention(o));
				return list;
			}
			catch(JSONException j){}
			
			return null;
		} 
		catch (JSONException e) {
			Log.d("Erreur", e.getMessage());
			return null;
		}
	}

	private static Intervention loadIntervention(JSONObject o)throws JSONException {
		Intervention intervention = new Intervention();
		intervention.setId(o.getInt("@id"));
		intervention.setSubject(o.getString("subject"));
		intervention.setDescription(o.getString("description"));
		intervention.setCampus(new Campus(o.getString("campus")));
		intervention.setBeginDate(Date.valueOf(o.getString("beginDate")));
		intervention.setEndDate(Date.valueOf(o.getString("endDate")));
		return intervention;
	}

	public static Intervention getIntervention(int id)
	{
		JSONObject object = null;
		JSONObject o = null;
		JSONArray array = null;
		int no_mark = 0;
		Intervention intervention = new Intervention();
		ArrayList<Mark> list_marks = new ArrayList<Mark>();
		
		try 
		{
			object = new JSONObject(sendGetRequest(site + JSONParser.res_intervention + id,CONTENT_TYPE));
			
			try
			{
				o = object.getJSONObject("marks").getJSONObject("mark");
				list_marks.add(loadMarks(o));
			}
			catch(JSONException j){
				no_mark++;
				//Log.d("Erreur", j.getMessage());
			}
			
			try
			{
				array = object.getJSONObject("marks").getJSONArray("mark");
				
				for (int i = 0; i < array.length(); i++) 
				{
					o = (JSONObject) array.get(i);
					list_marks.add(loadMarks(o));
				}
			}
			catch(JSONException j){
				no_mark++;
				//Log.d("Erreur", j.getMessage());
			}
			
			if(no_mark != 1)
				intervention.setMarks(null);
			else
				intervention.setMarks(list_marks);

			intervention.setId(object.getInt("@id"));
			intervention.setSubject(object.getString("subject"));
			intervention.setDescription(object.getString("description"));
			intervention.setCampus(new Campus(object.getString("campus")));
			intervention.setBeginDate(Date.valueOf(object.getString("beginDate")));
			intervention.setEndDate(Date.valueOf(object.getString("endDate")));
			return intervention;
		} 
		catch (Exception e) {
			Log.d("Erreur", e.getMessage());
			return null;
		}
	}

	private static Mark loadMarks(JSONObject o) throws JSONException {
		Mark mark = new Mark();
		mark.setId(o.getInt("@id"));
		mark.setIdBooster(o.getInt("idBooster"));
		mark.setComments(o.getString("comments"));
		try
		{
		mark.setSlideNote(Float.parseFloat(o.getString("slideNote")));
		mark.setSpeakerNote(Float.parseFloat(o.getString("speakerNote")));
		}
		catch(IllegalArgumentException e)
		{
			mark.setSlideNote(0);
			mark.setSpeakerNote(0);
		}
		return mark;
	}
	
	public static boolean sendMark(Mark mark)
	{
		StringEntity input = null;
		try 
		{
			input = new StringEntity("{\"comments\":\"" + mark.getComments().replaceAll("\"", "") + "\",\"idBooster\":\"" + mark.getIdBooster() + "\",\"intervention\":\"" + mark.getIntervention().getId() + "\",\"slideNote\":\"" + mark.getSlideNote() + "\",\"speakerNote\":\""+ mark.getSpeakerNote() +"\"}"); 
			input.setContentType(CONTENT_TYPE);
			input.setContentEncoding("UTF-8");
		} 
		catch (UnsupportedEncodingException e) 
		{
			Log.d("Erreur",e.getMessage());
		}
		
		return sendPostRequest(JSONParser.site + JSONParser.res_mark, input,CONTENT_TYPE);
	}
	*/
}
