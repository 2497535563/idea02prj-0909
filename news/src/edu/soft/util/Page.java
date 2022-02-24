package edu.soft.util;


import edu.soft.pojo.News;

import java.util.List;

public class Page {
    private int totalPageCount = 1;//总页数
    private int pageSize = 0;//每页行数
    private int totalCount = 0;//总记录
    private List<News> newsList;//
    private int currPageNo = 1;//当前页面




    public List<News> getNewsList() {
        return newsList;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public int getPageSize() {

        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrPageNo() {
        if (totalPageCount==0){
            return 0;
        }
        return currPageNo;
    }

    public void setTotalPageCount(int totalPageCount) {
        totalPageCount = this.totalPageCount % pageSize ==0 ?
                (this.totalCount/pageSize):this.totalCount/pageSize+1;
        this.totalPageCount = totalPageCount;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>0){
            this.pageSize = pageSize;
        }
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

}