package com.example.javaceshi.beans;

import java.util.List;

/*
 *  实时画笔的contentbean
 * */
public class CmdMessage18Content {

    private Integer courseIndex;
    private Integer pageIndex;
    private List<Annotations> annotations;
    private boolean realtime;
    private String show;//0 或者1  主要是默认值是0而且返回的数据中还有0这种标识值。为了判断非空，所以才这么写

    public Integer getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(Integer courseIndex) {
        this.courseIndex = courseIndex;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<Annotations> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotations> annotations) {
        this.annotations = annotations;
    }

    public boolean isRealtime() {
        return realtime;
    }

    public void setRealtime(boolean realtime) {
        this.realtime = realtime;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "CmdMessage18Content{" +
                "courseIndex=" + courseIndex +
                ", pageIndex=" + pageIndex +
                ", annotations=" + annotations +
                ", realtime=" + realtime +
                ", show='" + show + '\'' +
                '}';
    }
}
