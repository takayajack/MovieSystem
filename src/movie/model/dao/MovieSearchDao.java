package movie.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import movie.beans.MovieListBeans;

public class MovieSearchDao extends DaoBase {


	public List<MovieListBeans> getKeywordSearch(String sitem) {

		if( con == null){
			//謗･邯壹＠縺ｦ縺・↑縺・ｴ蜷医・繧ｨ繝ｩ繝ｼ縺ｨ縺吶ｋ
			return null;
		}

		List<MovieListBeans> list = new ArrayList<MovieListBeans>();

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("select * from movie where movie_name like ?");
			stmt.setString(1,"%"+sitem+"%");
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();

			while( rs.next() ){

				MovieListBeans movieList = new MovieListBeans();


				movieList.setTitle(rs.getString("movie_name"));





				list.add(movieList);


			}

		} catch (Exception e) {

		}
		return list;

	}

	public List<MovieListBeans> getList(){

		if( con == null){
			//謗･邯壹＠縺ｦ縺・↑縺・ｴ蜷医・繧ｨ繝ｩ繝ｼ縺ｨ縺吶ｋ
			return null;
		}

		List<MovieListBeans> list = new ArrayList<MovieListBeans>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSet castRs = null;

		try{

			///////////////////////////////////
			//SELECT譁・・逋ｺ陦・
			stmt = con.prepareStatement("select * from movie ");

			rs = stmt.executeQuery();

			///////////////////////////////////
			//DB縺九ｉ蛟､繧貞叙蠕・
			while( rs.next() ){
				MovieListBeans movieList = new MovieListBeans();

				movieList.setTitle(rs.getString("movie_name"));
				movieList.setThumbnail(rs.getString("movie_thumbnail"));


				stmt = con.prepareStatement("select * from movie where movie_name like '%?%'");
				stmt.setInt(1,rs.getInt("movie_id"));
				castRs = stmt.executeQuery();
				List<String> cast = new ArrayList<>();
				while( castRs.next() ){

					cast.add(castRs.getString("cast_name"));

				}

				movieList.setCast(cast);


				list.add(movieList);
			}

		}catch(SQLException e) {
			//繧ｨ繝ｩ繝ｼ逋ｺ逕溘＠縺溷ｴ蜷医↓繧ｳ繝ｳ繧ｽ繝ｼ繝ｫ縺ｫ繝ｭ繧ｰ繧貞・蜉帙☆繧・
			e.printStackTrace();
		}
		finally {
	    	if(con != null) {
	    		try {
	    			con.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
		}

		return list;

	    }
	public List<Map<String, String>> getThumbnail(){

		if( con == null){
			//謗･邯壹＠縺ｦ縺・↑縺・ｴ蜷医・繧ｨ繝ｩ繝ｼ縺ｨ縺吶ｋ
			return null;
		}

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String,String> map = new HashMap<String,String>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{

			///////////////////////////////////
			//SELECT譁・・逋ｺ陦・
			stmt = con.prepareStatement("select * from movie");

			rs = stmt.executeQuery();

			///////////////////////////////////
			//DB縺九ｉ蛟､繧貞叙蠕・
			while( rs.next() ){
				map = new HashMap<>();

				map.put("id",rs.getString("movie_id"));
				map.put("thumbnail",rs.getString("movie_thumbnail"));

				list.add(map);
			}

		}catch(SQLException e) {
			//繧ｨ繝ｩ繝ｼ逋ｺ逕溘＠縺溷ｴ蜷医↓繧ｳ繝ｳ繧ｽ繝ｼ繝ｫ縺ｫ繝ｭ繧ｰ繧貞・蜉帙☆繧・
			e.printStackTrace();
		}
		finally {
	    	if(con != null) {
	    		try {
	    			con.close();
	    		}
	    		catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
		}

		return list;

	    }


}
