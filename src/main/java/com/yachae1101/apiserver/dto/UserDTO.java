package com.yachae1101.apiserver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private long id;
    private String name;
    private String phone;
    private String birthday;
}
