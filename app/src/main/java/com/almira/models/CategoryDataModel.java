package com.almira.models;

import java.io.Serializable;
import java.util.List;

public class CategoryDataModel extends StatusResponse implements Serializable {
    private List<CategoryModel> data;

    public List<CategoryModel> getData() {
        return data;
    }
}
