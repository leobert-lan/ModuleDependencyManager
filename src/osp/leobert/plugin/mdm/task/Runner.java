package osp.leobert.plugin.mdm.task;

import com.intellij.openapi.progress.BackgroundTaskQueue;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;

/**
 * <p><b>Package:</b> osp.leobert.plugin.mdm.task </p>
 * <p><b>Classname:</b> Runner </p>
 * Created by leobert on 2021/2/6.
 */
public class Runner {

    private static volatile BackgroundTaskQueue queue;

    private static synchronized BackgroundTaskQueue getQueue(Project project) {
        if (queue == null) {
            synchronized (Runner.class) {
                if (queue == null) {
                    queue = new BackgroundTaskQueue(project,project.getName()+"_btask_queue");
                }
            }
        }
        return queue;
    }

    public static void run(Project project, Task.Backgroundable backgroundable) {
        getQueue(project).run(backgroundable);
    }
}
