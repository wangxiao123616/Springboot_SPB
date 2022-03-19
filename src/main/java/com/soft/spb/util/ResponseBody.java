package com.soft.spb.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {

    private Object data;

    private Integer code;

    private String message;

}
