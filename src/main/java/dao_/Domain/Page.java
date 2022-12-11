package dao_.Domain;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 21;
    //当前页码
    private Integer pageNo;
    //pageTotal总页码
    private Integer PageTotal;
    //pageTotalCount总记录数
    private Integer pageTotalCount;
    //pageSize 每页显示数量
    private Integer pageSize = PAGE_SIZE;
    //pageUrl  保存请求page的请求地址
    private String pageUrl;

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    //当前页数据
    private List<T> items;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageTotalCount, Integer pageSize, List<T> items) {
        this.pageNo = pageNo;
        PageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.pageSize = pageSize;
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //数据边界的有效检查     这个是错误写法，你在1-7之间你怎么办？？？
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > this.getPageTotal()) {
            pageNo = this.getPageTotal();
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return PageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        PageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", PageTotal=" + PageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", pageUrl='" + pageUrl + '\'' +
                ", items=" + items +
                '}';
    }
}
