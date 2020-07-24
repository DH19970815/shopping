package org.shopping.boot.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class fileCommon implements Serializable {
    private String id;
    private String path;
    private String name;
    private String type;
    private char delFlag;
}
