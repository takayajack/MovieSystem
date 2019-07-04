package diarysystem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.ReservationDao;
import diarysystem.Beans.ReservationBeans;

/**
 * @author takaya
 *
 * 映画予約の操作を行う。
 *
 */
public class ReservationModel {


	//席の予約の有無を確認。
	public  HashMap<String, String> getReservation() {

		HashMap<String,String> seatData = new HashMap<String,String>();

		List<ReservationBeans> list = new ArrayList<ReservationBeans>();

		ReservationDao reservationdao = new ReservationDao();

	    list = 	reservationdao.getReservation();

		for(int i = 0;i<10 ; i++) {

			for(int j = 0;j < 10;j++) {

				String nowSeatNo = (i+1) +"-"+ (j+1);

				for(ReservationBeans res:list) {
					if(nowSeatNo.equals(res.getSeat())){
						seatData.put(nowSeatNo,"有");
						break;
					}else{
						seatData.put(nowSeatNo,"無");

					}
				}
			}
		}
		// try {
		//DBへの接続
		//reservationdao.connect();

		list = reservationdao.getReservation();

	    // }catch(Exception e) {
		//エラー発生した場合にコンソールにログを出力する
		//e.printStackTrace();
	    // }finally {
		//接続（コネクション）を閉じる
		//if(ReservationDao!=null) {
			//ResernatonDao.close();
		//}
	//}

		 return seatData;


	}

}
