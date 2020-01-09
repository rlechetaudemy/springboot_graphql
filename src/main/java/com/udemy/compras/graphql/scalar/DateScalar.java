package com.udemy.compras.graphql.scalar;

import com.udemy.compras.utils.DateUtils;
import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateScalar extends GraphQLScalarType {
    private static final String NAME = "Date";

    public DateScalar() {
        super(NAME, "Date type", new Coercing<Date, String>() {

            @Override
            public String serialize(Object input) {
                if (input instanceof Date) {
                   return DateUtils.toString((Date) input);
                }
                throw new CoercingSerializeException("Invalid Date: " + input);
            }

            @Override
            public Date parseValue(Object input) {
                if (input instanceof String) {
                    Date dt = DateUtils.toDate((String) input);
                    if(dt != null) {
                        return dt;
                    }
                }
                throw new CoercingParseValueException("Invalid Date: " + input);
            }

            @Override
            public Date parseLiteral(Object input) {
                if (!(input instanceof StringValue)) return null;
                String s = ((StringValue) input).getValue();
                Date dt = DateUtils.toDate(s);
                if(dt != null) {
                    return dt;
                }
                throw new CoercingParseLiteralException("Invalid Date: " + input);
            }
        });
    }
}
