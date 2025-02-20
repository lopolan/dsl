package cn.yematech.heaver.api.dto;

import cn.yematech.heaver.api.filter.*;
import java.io.Serializable;


public class QuotaCriteria implements Serializable {
    private static final long serialVersionUID = 1L;
      private StringFilter id;
      private StringFilter createdBy;
      private StringFilter createdById;
      private LocalDateTimeFilter createdDate;
      private StringFilter lastModifiedBy;
      private StringFilter lastModifiedById;
      private LocalDateTimeFilter lastModifiedDate;
      public StringFilter getId() {
        return id;
      }

      public QuotaCriteria setId(StringFilter id) {
        this.id = id;
        return this;
      }

      public StringFilter getCreatedBy() {
        return createdBy;
      }

      public QuotaCriteria setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
        return this;
      }

      public StringFilter getCreatedById() {
        return createdById;
      }

      public QuotaCriteria setCreatedById(StringFilter createdById) {
        this.createdById = createdById;
        return this;
      }

      public LocalDateTimeFilter getCreatedDate() {
        return createdDate;
      }

      public QuotaCriteria setCreatedDate(LocalDateTimeFilter createdDate) {
        this.createdDate = createdDate;
        return this;
      }

      public StringFilter getLastModifiedBy() {
        return lastModifiedBy;
      }

      public QuotaCriteria setLastModifiedBy(StringFilter lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
      }

      public StringFilter getLastModifiedById() {
        return lastModifiedById;
      }

      public QuotaCriteria setLastModifiedById(StringFilter lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
        return this;
      }

      public LocalDateTimeFilter getLastModifiedDate() {
        return lastModifiedDate;
      }

      public QuotaCriteria setLastModifiedDate(LocalDateTimeFilter lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
      }

      private StringFilter code;
    public QuotaCriteria setCode(StringFilter code) {
        this.code=code;
        return this;
    }
    public StringFilter getCode() {
        return this.code;
    }
          private StringFilter name;
    public QuotaCriteria setName(StringFilter name) {
        this.name=name;
        return this;
    }
    public StringFilter getName() {
        return this.name;
    }
          private StringFilter unit;
    public QuotaCriteria setUnit(StringFilter unit) {
        this.unit=unit;
        return this;
    }
    public StringFilter getUnit() {
        return this.unit;
    }
    }
