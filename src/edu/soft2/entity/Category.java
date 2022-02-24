package edu.soft2.entity;

public class Category {
    private String CateID,CateName;
//无参数构造方法
    public Category() {
    }

    /**
     * 有参数构造方法
     *
     * @param cateID
     * @param cateName
     */
    public Category(String cateID, String cateName) {
        CateID = cateID;
        CateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CateID='" + CateID + '\'' +
                ", CateName='" + CateName + '\'' +
                '}';
    }

    public String getCateID() {
        return CateID;
    }

    public void setCateID(String cateID) {
        CateID = cateID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String cateName) {
        CateName = cateName;
    }
}
