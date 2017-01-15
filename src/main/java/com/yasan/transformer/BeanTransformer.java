package com.yasan.transformer;

import org.springframework.core.GenericTypeResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pooya on 1/13/17.
 */
public abstract class BeanTransformer<S, D> {
    private Class<S> inboundTypeArgument = (Class<S>) GenericTypeResolver.resolveTypeArguments(this.getClass(), BeanTransformer.class)[0];
    private Class<D> outboundTypeArgument = (Class<D>) GenericTypeResolver.resolveTypeArguments(this.getClass(), BeanTransformer.class)[1];

    public abstract D convert(S source, Object parent);

    public D convert(S source) {
        return convert(source, null);
    }

    public List<D> convert(List<S> sList) {
        return convert(sList, null);
    }

    public List<D> convert(List<S> sList, Object parent) {
        if (sList == null) {
            return null;
        }
        return sList.stream().map(s -> convert(s, parent)).collect(Collectors.toList());
    }

    public Class<S> getInboundTypeArgument() {
        return inboundTypeArgument;
    }

    public Class<D> getOutboundTypeArgument() {
        return outboundTypeArgument;
    }
}
