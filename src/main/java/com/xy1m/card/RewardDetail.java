package com.xy1m.card;

import java.math.BigDecimal;

/**
 * Created by gzhenpeng on 6/5/18
 */
public class RewardDetail {
    private PurchaseType purchaseType;
    private BigDecimal rewardRate;

    public RewardDetail(PurchaseType purchaseType, BigDecimal rewardRate) {
        this.purchaseType = purchaseType;
        this.rewardRate = rewardRate;
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }

    public BigDecimal getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(BigDecimal rewardRate) {
        this.rewardRate = rewardRate;
    }
}
