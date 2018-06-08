package com.xy1m;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xy1m.card.Bonus;
import com.xy1m.card.Card;
import com.xy1m.card.CardNetwork;
import com.xy1m.card.Category;
import com.xy1m.card.PurchaseType;
import com.xy1m.card.Reward;
import com.xy1m.card.RewardDetail;
import com.xy1m.card.RewardType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }

    public static void main(String[] args) throws JsonProcessingException {
        Card card = new Card();
        card.setCardNetwork(CardNetwork.VISA);
        card.setIssuer("Chase");
        card.setName("Chase Freedom Credit Card");
        card.setCategories(Arrays.asList(Category.CASH_BACK, Category.TRAVEL));
        card.setAnnualFee(BigDecimal.ZERO);
        card.setBonus(Bonus.empty());

        List<RewardDetail> rewards = Arrays.asList(
                new RewardDetail(PurchaseType.TRAVEL, new BigDecimal("0.02")),
                new RewardDetail(PurchaseType.RESTAURANT, new BigDecimal("0.02")),
                new RewardDetail(PurchaseType.OTHERS, new BigDecimal("0.01"))
        );
        card.setReward(
                new Reward(RewardType.POINT, rewards)
        );

        String json = mapper.writeValueAsString(card);
        System.out.println(json);
    }

}
