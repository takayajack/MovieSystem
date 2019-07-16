package movie.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminMovieDao extends DaoBase {

	public List<Map<String,String>> getList(){

		if( con == null ) {
			return null;
		}

		List<Map<String,String>> list = new ArrayList<Map<String,String>>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT movie_id,movie_name,movie_synopsis,UNIX_TIMESTAMP(movie_time) AS time, "
									+ "movie_thumbnail,movie_url,movie_open,movie_close FROM movie WHERE date(now()) <= movie_close");

			rs = stmt.executeQuery();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			sdf.applyPattern("yyyy-MM-dd");

			while( rs.next() ) {
				Map<String,String> map = new HashMap<String,String>();

				map.put("id", rs.getString("movie_id"));
				map.put("name", rs.getString("movie_name"));
				map.put("synopsis", rs.getString("movie_synopsis"));
				map.put("time", String.valueOf(rs.getLong("time")/1000*60));
				map.put("thumbnail", rs.getString("movie_thumbnail"));
				map.put("url", rs.getString("movie_uri"));
				map.put("open", sdf.format(rs.getDate("movie_open")));
				map.put("close", sdf.format(rs.getDate("movie_close")));

				list.add(map);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if( con!=null ) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public List<String> getCast(String id){

		if( con == null ) {
			return null;
		}

		List<String> list = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT role_name "
										+ "FROM casts "
										+ "WHERE movie_id = ?");

			stmt.setString(1, id);
			rs = stmt.executeQuery();

			list = new ArrayList<String>();
			while( rs.next() ) {
				list.add(rs.getString("role_name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if( con!=null ) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
