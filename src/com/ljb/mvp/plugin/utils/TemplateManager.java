package com.ljb.mvp.plugin.utils;

import com.intellij.openapi.actionSystem.AnAction;
import com.ljb.mvp.plugin.template.bean.Template;

import java.io.InputStream;

public class TemplateManager {

    private AnAction action;
    private String idePath;
    private String moduleName;

    public TemplateManager(AnAction action, String idePath, String moduleName) {
        this.action = action;
        this.idePath = idePath;
        this.moduleName = moduleName;
    }

    /**
     * Kotlin Contract 模版
     */
    public Template getTemplateContractKt() {
        InputStream tContractInput = action.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TContractKt.txt");
        String tContractContent = FileUtils.readTemplateFile(tContractInput);
        String contractDir = idePath + "/contract";
        String contractFileName = moduleName + "Contract.kt";
        return new Template(contractDir, contractFileName, tContractContent);
    }

    /**
     * Kotlin Presenter 模版
     */
    public Template getTemplatePresenterKt() {
        InputStream tPresenterInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TPresenterKt.txt");
        String tPresenterContent = FileUtils.readTemplateFile(tPresenterInput);
        String presenterDir = idePath + "/presenter";
        String presenterFileName = moduleName + "Presenter.kt";
        return new Template(presenterDir, presenterFileName, tPresenterContent);
    }

    /**
     * Kotlin Model 模版
     */
    public Template getTemplateModelKt() {
        InputStream tModelInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TModelKt.txt");
        String tModelContent = FileUtils.readTemplateFile(tModelInput);
        String modelDir = idePath + "/model";
        String modelFileName = moduleName + "Model.kt";
        return new Template(modelDir, modelFileName, tModelContent);
    }


    /**
     * Kotlin Activity 模版
     */
    public Template getTemplateActKt() {
        InputStream tMvpActInput = action.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TMvpActivityKt.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = idePath + "/view/act";
        String actFileName = moduleName + "Activity.kt";
        return new Template(actDir, actFileName, tActContent);
    }

    /**
     * Kotlin Fragment 模版
     */
    public Template getTemplateFragmentKt() {
        InputStream tFragmentInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TMvpFragmentKt.txt");
        String tFragmentContent = FileUtils.readTemplateFile(tFragmentInput);
        String fragmentDir = idePath + "/view/fragment";
        String fragmentFileName = moduleName + "Fragment.kt";
        return new Template(fragmentDir, fragmentFileName, tFragmentContent);
    }

    /**
     * Kotlin FragmentActivity 模版
     */
    public Template getTemplateFragmentActKt() {
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TMvpFragmentActivityKt.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = idePath + "/view/act";
        String actFileName = moduleName + "Activity.kt";
        return new Template(actDir, actFileName, tActContent);
    }

    /**
     * Kotlin AppCompatActivity 模版
     */
    public Template getTemplateAppCompatActKt() {
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/kt/TMvpAppCompatActivityKt.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = idePath + "/view/act";
        String actFileName = moduleName + "Activity.kt";
        return new Template(actDir, actFileName, tActContent);
    }

    /**
     * Java Contract 模版
     */
    public Template getTemplateContractJava() {
        //创建Contract
        InputStream tContractInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TContractJava.txt");
        String tContractContent = FileUtils.readTemplateFile(tContractInput);
        String contractDir = idePath + "/contract";
        String contractFileName = moduleName + "Contract.java";
        return new Template(contractDir, contractFileName, tContractContent);
    }

    /**
     * Java Presenter 模版
     */
    public Template getTemplatePresenterJava() {
        InputStream tPresenterInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TPresenterJava.txt");
        String tPresenterContent = FileUtils.readTemplateFile(tPresenterInput);
        String presenterDir = idePath + "/presenter";
        String presenterFileName = moduleName + "Presenter.java";
        return new Template(presenterDir, presenterFileName, tPresenterContent);
    }

    /**
     * Model Activity 模版
     */
    public Template getTemplateModelJava() {
        InputStream tModelInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TModelJava.txt");
        String tModelContent = FileUtils.readTemplateFile(tModelInput);
        String modelDir = idePath + "/model";
        String modelFileName = moduleName + "Model.java";
        return new Template(modelDir, modelFileName, tModelContent);
    }

    /**
     * Java Activity 模版
     */
    public Template getTemplateActJava() {
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TMvpActivityJava.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = idePath + "/view/act";
        String actFileName = moduleName + "Activity.java";
        return new Template(actDir, actFileName, tActContent);
    }

    /**
     * Java Fragment 模版
     */
    public Template getTemplateFragmentJava() {
        InputStream tFragmentInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TMvpFragmentJava.txt");
        String tFragmentContent = FileUtils.readTemplateFile(tFragmentInput);
        String fragmentDir = idePath + "/view/fragment";
        String fragmentFileName = moduleName + "Fragment.java";
        return new Template(fragmentDir, fragmentFileName, tFragmentContent);
    }

    public Template getTemplateFragmentActJava() {
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TMvpFragmentActivityJava.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = idePath + "/view/act";
        String actFileName = moduleName + "Activity.java";
        return new Template(actDir, actFileName, tActContent);
    }

    public Template getTemplateAppCompatActJava() {
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/java/TMvpAppCompatActivityJava.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = idePath + "/view/act";
        String actFileName = moduleName + "Activity.java";
        return new Template(actDir, actFileName, tActContent);
    }
}
