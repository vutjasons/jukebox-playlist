
/**
 * This song class will user 4 variables that will be the title of the song, artist of the song, album of the song, and rating of the song
 * This class will construct a song and be able to compare songs to sort in order
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Song implements Comparable<Song>
{
	/** title of the song**/
	private String title;
	
	/** artist of the song **/
	private String artist;
	
	/**album that the artist made **/
	private String album;
	
	/** rating of the song**/
	private int rate;
	
	/**
	 * constructor used to create the title, artist,album,rate
	 * @param t - title of song
	 * @param a - artist of song
	 * @param al - album of song
	 * @param r - rating of song
	 */
	public Song(String t, String a, String al, int r)
	{
		title = t;
		artist = a;
		album = al;
		rate = r;
	}
	
	/**
 	* Getter that returns the title of the song
 	* @return title - song name
 	*/
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Getter that returns the artist of song
	 * @return artist - artist name
	 */
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * Getter that returns the album name
	 * @return album - album name
	 */
	public String getAlbum()
	{
		return album;
	}
	
	/**
	 * Getter that returns the rating of the song
	 * @return rate - rating of song
	 */
	public int getRate()
	{
		return rate;
	}
	
	/**
	 * @return the title, artist, album and rate combined together
	 * @Override toString method
	 */
	@Override
	public String toString()
	{
		return title + " " + artist + " " + album + " " +rate;
	}
	
	/**
	 * function compares the rating of the songs and then the title name by alphabetical order
	 * if this.rate is equal to o.rate return this.title.compareTo(o.title);
	 * else if this.rate is less than o.rate return 1
	 * else if this.rate is greater than o.rate return -1
	 * else return 0
	 * @return return this.title.compareTo(o.title) - returns a positive, negative or 0
	 * @return 1 - if this is less than o
	 * @return -1 - if this is greater than o
	 * @return 0 if this is equal to o
	 */
	@Override
	public int compareTo(Song o) 
	{
		if(this.rate == o.rate)
		{
			return this.title.compareTo(o.title);
		}
		
		if( this.rate < o.rate)
		{
			return 1;
		}
		
		if(this.rate > o.rate)
		{
			return -1;
		}
		
		return 0;
	}
	

}
