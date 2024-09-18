package com.virus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class API_Error {

    private Date timestamp = new Date();

    private int status_code;

    private String message;

}