package com.ljb.mvp.plugin;

public enum TemplateEnum {

    Act("Activity"), Fragment("Fragment"), FragmentAct("FragmentActivity"), AppCompatAct("AppCompatActivity");

    public String value;

    TemplateEnum(String value) {
        this.value = value;
    }
}
