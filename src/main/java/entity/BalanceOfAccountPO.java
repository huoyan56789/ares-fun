package entity;

import annotation.IgnoreSplit;

import java.util.Date;

/**
 * @Author Ares
 * @Date 2018/9/19 17:54
 * @Description:稽核存费送费订单原子实体
 * @Version JDK 1.8
 */
public class BalanceOfAccountPO
{
    //订单归属部门 互联网运营部
    @IgnoreSplit
    private String departCode;
    //业务订单来源 10 WO+平台 20 红包 30 新零售订单中心 40 沃行销
    private String orderSource;
    //交易时间 YYYYMMDD 24H
    @IgnoreSplit
    private String tradeTime;
    //省分编码
    private String provinceCode;
    //地市
    private String cityCode;
    //外部订单ID
    private String outOrderId;
    //支付订单ID
    private String payTransactionId;
    //发起方交易流水号或bss/cbss订单号
    private String relateOrderId;
    //接入渠道
    private String inModeCode;
    //总部订单ID
    private String orderId;
    //渠道编码
    private String channelId;
    //渠道类型
    private String channelType;
    //缴费对账渠道类型
    private String chanType;
    //工号
    private String createOperId;
    //订单落地系统 00 CBSS、01 BSS
    private String landingSystem;
    //用户号码
    private String deviceNumber;
    //业务类型
    private String busiType;
    //电信业务类型
    private String networkType;
    //产品编码
    private String productCode;
    //产品描述
    private String productDesc;
    //订单状态 10成功 20失败 21失败（BSS侧平帐退款） 22 异常（用户投诉退款）
    private String orderType;
    //订单总金额 单位：元
    private String totalFee;
    //优惠金额 单位：元
    private String discountFee;
    //营业款入帐金额 单位：元
    private String realFee;
    //支付渠道 WX  微信 ZFB 支付宝 JHZF支付宝公司聚合支付 JDZF 京东支付
    private String payChannel;
    //商户号
    private String merchantId;
    //手续费
    private String chargeFee;
    //缴费账本编码
    private String acntCode;
    //积分金额
    private String pointFee;
    //积分扣减流水
    private String pointDeductId;
    //业务类型
    private String serviceType;
    //电信业务网别
    private String serviceClassCode;
    //操作类型 01 扣减 02 回退 03 转赠 04 销售
    private String operType;
    //积分消费渠道 0 积分商城 1 网上营业厅 2 手机营业厅 3 短信营业厅 4 实体营业厅 5 自助终端机 6 微信厅 7 迷你厅
    private String pointChanType;
    //积分用途 0 合作方产品 1 一卡充 2 1G流量半年包 3 网厅交费 4 积分活动 5 积分转赠 6 积分销售 7 实体营业厅兑换
    private String consumeType;
    //积分扣减号码
    private String pointDeductNumber;
    //缴费类型 01：普通缴费 02：自然人缴费以及亲密充
    private String npTag;
    //支付方式 01 现金 02 现金+积分 03 积分
    private String paymentType;
    //支付机构编码
    private String chargeParty;
    //区号
    private String areaCode;
    //号码类型，默认0 0：统一宽带编码 1：宽带拨号账号 2：固话 3：手机号码
    private String queryType;
    //【互联网代扣平台-综合缴费日对账必填】  网别 01 2G（GSM） 02 3G（WCDMA）03 固定电话 04 宽带（ADSL） 05 宽带（LAN）  06 小灵通 07 WLAN业务 08 宽带统一编码
    private String netType;
    //业务返销类关联的原订单ID
    private String refundOrderId;


    //用Date的创建时间和数据库交互防止出现.0，转化后传给tradeTime
    private Date crtTime;
    //外部请求入参
    private String requestInput;
    //退款流水
    private String payRefundId;

    public String getDepartCode()
    {
        return departCode;
    }

    public void setDepartCode(String departCode)
    {
        this.departCode = departCode;
    }

    public String getOrderSource()
    {
        return orderSource;
    }

    public void setOrderSource(String orderSource)
    {
        this.orderSource = orderSource;
    }

    public String getTradeTime()
    {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime)
    {
        this.tradeTime = tradeTime;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode)
    {
        this.provinceCode = provinceCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getOutOrderId()
    {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId)
    {
        this.outOrderId = outOrderId;
    }

    public String getPayTransactionId()
    {
        return payTransactionId;
    }

    public void setPayTransactionId(String payTransactionId)
    {
        this.payTransactionId = payTransactionId;
    }

    public String getRelateOrderId()
    {
        return relateOrderId;
    }

    public void setRelateOrderId(String relateOrderId)
    {
        this.relateOrderId = relateOrderId;
    }

    public String getInModeCode()
    {
        return inModeCode;
    }

    public void setInModeCode(String inModeCode)
    {
        this.inModeCode = inModeCode;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getChannelId()
    {
        return channelId;
    }

    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
    }

    public String getChannelType()
    {
        return channelType;
    }

    public void setChannelType(String channelType)
    {
        this.channelType = channelType;
    }

    public String getChanType()
    {
        return chanType;
    }

    public void setChanType(String chanType)
    {
        this.chanType = chanType;
    }

    public String getCreateOperId()
    {
        return createOperId;
    }

    public void setCreateOperId(String createOperId)
    {
        this.createOperId = createOperId;
    }

    public String getLandingSystem()
    {
        return landingSystem;
    }

    public void setLandingSystem(String landingSystem)
    {
        this.landingSystem = landingSystem;
    }

    public String getDeviceNumber()
    {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber)
    {
        this.deviceNumber = deviceNumber;
    }

    public String getBusiType()
    {
        return busiType;
    }

    public void setBusiType(String busiType)
    {
        this.busiType = busiType;
    }

    public String getNetworkType()
    {
        return networkType;
    }

    public void setNetworkType(String networkType)
    {
        this.networkType = networkType;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getProductDesc()
    {
        return productDesc;
    }

    public void setProductDesc(String productDesc)
    {
        this.productDesc = productDesc;
    }

    public String getOrderType()
    {
        return orderType;
    }

    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    public String getTotalFee()
    {
        return totalFee;
    }

    public void setTotalFee(String totalFee)
    {
        this.totalFee = totalFee;
    }

    public String getDiscountFee()
    {
        return discountFee;
    }

    public void setDiscountFee(String discountFee)
    {
        this.discountFee = discountFee;
    }

    public String getRealFee()
    {
        return realFee;
    }

    public void setRealFee(String realFee)
    {
        this.realFee = realFee;
    }

    public String getPayChannel()
    {
        return payChannel;
    }

    public void setPayChannel(String payChannel)
    {
        this.payChannel = payChannel;
    }

    public String getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(String merchantId)
    {
        this.merchantId = merchantId;
    }

    public String getChargeFee()
    {
        return chargeFee;
    }

    public void setChargeFee(String chargeFee)
    {
        this.chargeFee = chargeFee;
    }

    public String getAcntCode()
    {
        return acntCode;
    }

    public void setAcntCode(String acntCode)
    {
        this.acntCode = acntCode;
    }

    public String getPointFee()
    {
        return pointFee;
    }

    public void setPointFee(String pointFee)
    {
        this.pointFee = pointFee;
    }

    public String getPointDeductId()
    {
        return pointDeductId;
    }

    public void setPointDeductId(String pointDeductId)
    {
        this.pointDeductId = pointDeductId;
    }

    public String getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public String getServiceClassCode()
    {
        return serviceClassCode;
    }

    public void setServiceClassCode(String serviceClassCode)
    {
        this.serviceClassCode = serviceClassCode;
    }

    public String getOperType()
    {
        return operType;
    }

    public void setOperType(String operType)
    {
        this.operType = operType;
    }

    public String getPointChanType()
    {
        return pointChanType;
    }

    public void setPointChanType(String pointChanType)
    {
        this.pointChanType = pointChanType;
    }

    public String getConsumeType()
    {
        return consumeType;
    }

    public void setConsumeType(String consumeType)
    {
        this.consumeType = consumeType;
    }

    public String getPointDeductNumber()
    {
        return pointDeductNumber;
    }

    public void setPointDeductNumber(String pointDeductNumber)
    {
        this.pointDeductNumber = pointDeductNumber;
    }

    public String getNpTag()
    {
        return npTag;
    }

    public void setNpTag(String npTag)
    {
        this.npTag = npTag;
    }

    public String getPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    public String getChargeParty()
    {
        return chargeParty;
    }

    public void setChargeParty(String chargeParty)
    {
        this.chargeParty = chargeParty;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getQueryType()
    {
        return queryType;
    }

    public void setQueryType(String queryType)
    {
        this.queryType = queryType;
    }

    public String getNetType()
    {
        return netType;
    }

    public void setNetType(String netType)
    {
        this.netType = netType;
    }

    public String getRefundOrderId()
    {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId)
    {
        this.refundOrderId = refundOrderId;
    }

    public Date getCrtTime()
    {
        return crtTime;
    }

    public void setCrtTime(Date crtTime)
    {
        this.crtTime = crtTime;
    }

    public String getRequestInput()
    {
        return requestInput;
    }

    public void setRequestInput(String requestInput)
    {
        this.requestInput = requestInput;
    }

    public String getPayRefundId()
    {
        return payRefundId;
    }

    public void setPayRefundId(String payRefundId)
    {
        this.payRefundId = payRefundId;
    }

    @Override
    public String toString()
    {
        return "BalanceOfAccountPO{" + "departCode='" + departCode + '\'' + ", orderSource='" + orderSource + '\'' + ", tradeTime='" + tradeTime + '\'' + ", provinceCode='" + provinceCode + '\'' + ", cityCode='" + cityCode + '\'' + ", outOrderId='" + outOrderId + '\'' + ", payTransactionId='" + payTransactionId + '\'' + ", relateOrderId='" + relateOrderId + '\'' + ", inModeCode='" + inModeCode + '\'' + ", orderId='" + orderId + '\'' + ", channelId='" + channelId + '\'' + ", channelType='" + channelType + '\'' + ", chanType='" + chanType + '\'' + ", createOperId='" + createOperId + '\'' + ", landingSystem='" + landingSystem + '\'' + ", deviceNumber='" + deviceNumber + '\'' + ", busiType='" + busiType + '\'' + ", networkType='" + networkType + '\'' + ", productCode='" + productCode + '\'' + ", productDesc='" + productDesc + '\'' + ", orderType='" + orderType + '\'' + ", totalFee='" + totalFee + '\'' + ", discountFee='" + discountFee + '\'' + ", realFee='" + realFee + '\'' + ", payChannel='" + payChannel + '\'' + ", merchantId='" + merchantId + '\'' + ", chargeFee='" + chargeFee + '\'' + ", acntCode='" + acntCode + '\'' + ", pointFee='" + pointFee + '\'' + ", pointDeductId='" + pointDeductId + '\'' + ", serviceType='" + serviceType + '\'' + ", serviceClassCode='" + serviceClassCode + '\'' + ", operType='" + operType + '\'' + ", pointChanType='" + pointChanType + '\'' + ", consumeType='" + consumeType + '\'' + ", pointDeductNumber='" + pointDeductNumber + '\'' + ", npTag='" + npTag + '\'' + ", paymentType='" + paymentType + '\'' + ", chargeParty='" + chargeParty + '\'' + ", areaCode='" + areaCode + '\'' + ", queryType='" + queryType + '\'' + ", netType='" + netType + '\'' + ", refundOrderId='" + refundOrderId + '\'' + ", crtTime=" + crtTime + ", requestInput='" + requestInput + '\'' + ", payRefundId='" + payRefundId + '\'' + '}';
    }
}
