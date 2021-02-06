package osp.leobert.plugin.mdm.component;

import com.intellij.notification.Notification;
import com.intellij.openapi.project.Project;
import osp.leobert.plugin.mdm.task.DepsFileScanTask;
import osp.leobert.plugin.mdm.task.Runner;

import java.util.logging.Logger;

/**
 * <p><b>Package:</b> osp.leobert.plugin.mdm.component </p>
 * <p><b>Classname:</b> MdmProjectComponentImpl </p>
 * Created by leobert on 2021/2/6.
 */
public class MdmProjectComponentImpl implements MdmProjectComponent {
    static Logger logger = Logger.getLogger("MDM-Comp");

    Project project;

    public MdmProjectComponentImpl(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        logger.info("project opened");
//        Notification.
        Runner.run(project, new DepsFileScanTask(project));

    }


}
