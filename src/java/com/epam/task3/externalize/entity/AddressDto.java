package com.epam.task3.externalize.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressDto implements Externalizable {
    private String country;
    private String city;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(country);
        out.writeObject(city);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        country = (String) in.readObject();
        city = (String) in.readObject();
    }
}
