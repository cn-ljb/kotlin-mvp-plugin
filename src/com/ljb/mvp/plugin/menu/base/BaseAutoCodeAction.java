package com.ljb.mvp.plugin.menu.base;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.ljb.mvp.plugin.TemplateEnum;
import com.ljb.mvp.plugin.menu.CreateMvpDialog;
import com.ljb.mvp.plugin.template.bean.Template;
import com.ljb.mvp.plugin.utils.DateUtils;
import com.ljb.mvp.plugin.utils.FileUtils;
import com.ljb.mvp.plugin.utils.PackageManager;
import com.ljb.mvp.plugin.utils.TemplateManager;
import org.apache.http.util.TextUtils;

import java.io.File;
import java.util.List;

public abstract class BaseAutoCodeAction extends AnAction {

    private Project project;
    private String moduleName;
    private String idePath;
    private String pathPackageName;

    @Override
    public void actionPerformed(AnActionEvent event) {
        project = event.getData(PlatformDataKeys.PROJECT);
        idePath = FileUtils.getCursorPath(event);
        idePath = FileUtils.checkPath(idePath);
        pathPackageName = PackageManager.getPathPackageName(PackageManager.getAppPackageName(project), idePath);
        if (TextUtils.isEmpty(pathPackageName)) {
            Messages.showMessageDialog(project, "dir is error!", "Error", Messages.getErrorIcon());
            return;
        }
        showDialog();
    }

    private void showDialog() {
        CreateMvpDialog dialog = new CreateMvpDialog();
        dialog.setCallBackListener(this::handleTemplateOption);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void handleTemplateOption(String name, TemplateEnum type) {
        moduleName = name;
        TemplateManager templateManager = new TemplateManager(this, idePath, moduleName);
        List<Template> templateList = null;
        switch (type) {
            case Act:
                templateList = getMvpActivityTemplateList(templateManager);
                break;
            case Fragment:
                templateList = getMvpFragmentTemplateList(templateManager);
                break;
            case FragmentAct:
                templateList = getMvpFragmentActivityTemplateList(templateManager);
                break;
            case AppCompatAct:
                templateList = getMvpAppCompatActivityTemplateList(templateManager);
                break;
        }
        if (templateList == null) {
            Messages.showMessageDialog(project, "not found template!", "Error", Messages.getErrorIcon());
        } else {
            createTemplateList(type, templateList);
        }
    }

    /**
     * 遍历模版列表并创建文件
     */
    private void createTemplateList(TemplateEnum type, List<Template> templateList) {
        if (!checkFileExists(templateList)) return;
        for (Template template : templateList) {
            createTemplateFile(template);
        }
        Messages.showMessageDialog(project, moduleName + type.value + " create success!", "Information", Messages.getInformationIcon());
    }

    private boolean checkFileExists(List<Template> templateList) {
        for (Template template : templateList) {
            if (template.getFile().exists()) {
                Messages.showMessageDialog(project, template.getFile().getName() + " file already exists!", "Error", Messages.getErrorIcon());
                return false;
            }
        }
        return true;
    }

    private void createTemplateFile(Template template) {
        String fillContent = FileUtils.fillTemplateContent(template.getContent(), moduleName, pathPackageName, DateUtils.getCurDate());
        FileUtils.writeToFile(fillContent, template.getDir(), template.getFileName());
    }


    public abstract List<Template> getMvpAppCompatActivityTemplateList(TemplateManager templateManager);

    public abstract List<Template> getMvpFragmentActivityTemplateList(TemplateManager templateManager);

    public abstract List<Template> getMvpActivityTemplateList(TemplateManager templateManager);

    public abstract List<Template> getMvpFragmentTemplateList(TemplateManager templateManager);

}
