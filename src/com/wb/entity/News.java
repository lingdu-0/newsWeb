package com.wb.entity;

import java.util.Date;

/**
 * 新闻实体类
 * 
 * @author W
 *
 */
public class News {
	private int nid;// 新闻编号
	private String ntitle;// 新闻标题
	private String ncontent;// 新闻内容
	private String ncategory;// 新闻类别
	private Date ndate;// 新闻发布或者修改时间

	public News(int nid, String ntitle, String ncontent, String ncategory, Date ndate) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ncategory = ncategory;
		this.ndate = ndate;
	}

	public News() {
		super();
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNcategory() {
		return ncategory;
	}

	public void setNcategory(String ncategory) {
		this.ncategory = ncategory;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ncategory=" + ncategory
				+ ", ndate=" + ndate + "]";
	}

}
