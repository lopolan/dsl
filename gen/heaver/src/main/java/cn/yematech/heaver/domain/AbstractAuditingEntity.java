package cn.yematech.heaver.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  @TableId
  private String id;
  @TableField(fill = FieldFill.INSERT)
  private String createdBy;
  @TableField(fill = FieldFill.INSERT)
  private String createdById;
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createdDate;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String lastModifiedBy;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String lastModifiedById;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime lastModifiedDate;
  @TableLogic
  @JsonIgnore
  private boolean isDelete;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedById() {
    return createdById;
  }

  public void setCreatedById(String createdById) {
    this.createdById = createdById;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public String getLastModifiedById() {
    return lastModifiedById;
  }

  public void setLastModifiedById(String lastModifiedById) {
    this.lastModifiedById = lastModifiedById;
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public boolean getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(boolean isDelete) {
    this.isDelete = isDelete;
  }

  @Override
  public String toString() {
    return "AbstractAuditingEntity{" +
        "id=" + id +
        ", createdBy='" + createdBy + '\'' +
        ", createdById='" + createdById + '\'' +
        ", createdDate=" + createdDate +
        ", lastModifiedBy='" + lastModifiedBy + '\'' +
        ", lastModifiedById='" + lastModifiedById + '\'' +
        ", lastModifiedDate=" + lastModifiedDate +
        '}';
  }
}
