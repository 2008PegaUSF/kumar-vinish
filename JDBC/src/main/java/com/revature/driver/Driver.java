package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.AlbumDaoImpl;

public class Driver {
	public static void main(String[] args) {
		AlbumDaoImpl adi = new AlbumDaoImpl();
		try {
			//adi.getAllAlbums();
			System.out.println(adi.getAllAlbums());
			//System.out.println(adi.getAllAlbumsbyArtistId(22));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
