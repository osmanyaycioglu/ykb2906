package com.training.ykb.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.spring.validation.MyValidation;

@XmlRootElement
public class Person {

    @Size(min = 2, max = 100)
    @NotEmpty
    private String name;
    @MyValidation(start = "test", message = "surname test ile başlamalı.")
    private String surname;
    @NotEmpty
    private String birthdate;
    @Min(1)
    @Max(value = 30, message = "workingYear 30 dan büyük olamaz")
    private int    workingYear;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(final String birthdateParam) {
        this.birthdate = birthdateParam;
    }

    public int getWorkingYear() {
        return this.workingYear;
    }

    public void setWorkingYear(final int workingYearParam) {
        this.workingYear = workingYearParam;
    }

}
