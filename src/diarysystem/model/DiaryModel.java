package diarysystem.model;

import java.util.ArrayList;
import java.util.List;

import dao.JournalDao;
import diarysystem.Beans.DiaryBeans;
import diarysystem.Beans.LoginInfoBeans;
import exception.InsertException;

/**
*
* 日誌情報の操作を行う。
* (insert 取得)
* (set 	挿入)
*/

public class DiaryModel {
	/**
	 *
	 * 日誌情報の操作を行う。
	 * (insert 取得)
	 * (set 	挿入)
	 *
	 * @param classcode
	 * @return
	 *
	 */

	public void insert(LoginInfoBeans logininfo, DiaryBeans diarybeans) throws InsertException{
		JournalDao journaldao = new JournalDao();

		try {
			journaldao.connect();

			journaldao.insert(logininfo, diarybeans);
		}catch(InsertException e) {
			throw e;
		}catch(Exception e) {
			e.printStackTrace();

		}
		finally {
			if(journaldao!=null) {
				journaldao.close();
			}
		}

	}

	public List<DiaryBeans> set(String classcode) {


		List<DiaryBeans> list = new ArrayList<DiaryBeans>();

		JournalDao journalDao = new JournalDao();
		try {
			//////////////////////////////////////
			//DBの接続
			journalDao.connect();

			//////////////////////////////////////
			//日誌情報の取得
			list= journalDao.getList(classcode);
		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			if(journalDao!=null) {
				journalDao.close();
			}
		}

		return list;
	}
}
