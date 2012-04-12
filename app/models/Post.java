package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity
@Table(name="nifty_posts")
public class Post extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String title;

	@Lob
	private String description; 

	public static Finder<Long, Post> find = new Finder<Long, Post>(Long.class, Post.class);

	public String toString(){
		//return title + ", " + description;
		return title + ", " + getDescription();
	}


	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

}