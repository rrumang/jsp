package kr.or.ddit.db.model;

public class DbVo {
	
	private String uri;
	private String classname;
	
	
	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	

	public DbVo(String uri, String classname) {
		this.uri = uri;
		this.classname = classname;
	}
	
	public DbVo() {
		
	}


	@Override
	public String toString() {
		return "DbVo [uri=" + uri + ", classname=" + classname + "]";
	}
	
	
}
