package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Album;

public interface AlbumDao {
	public List<Album> getAllAlbums() throws SQLException;
	public List<Album> getAllAlbumsbyArtistId(int id) throws SQLException;
}
