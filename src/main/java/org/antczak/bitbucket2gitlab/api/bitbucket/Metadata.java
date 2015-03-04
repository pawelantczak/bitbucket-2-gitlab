
package org.antczak.bitbucket2gitlab.api.bitbucket;

import java.util.List;

public class Metadata{
   	private String component;
   	private String kind;
   	private String milestone;
   	private String version;

 	public String getComponent(){
		return this.component;
	}
	public void setComponent(String component){
		this.component = component;
	}
 	public String getKind(){
		return this.kind;
	}
	public void setKind(String kind){
		this.kind = kind;
	}
 	public String getMilestone(){
		return this.milestone;
	}
	public void setMilestone(String milestone){
		this.milestone = milestone;
	}
 	public String getVersion(){
		return this.version;
	}
	public void setVersion(String version){
		this.version = version;
	}
}
