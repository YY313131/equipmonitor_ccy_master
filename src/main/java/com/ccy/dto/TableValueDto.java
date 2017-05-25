package com.ccy.dto;

import java.util.List;

/**
 * Created by caihanbin on 2017/5/25.
 */
public class TableValueDto {
    private int total;
    private List<CollectedValueDto> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CollectedValueDto> getRows() {
        return rows;
    }

    public void setRows(List<CollectedValueDto> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TableValueDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
