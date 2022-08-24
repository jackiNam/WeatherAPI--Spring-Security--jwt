package com.java.namle.weatherAPI.modelEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Spring Data JPA cung cấp @CreatedBy, @LastModifiedBy để nắm bắt user đã tạo hoặc sửa đổi entity cũng như @CreatedDate và @LastModifiedDate nắm bắt được vào thời điểm nào điều này xảy ra.
//@MappedSuperclass để cho phép một thực thể kế thừa các thuộc tính từ một lớp cơ sở.không có bảng nào tồn tại cho chính siêu lớp

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CreatedDate implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
	    @org.springframework.data.annotation.CreatedDate
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_date")
	    private Date createdDate;

	   
	    public Date getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(Date createdDate) {
	        this.createdDate = createdDate;
	    }

	    
	}

