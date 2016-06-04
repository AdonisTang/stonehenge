package com.bornstone.stonehenge.entity.query;

import com.bornstone.stonehenge.common.utils.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author xumin
 * @since 2012-3-27
 */
public class PaginationQuery implements Serializable {

    private static final long serialVersionUID = 8030803496685005553L;

    private static final Integer defaultPageSize = new Integer(15);
    private static final Integer defaultFristPage = new Integer(1);
    private static final Integer defaultTotleItem = new Integer(0);
    private Integer totalItem;
    private Integer pageSize;
    private Integer pageNo;

    // for paging
    private int startRow;
    private int endRow;

    private IOrderAble orderAble = new IdOrderAble();

    private boolean isStayLastPage = true;

    protected String getStringProperty(String property) {
        return StringUtils.isEmpty(property) ? null : property;
    }

    protected <T> List<T> getListProperty(List<T> list) {
        return CollectionUtils.isEmpty(list) ? null : list;
    }

    protected Integer getDefaultPageSize() {
        return defaultPageSize;
    }

    protected Integer getDefaultTotleItem() {
        return defaultTotleItem;
    }

    public boolean isFirstPage() {
        return this.getPageNo().intValue() == 1;
    }

    public int getPreviousPage() {
        int back = this.getPageNo().intValue() - 1;

        if (back <= 0) {
            back = 1;
        }

        return back;
    }

    public boolean isLastPage() {
        return this.getTotalPage() == this.getPageNo().intValue();
    }

    public int getNextPage() {
        int back = this.getPageNo().intValue() + 1;

        if (back > this.getTotalPage()) {
            back = this.getTotalPage();
        }

        return back;
    }

    public Integer getPageNo() {
        if (pageNo == null) {
            return defaultFristPage;
        }

        return pageNo;
    }

    public void setCurrentPageString(String pageString) {
        if (StringUtils.isEmpty(pageString)) {
            this.setPageNo(defaultFristPage);
        }

        try {
            Integer integer = new Integer(pageString);

            this.setPageNo(integer);
        } catch (NumberFormatException ignore) {
            this.setPageNo(defaultFristPage);
        }
    }

    public void setPageNo(Integer pageNo) {
        if ((pageNo == null) || (pageNo.intValue() <= 0)) {
            this.pageNo = null;
        } else {
            this.pageNo = pageNo;
        }
        setStartEndRow();
    }

    private void setStartEndRow() {
        this.startRow = this.getPageSize().intValue() * (this.getPageNo().intValue() - 1);
        this.endRow = this.startRow + this.getPageSize().intValue() - 1;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return getDefaultPageSize();
        }
        return pageSize;
    }


    public void setPageSizeString(String pageSizeString) {
        if (StringUtils.isEmpty(pageSizeString)) {
            return;
        }
        try {
            Integer integer = new Integer(pageSizeString);
            this.setPageSize(integer);
        } catch (NumberFormatException ignore) {
        }
    }


    public void setTotalItem(Integer tItem) {
        if (tItem == null) {
            throw new IllegalArgumentException("TotalItem can't be null.");
        }

        this.totalItem = tItem;

        int current = this.getPageNo().intValue();
        int lastPage = this.getTotalPage();

        if (current > lastPage && isStayLastPage()) {
            this.setPageNo(new Integer(lastPage));
        }
    }

    public int getTotalPage() {
        int pgSize = this.getPageSize().intValue();
        int total = this.getTotalItem().intValue();
        int result = total / pgSize;

        if ((total == 0) || ((total % pgSize) != 0)) {
            result++;
        }

        return result;
    }

    public int getPageFirstItem() {
        int cPage = this.getPageNo().intValue();

        if (cPage == 1) {
            return 1; // 第一页开始当然是第 1 条记录
        }

        cPage--;

        int pgSize = this.getPageSize().intValue();

        return (pgSize * cPage) + 1;
    }

    public int getPageLastItem() {
        int cPage = this.getPageNo().intValue();
        int pgSize = this.getPageSize().intValue();
        int assumeLast = pgSize * cPage;
        int totalItem = getTotalItem().intValue();

        if (assumeLast > totalItem) {
            return totalItem;
        } else {
            return assumeLast;
        }
    }

    /**
     * 判断是否有下一页, 并且设置当前页码为下一页
     *
     * @return boolean
     */
    public boolean nextPage() {
        if (this.pageNo != null && this.pageNo.intValue() >= this.getTotalPage())
            return false;
        if (this.pageNo == null) {
            this.setPageNo(defaultFristPage);
        } else {
            this.setPageNo(getNextPage());
        }
        return true;
    }

    public void setPageSize(Integer pSize) {
        if ((pSize == null) || (pSize.intValue() <= 0)) {
            this.pageSize = null;
        } else {
            this.pageSize = pSize;
        }
        setStartEndRow();
    }

    public Integer getTotalItem() {
        if (totalItem == null) {
            return getDefaultTotleItem();
        }
        return totalItem;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public IOrderAble getOrderAble() {
        if (orderAble == null) {
            return new IdOrderAble();
        }
        return orderAble;
    }

    public void setOrderAble(IOrderAble orderAble) {
        this.orderAble = orderAble;
    }

    public boolean isStayLastPage() {
        return isStayLastPage;
    }

    public void setStayLastPage(boolean isStayLastPage) {
        this.isStayLastPage = isStayLastPage;
    }
}
