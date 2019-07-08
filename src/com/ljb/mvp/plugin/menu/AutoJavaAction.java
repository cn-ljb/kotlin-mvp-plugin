package com.ljb.mvp.plugin.menu;

import com.ljb.mvp.plugin.menu.base.BaseAutoCodeAction;
import com.ljb.mvp.plugin.template.bean.Template;
import com.ljb.mvp.plugin.utils.TemplateManager;

import java.util.ArrayList;
import java.util.List;

public class AutoJavaAction extends BaseAutoCodeAction {

    @Override
    public List<Template> getMvpFragmentActivityTemplateList(TemplateManager templateManager) {
        //java act 模版
        Template templateActKt = templateManager.getTemplateFragmentActJava();
        //java contract 模版
        Template templateContractKt = templateManager.getTemplateContractJava();
        //java presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterJava();
        //java model 模版
        Template templateModelKt = templateManager.getTemplateModelJava();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }

    @Override
    public List<Template> getMvpActivityTemplateList(TemplateManager templateManager) {
        //java act 模版
        Template templateActKt = templateManager.getTemplateActJava();
        //java contract 模版
        Template templateContractKt = templateManager.getTemplateContractJava();
        //java presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterJava();
        //java model 模版
        Template templateModelKt = templateManager.getTemplateModelJava();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }

    @Override
    public List<Template> getMvpFragmentTemplateList(TemplateManager templateManager) {
        //java fragment 模版
        Template templateActKt = templateManager.getTemplateFragmentJava();
        //java contract 模版
        Template templateContractKt = templateManager.getTemplateContractJava();
        //java presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterJava();
        //java model 模版
        Template templateModelKt = templateManager.getTemplateModelJava();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }

    @Override
    public List<Template> getMvpAppCompatActivityTemplateList(TemplateManager templateManager) {
        //java fragment 模版
        Template templateActKt = templateManager.getTemplateAppCompatActJava();
        //java contract 模版
        Template templateContractKt = templateManager.getTemplateContractJava();
        //java presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterJava();
        //java model 模版
        Template templateModelKt = templateManager.getTemplateModelJava();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }


}
