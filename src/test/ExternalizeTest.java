import com.epam.task3.externalize.entity.AddressDto;
import com.epam.task3.externalize.entity.UserDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizeTest {
    @Test
    public void externalizeTest(){
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry("Belarus");
        addressDto.setCity("Minsk");
        userDto.setName("Siarhey");
        userDto.setAge(30);
        userDto.setAddressDto(addressDto);
        try (
                FileOutputStream fileOut = new FileOutputStream("test.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ) {
            out.writeObject(userDto);
        }catch (IOException i) {
            System.out.println(i.getMessage());
        }
        try (
                FileInputStream fileIn = new FileInputStream("test.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
        ) {
            UserDto userDtoExternalize = (UserDto)in.readObject();
            Assert.assertEquals(userDtoExternalize.getAge(),0);
            Assert.assertEquals(userDtoExternalize.getAddressDto(),userDto.getAddressDto());
            System.out.println("Before serialization :" + userDto);
            System.out.println("After serialization  :" + userDtoExternalize);
        } catch (IOException i) {
            System.out.println(i.getMessage());
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        }
    }

    }

