package osp.leobert.plugin.mdm.task;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import osp.leobert.plugin.mdm.notify.Notify;
import osp.leobert.plugin.mdm.ui.CreateConfigDialog;

import java.awt.*;

/**
 * <p><b>Package:</b> osp.leobert.plugin.mdm.task </p>
 * <p><b>Classname:</b> DepsFileScanTask </p>
 * Created by leobert on 2021/2/6.
 */
public class DepsFileScanTask extends Task.Backgroundable {
    public DepsFileScanTask(@Nullable Project project) {
        //@Nls(capitalization = Nls.Capitalization.Sentence) @NotNull String title
        super(project, "DepsFileScanTask");
    }

    @Override
    public void run(@NotNull ProgressIndicator progressIndicator) {
        progressIndicator.start();
        try {
            VirtualFile file = getProject().getProjectFile().getParent().getParent().findChild("dependency.gradle");
            System.out.println(file.getName());
            boolean fileExist = file != null && file.exists();
            Notify.show("dependency.gradle exist? " + fileExist);

            if (!fileExist) {
                CreateConfigDialog dialog = new CreateConfigDialog();
                dialog.setResizable(true);
                dialog.setMinimumSize(new Dimension(300,120));
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

//                Messages.showYesNoDialog(getProject(), "create dependency.gradle file?", "Config Not Found", "yes", "no", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Notify.show("dependency.gradle exist check exception");
        } finally {
            progressIndicator.cancel();
        }

    }
}
