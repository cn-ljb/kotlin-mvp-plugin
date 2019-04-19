package com.ljb.mvp.plugin.menu;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.ljb.mvp.plugin.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionAct extends AnAction {

    private Project project;
    private String packageName;
    private String moduleName;

    @Override
    public void actionPerformed(AnActionEvent event) {
        project = event.getData(PlatformDataKeys.PROJECT);
        packageName = getPackageName();
        showDialog();
    }

    private void showDialog() {
        CreateMvpDialog dialog = new CreateMvpDialog();
        dialog.setCallBackListener((name, type) -> {
            moduleName = name;
            switch (type) {
                case Act:
                    createMvpActivity();
                    break;
                case Fragment:
                    createMvpFragment();
                    break;
                case FragmentAct:
                    createMvpFragmentActivity();
                    break;
                case AppCompatAct:
                    createMvpAppCompatActivity();
                    break;
            }
        });
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createMvpAppCompatActivity() {
        String appPath = getAppPath();
        //创建Act
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TMvpAppCompatActivity.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = appPath + "/act";
        String actFileName = moduleName + "Activity.kt";
        //创建Contract
        InputStream tContractInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TContract.txt");
        String tContractContent = FileUtils.readTemplateFile(tContractInput);
        String contractDir = appPath + "/contract";
        String contractFileName = moduleName + "Contract.kt";
        //创建Presenter
        InputStream tPresenterInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TPresenter.txt");
        String tPresenterContent = FileUtils.readTemplateFile(tPresenterInput);
        String presenterDir = appPath + "/presenter";
        String presenterFileName = moduleName + "Presenter.kt";

        actFileCreate(tActContent, actDir, actFileName, tContractContent, contractDir, contractFileName, tPresenterContent, presenterDir, presenterFileName);
    }

    private void createMvpFragmentActivity() {
        String appPath = getAppPath();
        //创建Act
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TMvpFragmentActivity.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = appPath + "/act";
        String actFileName = moduleName + "Activity.kt";

        //创建Contract
        InputStream tContractInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TContract.txt");
        String tContractContent = FileUtils.readTemplateFile(tContractInput);
        String contractDir = appPath + "/contract";
        String contractFileName = moduleName + "Contract.kt";

        //创建Presenter
        InputStream tPresenterInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TPresenter.txt");
        String tPresenterContent = FileUtils.readTemplateFile(tPresenterInput);
        String presenterDir = appPath + "/presenter";
        String presenterFileName = moduleName + "Presenter.kt";

        actFileCreate(tActContent, actDir, actFileName, tContractContent, contractDir, contractFileName, tPresenterContent, presenterDir, presenterFileName);
    }


    private void createMvpActivity() {
        String appPath = getAppPath();
        //创建Act
        InputStream tMvpActInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TMvpActivity.txt");
        String tActContent = FileUtils.readTemplateFile(tMvpActInput);
        String actDir = appPath + "/act";
        String actFileName = moduleName + "Activity.kt";

        //创建Contract
        InputStream tContractInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TContract.txt");
        String tContractContent = FileUtils.readTemplateFile(tContractInput);
        String contractDir = appPath + "/contract";
        String contractFileName = moduleName + "Contract.kt";

        //创建Presenter
        InputStream tPresenterInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TPresenter.txt");
        String tPresenterContent = FileUtils.readTemplateFile(tPresenterInput);
        String presenterDir = appPath + "/presenter";
        String presenterFileName = moduleName + "Presenter.kt";

        actFileCreate(tActContent, actDir, actFileName, tContractContent, contractDir, contractFileName, tPresenterContent, presenterDir, presenterFileName);
    }

    private void createMvpFragment() {
        String appPath = getAppPath();
        //创建Fragment
        InputStream tFragmentInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TMvpFragment.txt");
        String tFragmentContent = FileUtils.readTemplateFile(tFragmentInput);
        String fragmentDir = appPath + "/fragment";
        String fragmentFileName = moduleName + "Fragment.kt";

        //创建Contract
        InputStream tContractInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TContract.txt");
        String tContractContent = FileUtils.readTemplateFile(tContractInput);
        String contractDir = appPath + "/contract";
        String contractFileName = moduleName + "Contract.kt";

        //创建Presenter
        InputStream tPresenterInput = this.getClass().getResourceAsStream("/com/ljb/mvp/plugin/template/TPresenter.txt");
        String tPresenterContent = FileUtils.readTemplateFile(tPresenterInput);
        String presenterDir = appPath + "/presenter";
        String presenterFileName = moduleName + "Presenter.kt";

        fragmentFileCreate(tFragmentContent, fragmentDir, fragmentFileName, tContractContent, contractDir, contractFileName, tPresenterContent, presenterDir, presenterFileName);

    }

    private void fragmentFileCreate(String tFragmentContent, String fragmentDir, String fragmentFileName, String tContractContent, String contractDir, String contractFileName, String tPresenterContent, String presenterDir, String presenterFileName) {
        if (checkFile(new File(fragmentDir, fragmentFileName), new File(contractDir, contractFileName), new File(presenterDir, presenterFileName))) {
            createFile(tFragmentContent, fragmentDir, fragmentFileName);
            createFile(tContractContent, contractDir, contractFileName);
            createFile(tPresenterContent, presenterDir, presenterFileName);
            Messages.showMessageDialog(project, moduleName + "Fragment create success!", "Information", Messages.getInformationIcon());
        }
    }

    private void actFileCreate(String tActContent, String actDir, String actFileName, String tContractContent, String contractDir, String contractFileName, String tPresenterContent, String presenterDir, String presenterFileName) {
        if (checkFile(new File(actDir, actFileName), new File(contractDir, contractFileName), new File(presenterDir, presenterFileName))) {
            createFile(tActContent, actDir, actFileName);
            createFile(tContractContent, contractDir, contractFileName);
            createFile(tPresenterContent, presenterDir, presenterFileName);
            Messages.showMessageDialog(project, moduleName + "Activity create success!", "Information", Messages.getInformationIcon());
        }
    }

    private boolean checkFile(File file, File file1, File file2) {
        if (file.exists()) {
            Messages.showMessageDialog(project, file.getName() + " file already exists!", "Error", Messages.getErrorIcon());
            return false;
        }
        if (file1.exists()) {
            Messages.showMessageDialog(project, file1.getName() + " file already exists!", "Error", Messages.getErrorIcon());
            return false;
        }
        if (file2.exists()) {
            Messages.showMessageDialog(project, file2.getName() + " file already exists!", "Error", Messages.getErrorIcon());
            return false;
        }
        return true;
    }


    private void createFile(String tContent, String dir, String fileName) {
        String fillContent = FileUtils.fillTemplateContent(tContent, moduleName, packageName, getDate());
        FileUtils.writeToFile(fillContent, dir, fileName);
    }


    private String getAppPath() {
        String packagePath = packageName.replace(".", "/");
        return project.getBasePath() + "/App/src/main/java/" + packagePath + "/";
    }


    private String getDate() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }


    private String getPackageName() {
        String package_name = "";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(project.getBasePath() + "/App/src/main/AndroidManifest.xml");

            NodeList nodeList = doc.getElementsByTagName("manifest");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                package_name = element.getAttribute("package");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return package_name;
    }
}
