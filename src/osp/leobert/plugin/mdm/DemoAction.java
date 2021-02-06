package osp.leobert.plugin.mdm;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * <p><b>Package:</b> osp.leobert.plugin.mdm </p>
 * <p><b>Classname:</b> DemoAction </p>
 * Created by leobert on 2021/2/6.
 */
public class DemoAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        Messages.showInputDialog(
                project,
                "What is your name?",
                "Input your name",
                Messages.getQuestionIcon());
    }
}