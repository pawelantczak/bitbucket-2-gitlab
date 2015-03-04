
package org.antczak.bitbucket2gitlab.api.bitbucket;

import java.util.List;

public class Issues{
   	private Number comment_count;
   	private String content;
   	private String created_on;
   	private Number follower_count;
   	private boolean is_spam;
   	private Number local_id;
   	private Metadata metadata;
   	private String priority;
   	private Reported_by reported_by;
   	private String resource_uri;
   	private String status;
   	private String title;
   	private String utc_created_on;
   	private String utc_last_updated;

 	public Number getComment_count(){
		return this.comment_count;
	}
	public void setComment_count(Number comment_count){
		this.comment_count = comment_count;
	}
 	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content = content;
	}
 	public String getCreated_on(){
		return this.created_on;
	}
	public void setCreated_on(String created_on){
		this.created_on = created_on;
	}
 	public Number getFollower_count(){
		return this.follower_count;
	}
	public void setFollower_count(Number follower_count){
		this.follower_count = follower_count;
	}
 	public boolean getIs_spam(){
		return this.is_spam;
	}
	public void setIs_spam(boolean is_spam){
		this.is_spam = is_spam;
	}
 	public Number getLocal_id(){
		return this.local_id;
	}
	public void setLocal_id(Number local_id){
		this.local_id = local_id;
	}
 	public Metadata getMetadata(){
		return this.metadata;
	}
	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}
 	public String getPriority(){
		return this.priority;
	}
	public void setPriority(String priority){
		this.priority = priority;
	}
 	public Reported_by getReported_by(){
		return this.reported_by;
	}
	public void setReported_by(Reported_by reported_by){
		this.reported_by = reported_by;
	}
 	public String getResource_uri(){
		return this.resource_uri;
	}
	public void setResource_uri(String resource_uri){
		this.resource_uri = resource_uri;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getUtc_created_on(){
		return this.utc_created_on;
	}
	public void setUtc_created_on(String utc_created_on){
		this.utc_created_on = utc_created_on;
	}
 	public String getUtc_last_updated(){
		return this.utc_last_updated;
	}
	public void setUtc_last_updated(String utc_last_updated){
		this.utc_last_updated = utc_last_updated;
	}
}
