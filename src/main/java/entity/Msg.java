package entity;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:18
 * 描述:信息类
 */
public class Msg {
    private Integer id;
    private Integer fromUId;
    private Integer toUId;
    private String mtitle;
    private String mContent;
    private Integer readFlag;
    private String createTime;

    public Msg() {
    }

    public Msg(Integer id, Integer fromUId, Integer toUId, String mtitle, String mContent, Integer readFlag, String createTime) {
        this.id = id;
        this.fromUId = fromUId;
        this.toUId = toUId;
        this.mtitle = mtitle;
        this.mContent = mContent;
        this.readFlag = readFlag;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", fromUId=" + fromUId +
                ", toUId=" + toUId +
                ", mtitle='" + mtitle + '\'' +
                ", mContent='" + mContent + '\'' +
                ", readFlag=" + readFlag +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUId() {
        return fromUId;
    }

    public void setFromUId(Integer fromUId) {
        this.fromUId = fromUId;
    }

    public Integer getToUId() {
        return toUId;
    }

    public void setToUId(Integer toUId) {
        this.toUId = toUId;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Integer getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Integer readFlag) {
        this.readFlag = readFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
