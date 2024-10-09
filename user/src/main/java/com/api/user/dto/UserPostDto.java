package com.api.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class UserPostDto {

    private Long id;
    private String name;
    private String email;
    private String position;
    private String createdDate;

}
