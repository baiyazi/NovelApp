package com.mengfou.entity;

import java.io.Serializable;

public class LeaderBoard implements Serializable {
    private String id;

    private Integer catid;

    private String catname;

    private String picurl;

    private String bookname;

    private String authorname;

    private String bookdesc;

    private String score;

    private String wordcount;

    private String lastindexupdatetime;

    private String lastindexid;

    private String lastindexname;

    private static final long serialVersionUID = 1L;

    public LeaderBoard(String id, Integer catid, String catname, String picurl, String bookname, String authorname, String bookdesc, String score, String wordcount, String lastindexupdatetime, String lastindexid, String lastindexname) {
        this.id = id;
        this.catid = catid;
        this.catname = catname;
        this.picurl = picurl;
        this.bookname = bookname;
        this.authorname = authorname;
        this.bookdesc = bookdesc;
        this.score = score;
        this.wordcount = wordcount;
        this.lastindexupdatetime = lastindexupdatetime;
        this.lastindexid = lastindexid;
        this.lastindexname = lastindexname;
    }

    public LeaderBoard() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname == null ? null : catname.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname == null ? null : authorname.trim();
    }

    public String getBookdesc() {
        return bookdesc;
    }

    public void setBookdesc(String bookdesc) {
        this.bookdesc = bookdesc == null ? null : bookdesc.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getWordcount() {
        return wordcount;
    }

    public void setWordcount(String wordcount) {
        this.wordcount = wordcount == null ? null : wordcount.trim();
    }

    public String getLastindexupdatetime() {
        return lastindexupdatetime;
    }

    public void setLastindexupdatetime(String lastindexupdatetime) {
        this.lastindexupdatetime = lastindexupdatetime == null ? null : lastindexupdatetime.trim();
    }

    public String getLastindexid() {
        return lastindexid;
    }

    public void setLastindexid(String lastindexid) {
        this.lastindexid = lastindexid == null ? null : lastindexid.trim();
    }

    public String getLastindexname() {
        return lastindexname;
    }

    public void setLastindexname(String lastindexname) {
        this.lastindexname = lastindexname == null ? null : lastindexname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", catid=").append(catid);
        sb.append(", catname=").append(catname);
        sb.append(", picurl=").append(picurl);
        sb.append(", bookname=").append(bookname);
        sb.append(", authorname=").append(authorname);
        sb.append(", bookdesc=").append(bookdesc);
        sb.append(", score=").append(score);
        sb.append(", wordcount=").append(wordcount);
        sb.append(", lastindexupdatetime=").append(lastindexupdatetime);
        sb.append(", lastindexid=").append(lastindexid);
        sb.append(", lastindexname=").append(lastindexname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LeaderBoard other = (LeaderBoard) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatid() == null ? other.getCatid() == null : this.getCatid().equals(other.getCatid()))
            && (this.getCatname() == null ? other.getCatname() == null : this.getCatname().equals(other.getCatname()))
            && (this.getPicurl() == null ? other.getPicurl() == null : this.getPicurl().equals(other.getPicurl()))
            && (this.getBookname() == null ? other.getBookname() == null : this.getBookname().equals(other.getBookname()))
            && (this.getAuthorname() == null ? other.getAuthorname() == null : this.getAuthorname().equals(other.getAuthorname()))
            && (this.getBookdesc() == null ? other.getBookdesc() == null : this.getBookdesc().equals(other.getBookdesc()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getWordcount() == null ? other.getWordcount() == null : this.getWordcount().equals(other.getWordcount()))
            && (this.getLastindexupdatetime() == null ? other.getLastindexupdatetime() == null : this.getLastindexupdatetime().equals(other.getLastindexupdatetime()))
            && (this.getLastindexid() == null ? other.getLastindexid() == null : this.getLastindexid().equals(other.getLastindexid()))
            && (this.getLastindexname() == null ? other.getLastindexname() == null : this.getLastindexname().equals(other.getLastindexname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCatid() == null) ? 0 : getCatid().hashCode());
        result = prime * result + ((getCatname() == null) ? 0 : getCatname().hashCode());
        result = prime * result + ((getPicurl() == null) ? 0 : getPicurl().hashCode());
        result = prime * result + ((getBookname() == null) ? 0 : getBookname().hashCode());
        result = prime * result + ((getAuthorname() == null) ? 0 : getAuthorname().hashCode());
        result = prime * result + ((getBookdesc() == null) ? 0 : getBookdesc().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getWordcount() == null) ? 0 : getWordcount().hashCode());
        result = prime * result + ((getLastindexupdatetime() == null) ? 0 : getLastindexupdatetime().hashCode());
        result = prime * result + ((getLastindexid() == null) ? 0 : getLastindexid().hashCode());
        result = prime * result + ((getLastindexname() == null) ? 0 : getLastindexname().hashCode());
        return result;
    }
}