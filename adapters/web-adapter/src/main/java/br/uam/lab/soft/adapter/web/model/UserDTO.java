package br.uam.lab.soft.adapter.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("direction")
    private String address;

}
