package osp.leobert.plugin.mdm.notify;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.ui.MessageType;

/**
 * <p><b>Package:</b> osp.leobert.plugin.mdm.notify </p>
 * <p><b>Classname:</b> Notify </p>
 * Created by leobert on 2021/2/6.
 */
public class Notify {
    public static void show(String info) {
        NotificationGroup group = new NotificationGroup("MDM.Notify", NotificationDisplayType.BALLOON, true);
        Notification notification = group.createNotification(info, MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
}
