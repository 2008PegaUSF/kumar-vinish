package com.revature.beans;

/*
 * private fields
 * no args and w/ fields constructors
 * getters and setters (accessers and mutators)
 * toString method override
 * Ex. our Customer and Application classes in bankingApp
 */

public class Album {
	private int albumId;
	private String title;
	private int artistId;
	
	public Album() {
		super();
	}
	
	public Album(int albumId, String title, int artistId) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.artistId = artistId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", artistId=" + artistId + "]";
	}
}
