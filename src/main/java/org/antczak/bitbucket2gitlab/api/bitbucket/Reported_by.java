
package org.antczak.bitbucket2gitlab.api.bitbucket;

import java.util.List;

public class Reported_by{
   	private String avatar;
   	private String display_name;
   	private String first_name;
   	private boolean is_staff;
   	private boolean is_team;
   	private String last_name;
   	private String resource_uri;
   	private String username;

 	public String getAvatar(){
		return this.avatar;
	}
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
 	public String getDisplay_name(){
		return this.display_name;
	}
	public void setDisplay_name(String display_name){
		this.display_name = display_name;
	}
 	public String getFirst_name(){
		return this.first_name;
	}
	public void setFirst_name(String first_name){
		this.first_name = first_name;
	}
 	public boolean getIs_staff(){
		return this.is_staff;
	}
	public void setIs_staff(boolean is_staff){
		this.is_staff = is_staff;
	}
 	public boolean getIs_team(){
		return this.is_team;
	}
	public void setIs_team(boolean is_team){
		this.is_team = is_team;
	}
 	public String getLast_name(){
		return this.last_name;
	}
	public void setLast_name(String last_name){
		this.last_name = last_name;
	}
 	public String getResource_uri(){
		return this.resource_uri;
	}
	public void setResource_uri(String resource_uri){
		this.resource_uri = resource_uri;
	}
 	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
}
