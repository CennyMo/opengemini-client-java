package integration.tls;

import io.opengemini.client.api.TlsConfig;

public abstract class TlsTest {
    static final String KEYSTORE_JKS = "jks/keystore.jks";
    static final String TRUSTSTORE_JKS = "jks/truststore.jks";
    static final String JKS_PASSWORD = "123456";
    static final String TEST_JKS_PATH = "src/test/resources/";

    public abstract void testEnableTlsVerify();

    static TlsConfig getBasicTlsConfig() {
        TlsConfig tlsConfig = new TlsConfig();
        tlsConfig.tlsVersions = new String[]{"TLSv1.3"};
        tlsConfig.tlsCipherSuites = new String[]{"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256"};
        return tlsConfig;
    }
}
