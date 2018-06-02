package com.techtransformers.lostnfound.constants;

public interface LostAndFoundQueries {

	String TABLENAME = "lostandfound";
	
	/*String LOST_FOUND_ITEM_QUERY = "SELECT id, createdon, category, name,"
				+ " email, attachment, description, "
				+ "lostrcvdate FROM" + LostAndFoundConstants.SPACE + TABLENAME;*/
	
	String LOST_FOUND_ITEM_QUERY = "SELECT id, createdon, category, name,"
			+ " email, attachment, description, "
			+ "lostrcvdate FROM" + LostAndFoundConstants.SPACE + TABLENAME
			+ LostAndFoundConstants.SPACE + "WHERE" + LostAndFoundConstants.SPACE +
			"category = ? AND lostrcvdate between date_sub(now(),INTERVAL 1 WEEK) and now()";
	 
}


