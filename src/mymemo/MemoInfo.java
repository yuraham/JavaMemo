	package mymemo;


import java.sql.Timestamp;

public class MemoInfo {
	private int idx;
	private String name;
	private String pass;
	private String content;
	private Timestamp regdate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "MemoVo [idx="+idx+", name="+name+", pass="+pass+", content="+content+", regdate="+regdate+"]";
	}
	
}



