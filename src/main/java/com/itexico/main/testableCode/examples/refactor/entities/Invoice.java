package com.itexico.main.testableCode.examples.refactor.entities;

public class Invoice {
    private Integer id;
    private Float total;
    private User printedByUser;
    private String email;
    private boolean overdue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public User getPrintedByUser() {
        return printedByUser;
    }

    public void setPrintedByUser(User printedByUser) {
        this.printedByUser = printedByUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }
}
