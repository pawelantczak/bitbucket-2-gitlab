package org.antczak.bitbucket2gitlab.api.bitbucket;

import java.util.List;

public class Response {
    private Number count;
    private Filter filter;
    private List<Issues> issues;
    private String search;

    public Number getCount() {
        return this.count;
    }

    public void setCount(Number count) {
        this.count = count;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Issues> getIssues() {
        return this.issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
