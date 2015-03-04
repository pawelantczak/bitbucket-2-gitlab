
package org.antczak.bitbucket2gitlab.api.gitlab;

import java.util.List;

public class Author{
   	private String avatar_url;
   	private Number id;
   	private String name;
   	private String state;
   	private String username;

 	public String getAvatar_url(){
		return this.avatar_url;
	}
	public void setAvatar_url(String avatar_url){
		this.avatar_url = avatar_url;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
 	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
}
