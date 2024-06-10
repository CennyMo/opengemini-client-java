package utils;

import io.opengemini.client.api.Address;

import java.util.Arrays;
import java.util.List;

public class TestUtil {
    public static List<Address> getLocalAddress() {
        return Arrays.asList(new Address("127.0.0.1", 8086));
    }
}
