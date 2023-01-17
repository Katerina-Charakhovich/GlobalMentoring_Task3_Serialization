package com.epam.task3.externalize.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto implements Externalizable {
    private String name;
    private int age;
    private AddressDto addressDto;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(addressDto);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        addressDto = (AddressDto) in.readObject();
    }
}
