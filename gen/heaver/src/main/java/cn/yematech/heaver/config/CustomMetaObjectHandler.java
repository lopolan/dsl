package ${backPackage}.autoconfig;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

public class CustomMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    strictInsertFill(metaObject, "createdDate", LocalDateTime::now, LocalDateTime.class);
    strictInsertFill(metaObject, "createdBy",
        () -> CurrentUserHelper.currentUser().getRealName(), String.class);
    strictInsertFill(metaObject, "createdById",
        () -> CurrentUserHelper.currentUser().getUserId(), String.class);
    strictInsertFill(metaObject, "lastModifiedDate", LocalDateTime::now, LocalDateTime.class);
    strictInsertFill(metaObject, "lastModifiedBy",
        () -> CurrentUserHelper.currentUser().getRealName(), String.class);
    strictInsertFill(metaObject, "lastModifiedById",
        () -> CurrentUserHelper.currentUser().getUserId(), String.class);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    setFieldValByName("lastModifiedDate", LocalDateTime.now(), metaObject);
    setFieldValByName("lastModifiedBy", CurrentUserHelper.currentUser().getRealName(),
        metaObject);
    setFieldValByName("lastModifiedById", CurrentUserHelper.currentUserId(), metaObject);
  }
}
