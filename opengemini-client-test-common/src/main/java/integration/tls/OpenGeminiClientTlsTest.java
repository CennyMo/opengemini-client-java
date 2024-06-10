package integration.tls;

import io.opengemini.client.api.TlsConfig;
import io.opengemini.client.common.BaseAsyncClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class OpenGeminiClientTlsTest {
    static final String ABSOLUTE_RESOURCE_PATH =
        OpenGeminiClientTlsTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    static final String KEYSTORE_JKS_PATH = ABSOLUTE_RESOURCE_PATH + "/jks/keystore.jks";
    static final String TRUSTSTORE_JKS_PATH = ABSOLUTE_RESOURCE_PATH + "/jks/truststore.jks";
    static final String JKS_PASSWORD = "TestOpenGemini@#123";

    protected abstract <T extends BaseAsyncClient> T createTlsClient(TlsConfig tlsConfig);

    @Test
    protected void testEnableTlsVerify() {
        BaseAsyncClient tlsClient = createTlsClient(getTlsConfig());
        try {
            tlsClient.ping().get();
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    private TlsConfig getTlsConfig() {
        TlsConfig tlsConfig = new TlsConfig();
        tlsConfig.setTlsVersions(new String[] {"TLSv1.3", "TLSv1.2"});
        tlsConfig.setKeyStorePath(KEYSTORE_JKS_PATH);
        tlsConfig.setKeyStorePassword(JKS_PASSWORD);
        tlsConfig.setTrustStorePath(TRUSTSTORE_JKS_PATH);
        tlsConfig.setTrustStorePassword(JKS_PASSWORD);
        tlsConfig.setTlsVerifyDisabled(false);
        tlsConfig.setTlsHostnameVerifyDisabled(true);
        return tlsConfig;
    }
}
