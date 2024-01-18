package com.rdLessons.multiLayerErrorHandling.repository.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    private String name;
    private  String surname;
    private  int age;
    private String username;


}
