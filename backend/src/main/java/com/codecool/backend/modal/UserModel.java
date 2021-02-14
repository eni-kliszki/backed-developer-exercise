package com.codecool.backend.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserModel {
    private String name;
    private Location location;
    private String pictureURL;

}
