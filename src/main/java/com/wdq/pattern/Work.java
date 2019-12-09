package com.wdq.pattern;

/**
 * @author wudq
 * @date 2019/2/13
 * @Description: TODO
 */
public class Work {

    private String name;
    private String company;

    public Work(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Work{" +
            "name='" + name + '\'' +
            ", company='" + company + '\'' +
            '}';
    }
}
