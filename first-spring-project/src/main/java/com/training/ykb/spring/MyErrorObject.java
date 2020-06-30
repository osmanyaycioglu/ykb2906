package com.training.ykb.spring;

import java.util.ArrayList;
import java.util.List;

public class MyErrorObject {

    private String              domain;
    private String              subDomain;
    private String              boundedContext;
    private String              desc;
    private List<MyErrorObject> subErrorObjects;


    public MyErrorObject() {
    }


    public MyErrorObject(final String domainParam,
                         final String subDomainParam,
                         final String boundedContextParam,
                         final String descParam) {
        super();
        this.domain = domainParam;
        this.subDomain = subDomainParam;
        this.boundedContext = boundedContextParam;
        this.desc = descParam;
    }


    public void addError(final MyErrorObject errorObjectParam) {
        if (this.subErrorObjects == null) {
            this.subErrorObjects = new ArrayList<>();
        }
        this.subErrorObjects.add(errorObjectParam);
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(final String domainParam) {
        this.domain = domainParam;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public void setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public List<MyErrorObject> getSubErrorObjects() {
        return this.subErrorObjects;
    }

    public void setSubErrorObjects(final List<MyErrorObject> subErrorObjectsParam) {
        this.subErrorObjects = subErrorObjectsParam;
    }


}
