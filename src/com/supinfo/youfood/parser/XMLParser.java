package com.supinfo.youfood.parser;

import java.util.ArrayList;
import com.supinfo.youfood.entity.Menu;

public class XMLParser extends Parser{

	private static final String CONTENT_TYPE = "application/xml";
	
	public static ArrayList<Menu> getCurrentMenu()
	{
		@SuppressWarnings("unused")
		String s = sendGetRequest(site + JSONParser.res_menu,CONTENT_TYPE);
		
		return null;
	}
}
