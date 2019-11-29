package com.qf.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Goods {
    private Integer gid;
    private String gname;
    private Float gprice;
    private String gimg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gcreatetime;
    private Integer gstatus;
    private String gproperty;

}
