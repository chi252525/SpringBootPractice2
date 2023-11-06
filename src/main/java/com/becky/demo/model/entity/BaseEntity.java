package com.becky.demo.model.entity;

import lombok.Data;
import org.joda.time.DateTime;
@Data
public class BaseEntity {
    private DateTime createTimeStamp;
    private DateTime updateTimeStamp;
}
