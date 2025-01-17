/*
 * Copyright (c) 2006, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation
//
package org.eclipse.persistence.jpa.jpql;

import java.util.ListResourceBundle;

/**
 * The resource bundle containing the problems encountered in a JPQL query.
 *
 * @version 2.5.2
 * @since 2.3
 * @author Pascal Filion
 */
@SuppressWarnings("nls")
public final class JPQLQueryProblemResourceBundle extends ListResourceBundle {

    /**
     * The file name of the .properties file that is equivalent to this {@link ListResourceBundle}.
     */
    public static final String PROPERTIES_FILE_NAME = JPQLQueryProblemResourceBundle.class.getPackage().getName() + ".jpa_jpql_validation";

    /**
     * Default constructor.
     */
    public JPQLQueryProblemResourceBundle() {
        // for reflection
    }

    @Override
    protected Object[][] getContents() {

        Object[][] contents = {

            // AbsExpression - Grammar
            {"ABS_EXPRESSION_INVALID_EXPRESSION",         "The encapsulated expression is not a valid expression."},
            {"ABS_EXPRESSION_MISSING_EXPRESSION",         "The encapsulated expression must be provided for an ABS expression."},
            {"ABS_EXPRESSION_MISSING_LEFT_PARENTHESIS",   "The left parenthesis is missing from the ABS expression."},
            {"ABS_EXPRESSION_MISSING_RIGHT_PARENTHESIS",  "The right parenthesis is missing from the ABS expression."},
            // AbsExpression - Semantic
            {"ABS_EXPRESSION_INVALID_NUMERIC_EXPRESSION", "The encapsulated expression is not a valid numeric expression."},

            // AbstractFromClause - Grammar
            {"ABSTRACT_FROM_CLAUSE_IDENTIFICATION_VARIABLE_DECLARATION_ENDS_WITH_COMMA",  "The FROM clause cannot end with a comma."},
            {"ABSTRACT_FROM_CLAUSE_IDENTIFICATION_VARIABLE_DECLARATION_IS_MISSING_COMMA", "The FROM clause has ''{0}'' and ''{1}'' that are not separated by a comma."},
            {"ABSTRACT_FROM_CLAUSE_MISSING_IDENTIFICATION_VARIABLE_DECLARATION",          "The FROM clause must defined at least one identification variable declaration."},
            // AbstractFromClause - Semantic
            {"ABSTRACT_FROM_CLAUSE_INVALID_FIRST_IDENTIFICATION_VARIABLE_DECLARATION",    "''{0}'' cannot be the first declaration of the FROM clause."},
            {"ABSTRACT_FROM_CLAUSE_WRONG_ORDER_OF_IDENTIFICATION_VARIABLE_DECLARATION",   "The identification variable ''{0}'' is declared after its usage. Identification variables are evaluated from left to right."},

            // AbstractPathExpression - Grammar
            {"ABSTRACT_PATH_EXPRESSION_CANNOT_END_WITH_COMMA",           "A path expression cannot end with a comma."},
            {"ABSTRACT_PATH_EXPRESSION_INVALID_IDENTIFICATION_VARIABLE", "A path expression must start with a valid expression."},
            {"ABSTRACT_PATH_EXPRESSION_MISSING_IDENTIFICATION_VARIABLE", "A path expression must start with an identification variable."},

            // AbstractSchemaName - Grammar
            {"ABSTRACT_SCHEMA_NAME_INVALID",             "The abstract schema type ''{0}'' is unknown."},
            // AbstractSchemaName - Semantic
            {"PATH_EXPRESSION_NOT_RELATIONSHIP_MAPPING", "The derived path ''{0}'' does not represent an association field."},

            // AbstractSelectClause - Grammar
            {"ABSTRACT_SELECT_CLAUSE_INVALID_SELECT_EXPRESSION",          "The select expression is not a valid expression."},
            {"ABSTRACT_SELECT_CLAUSE_MISSING_SELECT_EXPRESSION",          "The select expression is missing from the SELECT clause."},
            {"ABSTRACT_SELECT_CLAUSE_SELECT_EXPRESSION_ENDS_WITH_COMMA",  "The select expression cannot end with a comma."},
            {"ABSTRACT_SELECT_CLAUSE_SELECT_EXPRESSION_IS_MISSING_COMMA", "The SELECT clause has ''{0}'' and ''{1}'' that are not separated by a comma."},
            {"ABSTRACT_SELECT_CLAUSE_SELECT_EXPRESSION_MALFORMED",        "The select expression is malformed."},

            // AbstractSelectStatement - Grammar
            {"ABSTRACT_SELECT_STATEMENT_FROM_CLAUSE_MSSING", "A select statement must have a FROM clause."},

            // AdditionExpression - Semantic
            {"ADDITION_EXPRESSION_LEFT_EXPRESSION_WRONG_TYPE",  "The left side of the addition is not a valid arithmetic expression."},
            {"ADDITION_EXPRESSION_RIGHT_EXPRESSION_WRONG_TYPE", "The right side of the addition is not a valid arithmetic expression."},

            // AggregateFunction - Grammar
            {"AGGREGATE_FUNCTION_WRONG_CLAUSE", "The {0} function is only allowed in the SELECT, GROUP BY, ORDER BY and HAVING clauses."},

            // AllOrAnyExpression - Grammar
            {"ALL_OR_ANY_EXPRESSION_INVALID_EXPRESSION",                "The encapsulated expression is not a valid expression."},
            {"ALL_OR_ANY_EXPRESSION_MISSING_EXPRESSION",                "The subquery must be provided for an {0} expression."},
            {"ALL_OR_ANY_EXPRESSION_MISSING_LEFT_PARENTHESIS",          "The left parenthesis is missing from the {0} expression."},
            {"ALL_OR_ANY_EXPRESSION_MISSING_RIGHT_PARENTHESIS",         "The right parenthesis is missing from the {0} expression."},
            {"ALL_OR_ANY_EXPRESSION_NOT_PART_OF_COMPARISON_EXPRESSION", "The {0} expression must be part of a comparison expression."},

            // ArithmeticFactor - Grammar
            {"ARITHMETIC_FACTOR_MISSING_EXPRESSION", "An arithmetic factor must be followed by an expression."},
            // ArithmeticFactor - Semantic
            {"ARITHMETIC_FACTOR_INVALID_EXPRESSION", "The expression must be an arithmetic expression."},

            // ArithmeticExpression - Grammar
            {"ARITHMETIC_EXPRESSION_INVALID_LEFT_EXPRESSION",  "The left expression is not an arithmetic expression."},
            {"ARITHMETIC_EXPRESSION_INVALID_RIGHT_EXPRESSION", "The right expression is not an arithmetic expression."},
            {"ARITHMETIC_EXPRESSION_MISSING_LEFT_EXPRESSION",  "The left expression is missing from the arithmetic expression."},
            {"ARITHMETIC_EXPRESSION_MISSING_RIGHT_EXPRESSION", "The right expression is missing from the arithmetic expression."},

            // AvgFunction - Grammar
            {"AVG_FUNCTION_INVALID_EXPRESSION",         "The encapsulated expression is not a valid expression."},
            {"AVG_FUNCTION_MISSING_LEFT_PARENTHESIS",   "The left parenthesis is missing from the AVG expression."},
            {"AVG_FUNCTION_MISSING_EXPRESSION",         "The encapsulated expression must be provided for an AVG expression."},
            {"AVG_FUNCTION_MISSING_RIGHT_PARENTHESIS",  "The right parenthesis is missing from the AVG expression."},
            // AvgFunction - Semantic
            {"AVG_FUNCTION_INVALID_NUMERIC_EXPRESSION", "The encapsulated expression is not a valid numeric expression."},

            // BadExpression
            {"BAD_EXPRESSION_INVALID_EXPRESSION", " The expression is invalid, which means it does not follow the JPQL grammar."},

            // BetweenExpression - Grammar
            {"BETWEEN_EXPRESSION_MISSING_EXPRESSION",             "The result expression is missing from the BETWEEN expression."},
            {"BETWEEN_EXPRESSION_MISSING_LOWER_BOUND_EXPRESSION", "The lower bound expression is missing from the BETWEEN expression."},
            {"BETWEEN_EXPRESSION_MISSING_AND",                    "The identifier AND is missing from the BETWEEN expression."},
            {"BETWEEN_EXPRESSION_MISSING_UPPER_BOUND_EXPRESSION", "The upper bound expression is missing from the BETWEEN expression."},
            // BetweenExpression - Semantic
            {"BETWEEN_EXPRESSION_WRONG_TYPE",                     "The expression's type and the lower and upper bound expressions' type have to be the same type."},

            // CaseExpression - Grammar
            {"CASE_EXPRESSION_INVALID_JPA_VERSION",         "A CASE expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"CASE_EXPRESSION_MISSING_ELSE_EXPRESSION",     "A CASE expression must have an ELSE expression."},
            {"CASE_EXPRESSION_MISSING_ELSE_IDENTIFIER",     "The identifier ELSE is missing from the CASE expression."},
            {"CASE_EXPRESSION_MISSING_END_IDENTIFIER",      "The identifier END is missing from the CASE expression."},
            {"CASE_EXPRESSION_MISSING_WHEN_CLAUSE",         "A CASE expression must define at least one WHEN clause."},
            {"CASE_EXPRESSION_WHEN_CLAUSES_END_WITH_COMMA", "The WHEN clauses cannot end with a comma."},
            {"CASE_EXPRESSION_WHEN_CLAUSES_HAS_COMMA",      "Two WHEN clauses cannot be separated by a comma."},

            // CastExpression - Grammar
            {"CAST_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"CAST_EXPRESSION_INVALID_JPA_VERSION",       "A CAST expression is only supported by EclipseLink."},
            {"CAST_EXPRESSION_MISSING_DATABASE_TYPE",     "The database type must be specified."},
            {"CAST_EXPRESSION_MISSING_EXPRESSION",        "The encapsulated expression must be provided for a CAST expression."},
            {"CAST_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the CAST expression."},
            {"CAST_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the CAST expression."},

            // CoalesceExpression - Grammar
            {"COALESCE_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"COALESCE_EXPRESSION_INVALID_JPA_VERSION",       "A COALESCE expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"COALESCE_EXPRESSION_MISSING_EXPRESSION",        "The encapsulated expressions must be provided for a COALESCE expression."},
            {"COALESCE_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the COALESCE expression."},
            {"COALESCE_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the COALESCE expression."},

            // CollectionExpression - Grammar
            {"COLLECTION_EXPRESSION_MISSING_EXPRESSION", "An expression at position {0} must be defined."},

            // CollectionMemberExpression - Grammar
            {"COLLECTION_MEMBER_EXPRESSION_MISSING_ENTITY_EXPRESSION",                 "A collection member expression must define an entity expression."},
            {"COLLECTION_MEMBER_EXPRESSION_MISSING_COLLECTION_VALUED_PATH_EXPRESSION", "A collection member expression must define a collection valued path expression."},
            // CollectionMemberExpression - Semantic
            {"COLLECTION_MEMBER_EXPRESSION_EMBEDDABLE",                                "An embeddable type is not supported."},

            // CollectionMemberDeclaration - Grammar
            {"COLLECTION_MEMBER_DECLARATION_MISSING_COLLECTION_VALUED_PATH_EXPRESSION", "The collection-valued path expression is missing from the collection member declaration."},
            {"COLLECTION_MEMBER_DECLARATION_MISSING_LEFT_PARENTHESIS",                  "The left parenthesis is missing from the collection member declaration."},
            {"COLLECTION_MEMBER_DECLARATION_MISSING_IDENTIFICATION_VARIABLE",           "An identification variable must be specified for a collection member declaration."},
            {"COLLECTION_MEMBER_DECLARATION_MISSING_RIGHT_PARENTHESIS",                 "The right parenthesis is missing from the collection member declaration."},

            // CollectionValuedPathExpression - Semantic
            {"COLLECTION_VALUED_PATH_EXPRESSION_NOT_RESOLVABLE",      "The collection-valued path ''{0}'' cannot be resolved to a valid association field."},
            {"COLLECTION_VALUED_PATH_EXPRESSION_NOT_COLLECTION_TYPE", "The collection-valued path ''{0}'' must resolve to an association field."},

            // ComparisonExpression - Grammar
            {"COMPARISON_EXPRESSION_MISSING_LEFT_EXPRESSION",  "A comparison expression must define the left side of the comparison."},
            {"COMPARISON_EXPRESSION_MISSING_RIGHT_EXPRESSION", "A comparison expression must define the right side of the comparison."},
            // ComparisonExpression - Semantic
            {"COMPARISON_EXPRESSION_ASSOCIATION_FIELD",        "The relationship mapping ''{0}'' cannot be used in conjunction with the {1} operator."},
            {"COMPARISON_EXPRESSION_BASIC_FIELD",              "The basic mapping ''{0}'' cannot be used in conjunction with the {1} operator."},
            {"COMPARISON_EXPRESSION_IDENTIFICATION_VARIABLE",  "The identification variable ''{0}'' cannot be used in conjunction with the {1} operator."},
            {"COMPARISON_EXPRESSION_WRONG_COMPARISON_TYPE",    "The left and right expressions' type must be of the same type."},

            // ConcatExpression - Grammar
            {"CONCAT_EXPRESSION_INVALID_EXPRESSION",        "The expression ''{0}'' is not valid expression."},
            {"CONCAT_EXPRESSION_MISSING_EXPRESSION",        "The encapsulated expression is missing from the CONCAT expression."},
            {"CONCAT_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the CONCAT expression."},
            {"CONCAT_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the CONCAT expression."},
            // ConcatExpression - Semantic
            {"CONCAT_EXPRESSION_EXPRESSION_WRONG_TYPE",     "The expression ''{0}'' is not a String."},

            // ConstructorExpression - Grammar
            {"CONSTRUCTOR_EXPRESSION_CONSTRUCTOR_ITEM_ENDS_WITH_COMMA",  "The constructor items cannot end with a comma."},
            {"CONSTRUCTOR_EXPRESSION_CONSTRUCTOR_ITEM_IS_MISSING_COMMA", "The constructor expression has two constructor items (''{0}'' and ''{1}'') that are not separated by a comma."},
            {"CONSTRUCTOR_EXPRESSION_MISSING_CONSTRUCTOR_ITEM",          "A constructor expression must define at least one constructor item."},
            {"CONSTRUCTOR_EXPRESSION_MISSING_CONSTRUCTOR_NAME",          "The fully qualified class name must be specified."},
            {"CONSTRUCTOR_EXPRESSION_MISSING_LEFT_PARENTHESIS",          "The left parenthesis is missing from the constructor expression."},
            {"CONSTRUCTOR_EXPRESSION_MISSING_RIGHT_PARENTHESIS",         "The right parenthesis is missing from the constructor expression."},
            // ConstructorExpression - Semantic
            {"CONSTRUCTOR_EXPRESSION_UNDEFINED_CONSTRUCTOR",             "No constructors can be found that match the argument types."},
            {"CONSTRUCTOR_EXPRESSION_UNKNOWN_TYPE",                      "''{0}'' cannot be resolved to a type."},

            // CountFunction - Grammar
            {"COUNT_FUNCTION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"COUNT_FUNCTION_MISSING_EXPRESSION",        "The encapsulated expression must be provided for a COUNT expression."},
            {"COUNT_FUNCTION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the COUNT expression."},
            {"COUNT_FUNCTION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the COUNT expression."},
            // CountFunction - Semantic
            {"COUNT_FUNCTION_DISTINCT_EMBEDDABLE",       "The use of DISTINCT is not supported for arguments of embeddable types."},

            // DatabaseType - Grammar
            {"DATABASE_TYPE_INVALID_FIRST_EXPRESSION",   "The first argument is not a valid precision/length value."},
            {"DATABASE_TYPE_INVALID_SECOND_EXPRESSION",  "The second argument is not a valid scale value."},
            {"DATABASE_TYPE_MISSING_COMMA",              "The comma separating the length and precision is missing."},
            {"DATABASE_TYPE_MISSING_FIRST_EXPRESSION",   "The precision/length value is missing."},
            {"DATABASE_TYPE_MISSING_LEFT_PARENTHESIS",   "The left parenthesis is missing from the database type expression."},
            {"DATABASE_TYPE_MISSING_RIGHT_PARENTHESIS",  "The right parenthesis is missing from the database type expression."},
            {"DATABASE_TYPE_MISSING_SECOND_EXPRESSION",  "The scale value is missing."},

            // DateTime - Grammar
            {"DATE_TIME_JDBC_ESCAPE_FORMAT_INVALID_SPECIFICATION",     "The JDBC escape format does not start with either 'd', 't' or 'ts'."},
            {"DATE_TIME_JDBC_ESCAPE_FORMAT_MISSING_CLOSE_QUOTE",       "The JDBC escape format is missing the close quote."},
            {"DATE_TIME_JDBC_ESCAPE_FORMAT_MISSING_OPEN_QUOTE",        "The JDBC escape format is missing the open quote."},
            {"DATE_TIME_JDBC_ESCAPE_FORMAT_MISSING_RIGHT_CURLY_BRACE", "The JDBC escape format is missing the right curly brace."},

            // DeleteClause - Grammar
            {"DELETE_CLAUSE_FROM_MISSING",                         "The identifier FROM is missing from the DELETE FROM clause."},
            {"DELETE_CLAUSE_MULTIPLE_RANGE_VARIABLE_DECLARATION",  "Only one entity abstract schema type can be defined."},
            {"DELETE_CLAUSE_RANGE_VARIABLE_DECLARATION_MALFORMED", "The entity abstract schema type declaration is malformed."},
            {"DELETE_CLAUSE_RANGE_VARIABLE_DECLARATION_MISSING",   "A DELETE clause must define an entity abstract schema type."},

            // DivisionExpression - Semantic
            {"DIVISION_EXPRESSION_LEFT_EXPRESSION_WRONG_TYPE",  "The left side of the division is not a valid arithmetic expression."},
            {"DIVISION_EXPRESSION_RIGHT_EXPRESSION_WRONG_TYPE", "The right side of the division is not a valid arithmetic expression."},

            // EncapsulatedIdentificationVariableExpression - Semantic
            {"ENCAPSULATED_IDENTIFICATION_VARIABLE_EXPRESSION_NOT_MAP_VALUED", "The {0} operator may only be applied to identification variables that correspond to map-valued associations or map-valued element collections."},

            // EmptyCollectionComparisonExpression - Grammar
            {"EMPTY_COLLECTION_COMPARISON_EXPRESSION_MISSING_EXPRESSION", "The collection valued path expression must be defined."},

            // EntityTypeLiteral - Semantic
            {"ENTITY_TYPE_LITERAL_INVALID_JPA_VERSION", "An entity name cannot be used as an entity type literal in a JPQL query when the JPA platform is 1.0."},
            {"ENTITY_TYPE_LITERAL_NOT_RESOLVABLE",      "''{0}'' cannot be resolved to a type."},

            // EntryExpression - Grammar
            {"ENTRY_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"ENTRY_EXPRESSION_MISSING_EXPRESSION",        "An identification variable must be provided for an ENTRY expression."},
            {"ENTRY_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the ENTRY expression."},
            {"ENTRY_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the ENTRY expression."},
            {"ENTRY_EXPRESSION_INVALID_JPA_VERSION",       "An ENTRY expression cannot be used in a JPQL query when the JPA platform is 1.0."},

            // ExistsExpression - Grammar
            {"EXISTS_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"EXISTS_EXPRESSION_MISSING_EXPRESSION",        "A subquery must be provided for an EXISTS expression."},
            {"EXISTS_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the EXISTS expression."},
            {"EXISTS_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the EXISTS expression."},

            // ExtractExpression - Grammar
            {"EXTRACT_EXPRESSION_INVALID_EXPRESSION",        "The date expression is not a valid expression."},
            {"EXTRACT_EXPRESSION_INVALID_JPA_VERSION",       "An EXTRACT expression is only supported by EclipseLink."},
            {"EXTRACT_EXPRESSION_MISSING_DATE_PART",         "The date part must be specified."},
            {"EXTRACT_EXPRESSION_MISSING_EXPRESSION",        "The date expression is missing from the EXTRACT expression."},
            {"EXTRACT_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The date part must be specified."},
            {"EXTRACT_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The left parenthesis is missing from the EXTRACT expression."},

            // FunctionExpression - Grammar
            {"FUNCTION_EXPRESSION_HAS_EXPRESSION",            "The function {0} should not have any argument."},
            {"FUNCTION_EXPRESSION_INVALID_EXPRESSION",        "The function {0}''s argument is not valid."},
            {"FUNCTION_EXPRESSION_INVALID_JPA_VERSION",       "A FUNCTION expression can only be used in a JPQL query when the JPA platform is 2.1."},
            {"FUNCTION_EXPRESSION_MISSING_EXPRESSION",        "The function {0}''s argument must be specified."},
            {"FUNCTION_EXPRESSION_MISSING_FUNCTION_NAME",     "The function name must be specified."},
            {"FUNCTION_EXPRESSION_MISSING_ONE_EXPRESSION",    "The function {0} must have one argument specified."},
            {"FUNCTION_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the function {0}."},
            {"FUNCTION_EXPRESSION_MORE_THAN_ONE_EXPRESSION",  "The function {0} has more than one argument, can only specify one argument."},
            // FunctionExpression - Semantic
            {"FUNCTION_EXPRESSION_UNKNOWN_COLUMN",            "The column {0} cannot be found on the table {1}."},

            // GroupByClause - Grammar
            {"GROUP_BY_CLAUSE_GROUP_BY_ITEM_ENDS_WITH_COMMA",  "The select expression cannot end with a comma."},
            {"GROUP_BY_CLAUSE_GROUP_BY_ITEM_IS_MISSING_COMMA", "The GROUP BY clause has ''{0}'' and ''{1}'' that are not separated by a comma."},
            {"GROUP_BY_CLAUSE_GROUP_BY_ITEM_MISSING",          "The grouping item is missing from the GROUP BY clause."},

            // HavingClause - Grammar
            {"HAVING_CLAUSE_INVALID_CONDITIONAL_EXPRESSION", "The expression is not a valid conditional expression."},
            {"HAVING_CLAUSE_MISSING_CONDITIONAL_EXPRESSION", "The conditional expression is missing from the HAVING clause."},

            // HermesParser - Validation
            {"HERMES_PARSER_GRAMMAR_VALIDATOR_ERROR_MESSAGE",    "Syntax error parsing [{0}]. {1}"},
            {"HERMES_PARSER_SEMANTIC_VALIDATOR_ERROR_MESSAGE",   "Problem compiling [{0}]. {1}"},
            {"HERMES_PARSER_UNEXPECTED_EXCEPTION_ERROR_MESSAGE", "Internal problem encountered while compiling [{0}]."},

            // IdentificationVariable - Grammar
            {"IDENTIFICATION_VARIABLE_INVALID_DUPLICATE",           "The identification variable ''{0}'' cannot be declared more than once."},
            {"IDENTIFICATION_VARIABLE_INVALID_JAVA_IDENTIFIER",     "The identification variable ''{0}'' is not following the rules for a Java identifier."},
            {"IDENTIFICATION_VARIABLE_INVALID_RESERVED_WORD",       "The identification variable ''{0}'' cannot be a reserved word."},
            // IdentificationVariable - Semantic
            {"IDENTIFICATION_VARIABLE_ENTITY_NAME",                 "An identification variable must not have the same name as any entity in the same persistence unit."},
            {"IDENTIFICATION_VARIABLE_INVALID_NOT_DECLARED",        "The identification variable ''{0}'' is not defined in the FROM clause."},

            // IdentificationVariableDeclaration - Grammar
            {"IDENTIFICATION_VARIABLE_DECLARATION_JOINS_END_WITH_COMMA",               "The JOIN expressions cannot end with a comma."},
            {"IDENTIFICATION_VARIABLE_DECLARATION_JOINS_HAS_COMMA",                    "JOIN expressions cannot be separated by a comma."},
            {"IDENTIFICATION_VARIABLE_DECLARATION_MISSING_RANGE_VARIABLE_DECLARATION", "The range variable declaration must be specified."},

            // IndexExpression - Grammar
            {"INDEX_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"INDEX_EXPRESSION_INVALID_JPA_VERSION",       "An INDEX expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"INDEX_EXPRESSION_MISSING_EXPRESSION",        "An identification variable must be provided for an INDEX expression."},
            {"INDEX_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the INDEX expression."},
            {"INDEX_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the INDEX expression."},
            // IndexExpression - Semantic
            {"INDEX_EXPRESSION_WRONG_VARIABLE",            "The identification variable ''{0}'' does not represent an association or element collection."},

            // InExpression - Grammar
            {"IN_EXPRESSION_ITEM_ENDS_WITH_COMMA",      "The list of items cannot end with a comma."},
            {"IN_EXPRESSION_ITEM_INVALID_EXPRESSION",   "The expression at index {0} is not a valid expression."},
            {"IN_EXPRESSION_ITEM_IS_MISSING_COMMA",     "The IN expression has ''{0}'' and ''{1}'' that are not separated by a comma."},
            {"IN_EXPRESSION_INVALID_EXPRESSION",        "The IN expression does not have a valid left expression."},
            {"IN_EXPRESSION_MISSING_EXPRESSION",        "The IN expression is missing the left expression."},
            {"IN_EXPRESSION_MISSING_IN_ITEMS",          "A least one item must be specified for the IN expression."},
            {"IN_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the IN expression."},
            {"IN_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the IN expression."},
            // InExpression - Semantic
            {"IN_EXPRESSION_INVALID_ITEM_COUNT",        "The number of items in the nested array must match the number of subquery select items."},

            // InputParameter - Grammar
            {"INPUT_PARAMETER_JAVA_IDENTIFIER",           "The named input parameter ''{0}'' is not following the rules for a Java identifier."},
            {"INPUT_PARAMETER_MISSING_PARAMETER",         "The parameter value is missing from the input parameter."},
            {"INPUT_PARAMETER_MIXTURE",                   "Named and positional input parameters must not be mixed in a single query."},
            {"INPUT_PARAMETER_NOT_INTEGER",               "The positional input parameter ''{0}'' cannot use non-Integer characters."},
            {"INPUT_PARAMETER_SMALLER_THAN_ONE",          "The number used for the positional input parameter ''{0}'' must be greater than 0."},
            {"INPUT_PARAMETER_WRONG_CLAUSE_DECLARATION",  "Input parameters can only be used in the WHERE clause or HAVING clause of a query."},

            // Join - Grammar
            {"JOIN_INVALID_IDENTIFIER",              "The JOIN identifier is not valid."},
            {"JOIN_INVALID_JOIN_ASSOCIATION_PATH",   "The join association path is not a valid expression."},
            {"JOIN_MISSING_IDENTIFICATION_VARIABLE", "An identification variable must be defined for a JOIN expression."},
            {"JOIN_MISSING_JOIN_ASSOCIATION_PATH",   "The join association path is missing from the JOIN expression."},

            // JoinFetch - Grammar
            {"JOIN_FETCH_INVALID_IDENTIFICATION",          "JOIN FETCH expressions cannot be defined with an identification variable."},
            {"JOIN_FETCH_MISSING_IDENTIFICATION_VARIABLE", "An identification variable must be defined for a JOIN FETCH expression."},
            {"JOIN_FETCH_MISSING_JOIN_ASSOCIATION_PATH",   "The join association path is missing from the JOIN FETCH expression."},
            {"JOIN_FETCH_WRONG_CLAUSE_DECLARATION",        "JOIN FETCH expressions cannot be used in a FROM clause of a subquery."},

            // JPQLExpression - Grammar
            {"JPQL_EXPRESSION_INVALID_QUERY",  "The query does not start with a valid identifier, has to be either SELECT, UPDATE or DELETE FROM."},
            {"JPQL_EXPRESSION_UNKNOWN_ENDING", "The query contains a malformed ending."},

            // KeyExpression - Grammar
            {"KEY_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"KEY_EXPRESSION_INVALID_JPA_VERSION",       "A KEY expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"KEY_EXPRESSION_MISSING_EXPRESSION",        "The identification variable must be provided for an ABS expression."},
            {"KEY_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the ABS expression."},
            {"KEY_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the ABS expression."},

            // LengthExpression - Grammar
            {"LENGTH_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"LENGTH_EXPRESSION_MISSING_EXPRESSION",        "An expression must be provided for a LENGTH expression."},
            {"LENGTH_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the LENGTH expression."},
            {"LENGTH_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the LENGTH expression."},
            // LikeExpression - Semantic
            {"LENGTH_EXPRESSION_WRONG_TYPE",                "The encapsulated expression is not of string type."},

            // LikeExpression - Grammar
            {"LIKE_EXPRESSION_INVALID_ESCAPE_CHARACTER",  "{0} is not a valid escape character."},
            {"LIKE_EXPRESSION_MISSING_ESCAPE_CHARACTER",  "The escape character is missing from the LIKE expression."},
            {"LIKE_EXPRESSION_MISSING_PATTERN_VALUE",     "The pattern value is missing from the LIKE expression."},
            {"LIKE_EXPRESSION_MISSING_STRING_EXPRESSION", "The string expression is missing from the LIKE expression."},

            // LocateExpression - Grammar
            {"LOCATE_EXPRESSION_INVALID_FIRST_EXPRESSION",     "The first argument is not a valid expression."},
            {"LOCATE_EXPRESSION_INVALID_SECOND_EXPRESSION",    "The second argument is not a valid expression."},
            {"LOCATE_EXPRESSION_INVALID_THIRD_EXPRESSION",     "The third argument is not a valid expression."},
            {"LOCATE_EXPRESSION_MISSING_FIRST_EXPRESSION",     "The first argument is missing from the LOCATE expression."},
            {"LOCATE_EXPRESSION_MISSING_LEFT_PARENTHESIS",     "The left parenthesis is missing from the LOCATE expression."},
            {"LOCATE_EXPRESSION_MISSING_FIRST_COMMA",          "The first comma is missing from the LOCATE expression."},
            {"LOCATE_EXPRESSION_MISSING_RIGHT_PARENTHESIS",    "The right parenthesis is missing from the LOCATE expression."},
            {"LOCATE_EXPRESSION_MISSING_SECOND_COMMA",         "The second comma is missing from the LOCATE expression."},
            {"LOCATE_EXPRESSION_MISSING_SECOND_EXPRESSION",    "The second argument is missing from the LOCATE expression."},
            {"LOCATE_EXPRESSION_MISSING_THIRD_EXPRESSION",     "The third argument is missing from the LOCATE expression."},
            // LocateExpression - Semantic
            {"LOCATE_EXPRESSION_FIRST_EXPRESSION_WRONG_TYPE",  "The first expression is not of string type."},
            {"LOCATE_EXPRESSION_SECOND_EXPRESSION_WRONG_TYPE", "The second expression is not of string type."},
            {"LOCATE_EXPRESSION_THIRD_EXPRESSION_WRONG_TYPE",  "The third encapsulated expression is not of numeric type."},

            // LogicalExpression - Grammar
            {"LOGICAL_EXPRESSION_INVALID_LEFT_EXPRESSION",  "The left expression is not a valid expression."},
            {"LOGICAL_EXPRESSION_INVALID_RIGHT_EXPRESSION", "The right expression is not a valid expression."},
            {"LOGICAL_EXPRESSION_MISSING_LEFT_EXPRESSION",  "The left expression is missing from the logical expression."},
            {"LOGICAL_EXPRESSION_MISSING_RIGHT_EXPRESSION", "The right expression is missing from the logical expression."},

            // LowerExpression - Grammar
            {"LOWER_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"LOWER_EXPRESSION_MISSING_EXPRESSION",        "An expression must be provided for a LOWER expression."},
            {"LOWER_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the LOWER expression."},
            {"LOWER_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the LOWER expression."},
            // UpperExpression - Semantic
            {"LOWER_EXPRESSION_WRONG_TYPE",                "The expression is not a String."},

            // MaxFunction - Grammar
            {"MAX_FUNCTION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"MAX_FUNCTION_MISSING_EXPRESSION",        "The encapsulated expression must be provided for a MAX expression."},
            {"MAX_FUNCTION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the MAX expression."},
            {"MAX_FUNCTION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the MAX expression."},

            // MinFunction - Grammar
            {"MIN_FUNCTION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"MIN_FUNCTION_MISSING_EXPRESSION",        "The encapsulated expression must be provided for a MIN expression."},
            {"MIN_FUNCTION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the MIN expression."},
            {"MIN_FUNCTION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the MIN expression."},

            // ModExpression - Grammar
            {"MOD_EXPRESSION_INVALID_FIRST_EXPRESSION",     "The first argument is not a valid expression."},
            {"MOD_EXPRESSION_INVALID_SECOND_EXPRESSION",    "The second argument is not a valid expression."},
            {"MOD_EXPRESSION_MISSING_COMMA",                "The comma is missing from the MOD expression."},
            {"MOD_EXPRESSION_MISSING_FIRST_EXPRESSION",     "The first argument is missing from the MOD expression."},
            {"MOD_EXPRESSION_MISSING_LEFT_PARENTHESIS",     "The left parenthesis is missing from the MOD expression."},
            {"MOD_EXPRESSION_MISSING_RIGHT_PARENTHESIS",    "The right parenthesis is missing from the MOD expression."},
            {"MOD_EXPRESSION_MISSING_SECOND_EXPRESSION",    "The second argument is missing from the MOD expression."},
            // ModExpression - Semantic
            {"MOD_EXPRESSION_FIRST_EXPRESSION_WRONG_TYPE",  "The first expression is not an Integer."},
            {"MOD_EXPRESSION_SECOND_EXPRESSION_WRONG_TYPE", "The second expression is not an Integer."},

            // MultiplicationExpression - Semantic
            {"MULTIPLICATION_EXPRESSION_LEFT_EXPRESSION_WRONG_TYPE",  "The left side of the multiplication is not a valid arithmetic expression."},
            {"MULTIPLICATION_EXPRESSION_RIGHT_EXPRESSION_WRONG_TYPE", "The right side of the multiplication is not a valid arithmetic expression."},

            // NotExpression - Grammar
            {"NOT_EXPRESSION_MISSING_EXPRESSION", "The expression is missing after the identifier NOT."},
            // NotExpression - Semantic
            {"NOT_EXPRESSION_WRONG_TYPE",         "The expression is not of boolean type."},
            // NullComparisonExpression - Grammar
            {"NULL_COMPARISON_EXPRESSION_MISSING_EXPRESSION", "The expression is missing from the null comparison expression."},
            // NullComparisonExpression - Semantic
            {"NULL_COMPARISON_EXPRESSION_INVALID_TYPE",       "''{0}'' cannot be resolved to an embeddable."},

            // NullIfExpression - Grammar
            {"NULLIF_EXPRESSION_INVALID_FIRST_EXPRESSION",  "The first argument is not a valid expression."},
            {"NULLIF_EXPRESSION_INVALID_JPA_VERSION",       "A NULLIF expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"NULLIF_EXPRESSION_INVALID_SECOND_EXPRESSION", "The second argument is not a valid expression."},
            {"NULLIF_EXPRESSION_MISSING_COMMA",             "The comma is missing from the NULLIF expression."},
            {"NULLIF_EXPRESSION_MISSING_FIRST_EXPRESSION",  "The first argument is missing from the NULLIF expression."},
            {"NULLIF_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the NULLIF expression."},
            {"NULLIF_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the NULLIF expression."},
            {"NULLIF_EXPRESSION_MISSING_SECOND_EXPRESSION", "The second argument is missing from the NULLIF expression."},

            // NumericLiteral - Grammar
            {"NUMERIC_LITERAL_INVALID", "''{0}'' is not a valid numeric value."},

            // ObjectByItem - Grammar
            {"ORDER_BY_ITEM_INVALID_EXPRESSION", "The order by item is not a valid expression."},
            {"ORDER_BY_ITEM_MISSING_EXPRESSION", "An order by item must be specified."},

            // ObjectExpression - Grammar
            {"OBJECT_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"OBJECT_EXPRESSION_MISSING_EXPRESSION",        "An identification variable must be provided for an OBJECT expression."},
            {"OBJECT_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the OBJECT expression."},
            {"OBJECT_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the OBJECT expression."},

            // OnClause - Grammar
            {"ON_CLAUSE_INVALID_CONDITIONAL_EXPRESSION", "The expression is not a valid conditional expression."},
            {"ON_CLAUSE_MISSING_CONDITIONAL_EXPRESSION", "The conditional expression is missing from the JOIN condition."},

            // OrderByClause - Grammar
            {"ORDER_BY_CLAUSE_ORDER_BY_ITEM_ENDS_WITH_COMMA",  "The select expression cannot end with a comma."},
            {"ORDER_BY_CLAUSE_ORDER_BY_ITEM_IS_MISSING_COMMA", "The ORDER BY clause has ''{0}'' and ''{1}'' that are not separated by a comma."},
            {"ORDER_BY_CLAUSE_ORDER_BY_ITEM_MISSING",          "The ordering item is missing from the ORDER BY clause."},

            // RangeVariableDeclaration - Grammar
            {"RANGE_VARIABLE_DECLARATION_MISSING_ROOT_OBJECT",             "A \"root object\" must be specified."},
            {"RANGE_VARIABLE_DECLARATION_INVALID_ROOT_OBJECT",             "A \"root object\" must be specified."},
            {"RANGE_VARIABLE_DECLARATION_MISSING_IDENTIFICATION_VARIABLE", "An identification variable must be provided for a range variable declaration."},

            // RegexpExpression - Grammar
            {"REGEXP_EXPRESSION_INVALID_JPA_VERSION",       "A REGEXP expression is only supported by EclipseLink."},
            {"REGEXP_EXPRESSION_INVALID_PATTERN_VALUE",     "The pattern value is not a valid expression."},
            {"REGEXP_EXPRESSION_INVALID_STRING_EXPRESSION", "The string expression is not a valid expression."},
            {"REGEXP_EXPRESSION_MISSING_PATTERN_VALUE",     "The pattern value must be specified."},
            {"REGEXP_EXPRESSION_MISSING_STRING_EXPRESSION", "The string expression must be specified."},

            // ResultVariable - Grammar
            {"RESULT_VARIABLE_INVALID_JPA_VERSION",       "A result variable cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"RESULT_VARIABLE_MISSING_SELECT_EXPRESSION", "The select item is missing from the result variable declaration."},
            {"RESULT_VARIABLE_MISSING_RESULT_VARIABLE",   "The result variable is missing from the select item declaration."},

            // SimpleSelectClause - Grammar
            {"SIMPLE_SELECT_CLAUSE_NOT_SINGLE_EXPRESSION", "Only one expression can be declared in a SELECT clause of a subquery."},

            // SizeExpression - Grammar
            {"SIZE_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"SIZE_EXPRESSION_MISSING_EXPRESSION",        "A collection-valued path expression must be provided for a SIZE expression."},
            {"SIZE_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the SIZE expression."},
            {"SIZE_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the SIZE expression."},

            // SqrtExpression - Grammar
            {"SQRT_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"SQRT_EXPRESSION_MISSING_EXPRESSION",        "An expression must be provided for a SQRT expression."},
            {"SQRT_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the SQRT expression."},
            {"SQRT_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the SQRT expression."},
            // SqrtExpression - Semantic
            {"SQRT_EXPRESSION_WRONG_TYPE",                "The expression is not a numeric type."},

            // StateFieldPathExpression - Semantic
            {"STATE_FIELD_PATH_EXPRESSION_ASSOCIATION_FIELD",     "The association field ''{0}'' cannot be used as a state field path."},
            {"STATE_FIELD_PATH_EXPRESSION_BASIC_FIELD",           "The basic field ''{0}'' cannot be used as a state field path."},
            {"STATE_FIELD_PATH_EXPRESSION_COLLECTION_TYPE",       "The state field path ''{0}'' cannot be resolved to a collection type."},
            {"STATE_FIELD_PATH_EXPRESSION_INVALID_ENUM_CONSTANT", "''{0}'' cannot be resolved to an Enum constant."},
            {"STATE_FIELD_PATH_EXPRESSION_NO_MAPPING",            "No mapping is associated with the state field path ''{0}''."},
            {"STATE_FIELD_PATH_EXPRESSION_NOT_RESOLVABLE",        "The state field path ''{0}'' cannot be resolved to a valid type."},
            {"STATE_FIELD_PATH_EXPRESSION_UNKNOWN_COLUMN",        "The column {0} cannot be found on the table {1}."},

            // StringLiteral - Grammar
            {"STRING_LITERAL_MISSING_CLOSING_QUOTE", "The string literal is missing the closing quote."},

            // SubExpression - Grammar
            {"SUB_EXPRESSION_MISSING_EXPRESSION",        "The encapsulated expression is missing."},
            {"SUB_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the sub-expression."},

            // SubtractionExpression - Semantic
            {"SUBTRACTION_EXPRESSION_LEFT_EXPRESSION_WRONG_TYPE",  "The left side of the subtraction is not a valid arithmetic expression."},
            {"SUBTRACTION_EXPRESSION_RIGHT_EXPRESSION_WRONG_TYPE", "The right side of the subtraction is not a valid arithmetic expression."},

            // SubstringExpression - Grammar
            {"SUBSTRING_EXPRESSION_INVALID_FIRST_EXPRESSION",     "The first argument is not a valid expression."},
            {"SUBSTRING_EXPRESSION_INVALID_SECOND_EXPRESSION",    "The second argument is not a valid expression."},
            {"SUBSTRING_EXPRESSION_INVALID_THIRD_EXPRESSION",     "The third argument is not a valid expression."},
            {"SUBSTRING_EXPRESSION_MISSING_FIRST_COMMA",          "The first comma is missing from the SUBSTRING expression."},
            {"SUBSTRING_EXPRESSION_MISSING_FIRST_EXPRESSION",     "The first argument is missing from the SUBSTRING expression."},
            {"SUBSTRING_EXPRESSION_MISSING_LEFT_PARENTHESIS",     "The left parenthesis is missing from the SUBSTRING expression."},
            {"SUBSTRING_EXPRESSION_MISSING_RIGHT_PARENTHESIS",    "The right parenthesis is missing from the SUBSTRING expression."},
            {"SUBSTRING_EXPRESSION_MISSING_SECOND_COMMA",         "The second comma is missing from the SUBSTRING expression."},
            {"SUBSTRING_EXPRESSION_MISSING_SECOND_EXPRESSION",    "The second argument is missing from the SUBSTRING expression."},
            {"SUBSTRING_EXPRESSION_MISSING_THIRD_EXPRESSION",     "The third argument is missing from the SUBSTRING expression."},
            // SubstringExpression - Semantic
            {"SUBSTRING_EXPRESSION_FIRST_EXPRESSION_WRONG_TYPE",  "The first argument is not a String value."},
            {"SUBSTRING_EXPRESSION_SECOND_EXPRESSION_WRONG_TYPE", "The second argument is not an integer value."},
            {"SUBSTRING_EXPRESSION_THIRD_EXPRESSION_WRONG_TYPE",  "The third argument is not an integer value."},

            // SumFunction - Grammar
            {"SUM_FUNCTION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"SUM_FUNCTION_MISSING_EXPRESSION",        "The encapsulated expression must be provided for a SUM expression."},
            {"SUM_FUNCTION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the SUM expression."},
            {"SUM_FUNCTION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the SUM expression."},
            // SumFunction - Semantic
            {"SUM_FUNCTION_WRONG_TYPE",                "The argument must be numeric."},

            // TableExpression - Grammar
            {"TABLE_EXPRESSION_INVALID_EXPRESSION",         "The encapsulated expression is not a valid table name."},
            {"TABLE_EXPRESSION_MISSING_EXPRESSION",         "The table name must be provided for an TABLE expression."},
            {"TABLE_EXPRESSION_MISSING_LEFT_PARENTHESIS",   "The left parenthesis is missing from the TABLE expression."},
            {"TABLE_EXPRESSION_MISSING_RIGHT_PARENTHESIS",  "The right parenthesis is missing from the TABLE expression."},
            // TableExpression - Semantic
            {"TABLE_EXPRESSION_INVALID_TABLE_NAME",         "The table ''{0}'' does not exist on the database."},

            // TableVariableDeclaration - Grammar
            {"TABLE_VARIABLE_DECLARATION_INVALID_JPA_VERSION",             "A table variable declaration can only be used when the platform is EclipseLink."},
            {"TABLE_VARIABLE_DECLARATION_MISSING_IDENTIFICATION_VARIABLE", "An identification variable must be provided for a table variable declaration."},

            // TreatExpression - Grammar
            {"TREAT_EXPRESSION_INVALID_JPA_PLATFORM", "A TREAT expression can only be used when the platform is EclipseLink."},

            // TrimExpression - Grammar
            {"TRIM_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"TRIM_EXPRESSION_INVALID_TRIM_CHARACTER",    "The trim character should be a single-character string literal or a character-valued input parameter (i.e., char or Character)."},
            {"TRIM_EXPRESSION_MISSING_EXPRESSION",        "An expression must be provided for a TRIM expression."},
            {"TRIM_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the TRIM expression."},
            {"TRIM_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the TRIM expression."},
            {"TRIM_EXPRESSION_NOT_SINGLE_STRING_LITERAL", "The trim character should be a single-character string literal."},

            // TypeExpression - Grammar
            {"TYPE_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"TYPE_EXPRESSION_INVALID_JPA_VERSION",       "A TYPE expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"TYPE_EXPRESSION_MISSING_EXPRESSION",        "An identification variable or a path expression must be provided for a TYPE expression."},
            {"TYPE_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the TYPE expression."},
            {"TYPE_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the TYPE expression."},

            // UnionClause - Grammar
            {"UNION_CLAUSE_INVALID_JPA_VERSION", "A union clause is only supported by EclipseLink."},
            {"UNION_CLAUSE_MISSING_EXPRESSION",  "The query is missing from the UNION clause."},

            // UpdateClause - Grammar
            {"UPDATE_CLAUSE_MISSING_RANGE_VARIABLE_DECLARATION", "The range variable declaration is missing from the UPDATE clause."},
            {"UPDATE_CLAUSE_MISSING_SET",                        "The SET identifier is missing from the UPDATE clause."},
            {"UPDATE_CLAUSE_MISSING_UPDATE_ITEMS",               "At least one update item must be specified for an UPDATE clause."},
            {"UPDATE_CLAUSE_UPDATE_ITEM_ENDS_WITH_COMMA",        "The update item cannot end with a comma."},
            {"UPDATE_CLAUSE_UPDATE_ITEM_IS_MISSING_COMMA",       "The UPDATE clause has ''{0}'' and ''{1}'' that are not separated by a comma."},

            // UpdateItem - Grammar
            {"UPDATE_ITEM_MISSING_EQUAL_SIGN",                  "The equal sign must be specified."},
            {"UPDATE_ITEM_MISSING_NEW_VALUE",                   "The new value must be specified."},
            {"UPDATE_ITEM_MISSING_STATE_FIELD_PATH_EXPRESSION", "The state field path expression is missing."},
            // UpdateItem - Semantic
            {"UPDATE_ITEM_NOT_ASSIGNABLE",                      "Type mismatch: cannot convert from {0} to {1}."},
            {"UPDATE_ITEM_NOT_RESOLVABLE",                      "The state field cannot be resolved."},
            {"UPDATE_ITEM_NULL_NOT_ASSIGNABLE_TO_PRIMITIVE",    "NULL cannot be assigned to a primitive value."},
            {"UPDATE_ITEM_RELATIONSHIP_PATH_EXPRESSION",        "An association field cannot be used in an update item's path expression."},

            // UpperExpression - Grammar
            {"UPPER_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"UPPER_EXPRESSION_MISSING_EXPRESSION",        "An expression must be provided for a UPPER expression."},
            {"UPPER_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the UPPER expression."},
            {"UPPER_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the UPPER expression."},
            // UpperExpression - Semantic
            {"UPPER_EXPRESSION_WRONG_TYPE",                "The expression is not a String."},

            // ValueExpression - Grammar
            {"VALUE_EXPRESSION_INVALID_EXPRESSION",        "The encapsulated expression is not a valid expression."},
            {"VALUE_EXPRESSION_INVALID_JPA_VERSION",       "A VALUE expression cannot be used in a JPQL query when the JPA platform is 1.0."},
            {"VALUE_EXPRESSION_MISSING_EXPRESSION",        "An identification variable must be provided for a VALUE expression."},
            {"VALUE_EXPRESSION_MISSING_LEFT_PARENTHESIS",  "The left parenthesis is missing from the VALUE expression."},
            {"VALUE_EXPRESSION_MISSING_RIGHT_PARENTHESIS", "The right parenthesis is missing from the VALUE expression."},

            // WhenClause - Grammar
            {"WHEN_CLAUSE_MISSING_THEN_EXPRESSION", "A conditional expression must be provided for a WHEN clause."},
            {"WHEN_CLAUSE_MISSING_THEN_IDENTIFIER", "The identifier THEN is missing from the WHEN clause."},
            {"WHEN_CLAUSE_MISSING_WHEN_EXPRESSION", "A WHEN expression must be provided for a WHEN clause."},

            // WhereClause - Grammar
            {"WHERE_CLAUSE_INVALID_CONDITIONAL_EXPRESSION", "The expression is not a valid conditional expression."},
            {"WHERE_CLAUSE_MISSING_CONDITIONAL_EXPRESSION", "The conditional expression is missing from the WHERE clause."},
        };

        return contents;
    }
}
