package cn.yematech.heaver.api.dto;

import cn.yematech.heaver.api.filter.*;

import java.math.BigDecimal;

public class QuotaWordCriteria implements Serializable{
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

      public QuotaWordCriteria setId(StringFilter id) {
        this.id = id;
        return this;
      }

      public StringFilter getCreatedBy() {
        return createdBy;
      }

      public QuotaWordCriteria setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
        return this;
      }

      public StringFilter getCreatedById() {
        return createdById;
      }

      public QuotaWordCriteria setCreatedById(StringFilter createdById) {
        this.createdById = createdById;
        return this;
      }

      public LocalDateTimeFilter getCreatedDate() {
        return createdDate;
      }

      public QuotaWordCriteria setCreatedDate(LocalDateTimeFilter createdDate) {
        this.createdDate = createdDate;
        return this;
      }

      public StringFilter getLastModifiedBy() {
        return lastModifiedBy;
      }

      public QuotaWordCriteria setLastModifiedBy(StringFilter lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
      }

      public StringFilter getLastModifiedById() {
        return lastModifiedById;
      }

      public QuotaWordCriteria setLastModifiedById(StringFilter lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
        return this;
      }

      public LocalDateTimeFilter getLastModifiedDate() {
        return lastModifiedDate;
      }

      public QuotaWordCriteria setLastModifiedDate(LocalDateTimeFilter lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
      }

      private BigDecimalFilter degree
    public QuotaWordCriteria setDegree(BigDecimalFilter degree) {
        this.degree=degree;
        return this;
    }
    public BigDecimalFilter getDegree() {
        return this.degree;
    }
          private StringFilter refId
    public QuotaWordCriteria setRefId(StringFilter refId) {
        this.refId=refId;
        return this;
    }
    public StringFilter getRefId() {
        return this.refId;
    }
          private StringFilter wordId
    public QuotaWordCriteria setWordId(StringFilter wordId) {
        this.wordId=wordId;
        return this;
    }
    public StringFilter getWordId() {
        return this.wordId;
    }
    }
