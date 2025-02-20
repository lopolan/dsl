package cn.yematech.heaver.api.dto;

import cn.yematech.heaver.api.filter.*;


public class WordCriteria implements Serializable{
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

      public WordCriteria setId(StringFilter id) {
        this.id = id;
        return this;
      }

      public StringFilter getCreatedBy() {
        return createdBy;
      }

      public WordCriteria setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
        return this;
      }

      public StringFilter getCreatedById() {
        return createdById;
      }

      public WordCriteria setCreatedById(StringFilter createdById) {
        this.createdById = createdById;
        return this;
      }

      public LocalDateTimeFilter getCreatedDate() {
        return createdDate;
      }

      public WordCriteria setCreatedDate(LocalDateTimeFilter createdDate) {
        this.createdDate = createdDate;
        return this;
      }

      public StringFilter getLastModifiedBy() {
        return lastModifiedBy;
      }

      public WordCriteria setLastModifiedBy(StringFilter lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
      }

      public StringFilter getLastModifiedById() {
        return lastModifiedById;
      }

      public WordCriteria setLastModifiedById(StringFilter lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
        return this;
      }

      public LocalDateTimeFilter getLastModifiedDate() {
        return lastModifiedDate;
      }

      public WordCriteria setLastModifiedDate(LocalDateTimeFilter lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
      }

      private StringFilter text
    public WordCriteria setText(StringFilter text) {
        this.text=text;
        return this;
    }
    public StringFilter getText() {
        return this.text;
    }
    }
