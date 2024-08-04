package io.opengemini.client.reactor;

import io.opengemini.client.api.BaseConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import reactor.netty.transport.NameResolverProvider;
import java.util.function.Consumer;

@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
public class Configuration extends BaseConfiguration {
    public Consumer<NameResolverProvider.NameResolverSpec> addressResolverGroup;
}
