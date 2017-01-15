package com.yasan.transformer;


/**
 * Created by pooya on 1/13/17.
 */

import com.yasan.exceptions.CanNotTransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class BasicTransformer {

    @Autowired
    private List<BeanTransformer> transformers;

    private Map<String, BeanTransformer> BeanTransformerMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (BeanTransformer transformer : transformers) {
            String s = transformer.getOutboundTypeArgument().getName() + transformer.getInboundTypeArgument().getName();
            BeanTransformerMap.put(s, transformer);
        }
    }

    public <E, T> List<T> convert(Iterable<E> o, Class<T> resultClass) {
        List<E> lst = new ArrayList<>();

        for (E e : o) {
            lst.add(e);
        }
        return convert(lst, resultClass);
    }

    public <E, T> List<T> convert(List<E> o, Class<T> resultClass) {
        List<T> ts = new ArrayList<>();
        for (E e : o) {
            T convert = convert(e, resultClass);
            ts.add(convert);
        }
        return ts;
    }

    public <E, T> T convert(E o, Class<T> resultClass) {
        String s = resultClass.getName() + o.getClass().getName();

        BeanTransformer transformer = BeanTransformerMap.get(s);
        if (transformer == null) {
            throw new CanNotTransformException("Can not transform type " + o.getClass().getName() + " to " + resultClass.getName());
        }
        return (T) transformer.convert(o);
    }
}