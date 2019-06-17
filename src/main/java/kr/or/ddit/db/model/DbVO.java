package kr.or.ddit.db.model;

public class DbVO {

	private String uri;
	private String className;
	
	public DbVO() {
	}

	public DbVO(String uri, String className) {
		super();
		this.uri = uri;
		this.className = className;
	}

	@Override
	public String toString() {
		return "DbVO [uri=" + uri + ", className=" + className + "]";
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
}
