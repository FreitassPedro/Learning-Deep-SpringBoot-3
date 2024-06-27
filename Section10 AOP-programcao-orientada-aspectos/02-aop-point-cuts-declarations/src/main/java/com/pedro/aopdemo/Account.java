package com.pedro.aopdemo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Account {
    private String name;
    private String level;

    public Account() {}

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
