package com.mengfou.entity;

import java.io.Serializable;

public class LbNovelSectionDetail implements Serializable {
    private Integer identityid;

    private String id;

    private Integer sectionid;

    private String sectiondetail;

    private static final long serialVersionUID = 1L;

    public LbNovelSectionDetail(Integer identityid, String id, Integer sectionid, String sectiondetail) {
        this.identityid = identityid;
        this.id = id;
        this.sectionid = sectionid;
        this.sectiondetail = sectiondetail;
    }

    public LbNovelSectionDetail() {
        super();
    }

    public Integer getIdentityid() {
        return identityid;
    }

    public void setIdentityid(Integer identityid) {
        this.identityid = identityid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getSectionid() {
        return sectionid;
    }

    public void setSectionid(Integer sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectiondetail() {
        return sectiondetail;
    }

    public void setSectiondetail(String sectiondetail) {
        this.sectiondetail = sectiondetail == null ? null : sectiondetail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", identityid=").append(identityid);
        sb.append(", id=").append(id);
        sb.append(", sectionid=").append(sectionid);
        sb.append(", sectiondetail=").append(sectiondetail);
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
        LbNovelSectionDetail other = (LbNovelSectionDetail) that;
        return (this.getIdentityid() == null ? other.getIdentityid() == null : this.getIdentityid().equals(other.getIdentityid()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSectionid() == null ? other.getSectionid() == null : this.getSectionid().equals(other.getSectionid()))
            && (this.getSectiondetail() == null ? other.getSectiondetail() == null : this.getSectiondetail().equals(other.getSectiondetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdentityid() == null) ? 0 : getIdentityid().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSectionid() == null) ? 0 : getSectionid().hashCode());
        result = prime * result + ((getSectiondetail() == null) ? 0 : getSectiondetail().hashCode());
        return result;
    }
}