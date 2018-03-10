package com.springboot.springbootservices.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "titles")
@Data
public class Title {

    @EmbeddedId
    private TitleId titleId;

    @Column(name = "to_date")
    private Date toDate;
}
