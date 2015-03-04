
package org.antczak.bitbucket2gitlab.api.gitlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Issue{
   	private String assignee;
   	private Author author;
   	private String created_at;
   	private String description;
   	private Number id;
   	private Number iid;
   	private List<String> labels = new ArrayList<>();
   	private String milestone;
   	private Number project_id;
   	private String state;
   	private String title;
   	private String updated_at;

    public Issue(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getAssignee(){
		return this.assignee;
	}
	public void setAssignee(String assignee){
		this.assignee = assignee;
	}
 	public Author getAuthor(){
		return this.author;
	}
	public void setAuthor(Author author){
		this.author = author;
	}
 	public String getCreated_at(){
		return this.created_at;
	}
	public void setCreated_at(String created_at){
		this.created_at = created_at;
	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public Number getIid(){
		return this.iid;
	}
	public void setIid(Number iid){
		this.iid = iid;
	}
 	public List<String> getLabels(){
		return this.labels;
	}
	public void setLabels(List<String> labels){
		this.labels = labels;
	}
    public void addLabel(String label){
        this.labels.add(label);
    }
 	public String getMilestone(){
		return this.milestone;
	}
	public void setMilestone(String milestone){
		this.milestone = milestone;
	}
 	public Number getProject_id(){
		return this.project_id;
	}
	public void setProject_id(Number project_id){
		this.project_id = project_id;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getUpdated_at(){
		return this.updated_at;
	}
	public void setUpdated_at(String updated_at){
		this.updated_at = updated_at;
	}

    public Map<String, Object> getData() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String label : getLabels()) {
            if (stringBuffer.length() != 0) stringBuffer.append(",");
            stringBuffer.append(label);
        }

        Map<String, Object> params = new HashMap<>();
        params.put("title", getTitle());
        params.put("description ", getDescription());
        params.put("labels", stringBuffer.toString());

        return params;
    }
}
