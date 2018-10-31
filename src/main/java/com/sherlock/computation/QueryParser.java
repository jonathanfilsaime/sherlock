package com.sherlock.computation;

import com.sherlock.exception.IncorrectQuerySyntaxException;
import com.sherlock.model.ConditionRequestObject;
import com.sherlock.model.RequestObject;
import com.sherlock.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class QueryParser {

    Logger logger = LoggerFactory.getLogger(QueryParser.class.getName());

    /**
     * this method parse the query param passed in from the
     * /search/param end point
     * @param string
     * @return String
     */
    public String parse(String string) {
        String[] split = string.split("\\s+");

        if (Validation.validateLength(split) && Validation.validateSyntax(split)
                && Validation.validateWhereCondition(createValueMap(split))
                && Validation.validateMapSize(createValueMap(split)))
        {
            logger.info(queryStringBuilder(createValueMap(split)));
            return queryStringBuilder(createValueMap(split));
        }
        else
        {
            throw new IncorrectQuerySyntaxException("incorrect syntax");
        }
    }

    /**
     * this method parses the JSON object submitted in the body
     * from /search end point
     * @param requestObject
     * @return
     */
    public String parseRequest(RequestObject requestObject)
    {
        Map<Integer, String> map = createValueMapFromRequestObject(requestObject);
        if(Validation.validateMapSize(map) && Validation.validateWhereCondition(map))
        {
            logger.info(queryStringBuilder(map));
            return queryStringBuilder(map);
        }
        else
        {
            throw new IncorrectQuerySyntaxException("incorrect syntax");
        }
    }

    private Map<Integer, String>
    createValueMapFromRequestObject(RequestObject requestObject)
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, requestObject.getFind());
        int index = 0;
        for (ConditionRequestObject condition : requestObject.getConditionRequestObjects())
        {
            index++;
            map.put(index, condition.getWhere());
            index++;
            map.put(index, condition.getIsGreater());
            index++;
            map.put(index, condition.getAmount().replaceFirst("^0+(?!$)", "").replaceAll("[$,]",""));
        }
        logger.info("createValueMapFromRequestObject: " + map.toString());
        return map;
    }

    private Map<Integer, String> createValueMap(String[] strings) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++)
        {
            if (i == 0) {
                map.put(i, strings[i].substring(5));
            } else if (((i == 1) || (i > 1 && i % 3 == 1))) {
                map.put(i, strings[i].substring(6));
            } else if (((i == 2) || (i > 2 && i % 3 == 2))) {
                map.put(i, strings[i].substring(3));
            } else if (i > 2 && i % 3 == 0) {
                map.put(i, strings[i].substring(5).replaceFirst("^0+(?!$)", "").replaceAll("[$,]",""));
            }
            else {
            }
        }
        return map;
    }

    private String queryStringBuilder(Map map) {

        if (Validation.validateWhereCondition(map))
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM financial_data WHERE");

            for (int i = 0; i < map.size(); i++)
            {
                if (i == 1) {
                    stringBuilder.append(" ");
                    stringBuilder.append(map.get(i));
                }
                if (i > 1 && i % 3 == 1) {
                    stringBuilder.append(" AND ");
                    stringBuilder.append(map.get(i));
                }
                if (i > 1 && i % 3 == 2) {
                    if (map.get(i).equals("greater") || map.get(i).equals("true") || map.get(i).equals("True")) {
                        stringBuilder.append(" >");
                    }
                    if (map.get(i).equals("less") || map.get(i).equals("false") || map.get(i).equals("False")) {
                        stringBuilder.append(" <");
                    }
                }
                if (i > 2 && i % 3 == 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(map.get(i));
                }
            }

            if (map.get(0).equals("TOP_10_STOCKS")) {
                stringBuilder.append(" LIMIT 10;");
            }
            if (map.get(0).equals("TOP_50_STOCKS")) {
                stringBuilder.append(" LIMIT 50;");
            }
            if (map.get(0).equals("TOP_100_STOCKS")) {
                stringBuilder.append(" LIMIT 100;");
            }
            if (map.get(0).equals("ALL_STOCKS")) {
                stringBuilder.append(";");
            }

            return stringBuilder.toString();
        }
        else
        {
            throw new IncorrectQuerySyntaxException("Incorrect syntax" + map);
        }
    }
}





