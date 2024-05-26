package integration.tls;

import io.opengemini.client.api.Address;
import io.opengemini.client.api.OpenGeminiException;
import io.opengemini.client.api.TlsConfig;
import io.opengemini.client.okhttp.Configuration;
import io.opengemini.client.okhttp.OpenGeminiOkhttpClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collections;

public class OkhttpClientTlsTest extends TlsTest {
    @Override
    @Test
    public void testEnableTlsVerify() {
        TlsConfig tlsConfig = getBasicTlsConfig();

        // test tls config with key store and trust store
        tlsConfig.setKeyStorePath(TEST_JKS_PATH + "jks/keystore.jks");
        tlsConfig.setKeyStorePassword(JKS_PASSWORD);
        tlsConfig.setTrustStorePath(TEST_JKS_PATH + "jks/truststore.jks");
        tlsConfig.setTrustStorePassword(JKS_PASSWORD);
        tlsConfig.setTlsVerifyDisabled(false);
        Configuration configuration = Configuration.builder().addresses(Collections.singletonList(new Address("127.0.0.1", 8086))).connectTimeout(Duration.ofSeconds(3)).timeout(Duration.ofSeconds(5)).tlsEnabled(true).tlsConfig(tlsConfig).build();
        try {
            OpenGeminiOkhttpClientFactory.create(configuration);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void testGetClientWithoutTrustStoreConfigButEnableTlsVerification() {
        TlsConfig tlsConfig = getBasicTlsConfig();

        // test enable tls verification but lack trust store config
        tlsConfig.setTlsVerifyDisabled(false);
        Configuration configuration = Configuration.builder()
                .addresses(Collections.singletonList(new Address("127.0.0.1", 8086)))
                .connectTimeout(Duration.ofSeconds(3)).timeout(Duration.ofSeconds(5)).tlsEnabled(true)
                .tlsConfig(tlsConfig).build();
        Assertions.assertThrows(OpenGeminiException.class, () -> OpenGeminiOkhttpClientFactory.create(configuration));
    }
}
