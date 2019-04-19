package com.ljb.mvp.plugin.menu;

import com.ljb.mvp.plugin.TemplateEnum;
import org.apache.http.util.TextUtils;

import javax.swing.*;
import java.awt.event.*;

public class CreateMvpDialog extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField;
    private JRadioButton btnAct;
    private JRadioButton btnFragment;
    private JRadioButton btnFragmentAct;
    private JRadioButton btnAppCompatAct;

    private CreateCallBack callBackListener;

    public void setCallBackListener(CreateCallBack call) {
        this.callBackListener = call;
    }

    public CreateMvpDialog() {
        setTitle("input module name");
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String moduleName = textField.getText().trim();
        boolean isAct = btnAct.isSelected();
        boolean isFragemnt = btnFragment.isSelected();
        boolean isFragmentAct = btnFragmentAct.isSelected();
        boolean isAppCompatAct = btnAppCompatAct.isSelected();
        TemplateEnum mvpType = TemplateEnum.Act;
        if (!TextUtils.isEmpty(moduleName)) {
            if (isAct) mvpType = TemplateEnum.Act;
            if (isFragemnt) mvpType = TemplateEnum.Fragment;
            if (isFragmentAct) mvpType = TemplateEnum.FragmentAct;
            if (isAppCompatAct) mvpType = TemplateEnum.AppCompatAct;
            dispose();
            if (callBackListener != null) {
                callBackListener.onCall(moduleName, mvpType);
            }
        }else {
            dispose();
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CreateMvpDialog dialog = new CreateMvpDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    interface CreateCallBack {
        void onCall(String name, TemplateEnum type);
    }
}
