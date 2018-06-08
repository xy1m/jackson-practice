package com.xy1m.card;

import java.util.List;

/**
 * Created by gzhenpeng on 6/5/18
 */
public class Reward {
    private RewardType type;
    private List<RewardDetail> rewardDetails;

    public Reward(RewardType type, List<RewardDetail> rewardDetails) {
        this.type = type;
        this.rewardDetails = rewardDetails;
    }

    public RewardType getType() {
        return type;
    }

    public void setType(RewardType type) {
        this.type = type;
    }

    public List<RewardDetail> getRewardDetails() {
        return rewardDetails;
    }

    public void setRewardDetails(List<RewardDetail> rewardDetails) {
        this.rewardDetails = rewardDetails;
    }
}
