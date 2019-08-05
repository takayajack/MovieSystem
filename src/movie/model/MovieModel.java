package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import movie.beans.LoginInfoBeans;
import movie.beans.MovieListBeans;
import movie.model.dao.MovieDao;
import movie.model.dao.MovieSearchDao;

public class MovieModel {


	public List<MovieListBeans> getList(LoginInfoBeans loginInfo){

		List<MovieListBeans> list = new ArrayList<MovieListBeans>();

		MovieDao movieDao = new MovieDao();

		try {
			movieDao.connect();
			list = movieDao.getList(loginInfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(movieDao!=null) {
				movieDao.close();
			}
		}
		return list;
	}

	public List<Map<String, String>> getThumbnail(){

		List<Map<String, String>> list = new ArrayList<Map<String,String>>();

		MovieDao movieDao = new MovieDao();

		try {
			movieDao.connect();
			list = movieDao.getThumbnail();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(movieDao!=null) {
				movieDao.close();
			}
		}
		return list;
	}

	public List<MovieListBeans>  seachList(String sitem){

		List<MovieListBeans> list = new ArrayList<MovieListBeans>();

		MovieSearchDao search = new MovieSearchDao();


		try {
			search.connect();
			list = search.getKeywordSearch(sitem);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(search!=null) {
				search.close();
			}
		}
		return list;
	}
}

