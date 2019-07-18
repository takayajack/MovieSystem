package movie.model;

import java.util.List;
import java.util.Map;

import movie.model.dao.AdminMovieDao;

public class AdminMovieModel {

	public List<Map<String,String>> getList(){

		List<Map<String,String>> list = null;

		AdminMovieDao dao = new AdminMovieDao();

		list = dao.getList();

		return list;
	}

	public List<String> getCast(String id){

		List<String> list = null;

		AdminMovieDao dao = new AdminMovieDao();

		list = dao.getCast(id);

		return list;
	}
}
