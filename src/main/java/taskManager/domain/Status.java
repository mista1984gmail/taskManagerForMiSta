package taskManager.domain;

import java.io.Serializable;

public enum Status implements Serializable {
     APPOINTED, //назначена
     IN_PROCESS,//в процессе выполнения
    COMPLETED,//сдана
    NOT_COMPLETED,//не сдана
    DELETED,//удалена

}
