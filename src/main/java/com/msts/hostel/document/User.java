package com.msts.hostel.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
    private String type;
    private boolean active;
}
