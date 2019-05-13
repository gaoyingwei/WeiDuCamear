package com.bw.movie.bean;

import java.util.List;

public class BanerBean {
    public List<Baner>result;

    public BanerBean(List<Baner> result) {
        this.result = result;
    }

    public List<Baner> getResult() {
        return result;
    }

    public void setResult(List<Baner> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BanerBean{" +
                "result=" + result +
                '}';
    }
}
