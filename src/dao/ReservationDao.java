package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import diarysystem.Beans.ReservationBeans;

/**
 * DBより予約情報を取得する。
 *
 *  @author takaya
 *
 *
 *
 */
public class ReservationDao extends Daobase {

		public List<ReservationBeans> getReservation(){

			List<ReservationBeans> list = new ArrayList<ReservationBeans>();

			for(int i = 0;i <= 10; i++) {

				ReservationBeans reservation = new ReservationBeans();

				reservation.setMovieDate(new Date());
				reservation.setMovieName("test");
				reservation.setSeat((i+1) +"-"+ (i+1));
				reservation.setTheater("Theater-1");
				list.add(reservation);

			}
			return list;

			///////////////////////////////////////////////
			//DBから予約のデータを取り出す
			//serect文の発行






		}
}
