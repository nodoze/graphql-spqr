package io.leangen.graphql.generator.mapping.common;

import graphql.schema.GraphQLInputType;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLOutputType;
import io.leangen.graphql.generator.BuildContext;
import io.leangen.graphql.generator.QueryGenerator;
import io.leangen.graphql.generator.mapping.TypeMapper;
import io.leangen.graphql.util.ClassUtils;

import java.lang.reflect.AnnotatedType;
import java.util.Collection;

/**
 * @author Bojan Tomic (kaqqao)
 */
public class ListMapper implements TypeMapper {

    @Override
    public GraphQLOutputType toGraphQLType(AnnotatedType javaType, BuildContext buildContext, QueryGenerator queryGenerator) {
        return new GraphQLList(queryGenerator.toGraphQLType(ClassUtils.getTypeArguments(javaType)[0], buildContext));
    }

    @Override
    public GraphQLInputType toGraphQLInputType(AnnotatedType javaType, BuildContext buildContext, QueryGenerator queryGenerator) {
        return new GraphQLList(queryGenerator.toGraphQLInputType(ClassUtils.getTypeArguments(javaType)[0], buildContext));
    }

    @Override
    public boolean supports(AnnotatedType type) {
        return ClassUtils.isSuperType(Collection.class, type.getType());
    }
}