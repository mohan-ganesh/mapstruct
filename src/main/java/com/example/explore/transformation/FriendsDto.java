
package com.example.explore.transformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendsDto {
    public long id;
    public String firstName;
    public String lastName;
    public String emailId;

}
