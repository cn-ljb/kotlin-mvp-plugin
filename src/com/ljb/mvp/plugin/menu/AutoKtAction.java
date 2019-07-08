package com.ljb.mvp.plugin.menu;

import com.ljb.mvp.plugin.menu.base.BaseAutoCodeAction;
import com.ljb.mvp.plugin.template.bean.Template;
import com.ljb.mvp.plugin.utils.TemplateManager;

import java.util.ArrayList;
import java.util.List;

public class AutoKtAction extends BaseAutoCodeAction {

    @Override
    public List<Template> getMvpAppCompatActivityTemplateList(TemplateManager templateManager) {
        //kotlin appCompatAct 模版
        Template templateActKt = templateManager.getTemplateAppCompatActKt();
        //kotlin contract 模版
        Template templateContractKt = templateManager.getTemplateContractKt();
        //kotlin presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterKt();
        //kotlin model 模版
        Template templateModelKt = templateManager.getTemplateModelKt();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }

    @Override
    public List<Template> getMvpFragmentActivityTemplateList(TemplateManager templateManager) {
        //kotlin fragmentAct 模版
        Template templateActKt = templateManager.getTemplateFragmentActKt();
        //kotlin contract 模版
        Template templateContractKt = templateManager.getTemplateContractKt();
        //kotlin presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterKt();
        //kotlin model 模版
        Template templateModelKt = templateManager.getTemplateModelKt();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }


    @Override
    public List<Template> getMvpActivityTemplateList(TemplateManager templateManager) {
        //kotlin act 模版
        Template templateActKt = templateManager.getTemplateActKt();
        //kotlin contract 模版
        Template templateContractKt = templateManager.getTemplateContractKt();
        //kotlin presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterKt();
        //kotlin model 模版
        Template templateModelKt = templateManager.getTemplateModelKt();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateActKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }

    @Override
    public List<Template> getMvpFragmentTemplateList(TemplateManager templateManager) {
        //kotlin fragment 模版
        Template templateFragmentKt = templateManager.getTemplateFragmentKt();
        //kotlin contract 模版
        Template templateContractKt = templateManager.getTemplateContractKt();
        //kotlin presenter 模版
        Template templatePresenterKt = templateManager.getTemplatePresenterKt();
        //kotlin model 模版
        Template templateModelKt = templateManager.getTemplateModelKt();

        ArrayList<Template> templateList = new ArrayList<>();
        templateList.add(templateFragmentKt);
        templateList.add(templateContractKt);
        templateList.add(templatePresenterKt);
        templateList.add(templateModelKt);
        return templateList;
    }


}
