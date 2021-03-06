package com.hzmc.weixin.pay.redpack.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzmc.weixin.pay.base.BaseResponse;
import com.hzmc.weixin.pay.util.DateDeserializer;
import com.hzmc.weixin.pay.util.DateSerializer;

import java.util.Date;
import java.util.List;

public class RedPackResult extends BaseResponse {

	@JsonProperty("mch_billno")
	private String billNumber;

	@JsonProperty("mch_id")
	private String mchId;

	@JsonProperty("detail_id")
	private String detailId;

	@JsonProperty("status")
	private String status;

	@JsonProperty("total_amount")
	private int totalAmount;

	@JsonProperty("total_num")
	private int number;

	@JsonProperty("send_type")
	private String sendType;

	private String reason;

	@JsonProperty("hb_type")
	private String readPackType;

	@JsonProperty("send_time")
	@JsonDeserialize(using = DateDeserializer.class)
	private Date sendTime;

	@JsonProperty("refund_time")
	@JsonDeserialize(using = DateDeserializer.class)
	private Date refundTime;

	@JsonProperty("refund_amount")
	@JsonDeserialize(using = DateDeserializer.class)
	private int refundAmount;

	@JsonProperty("hblist")
	private List<RedPackReport> reports;

	public List<RedPackReport> getReports() {
		return reports;
	}

	public void setReports(List<RedPackReport> reports) {
		this.reports = reports;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getReadPackType() {
		return readPackType;
	}

	public void setReadPackType(String readPackType) {
		this.readPackType = readPackType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static class RedPackReport {

		@JsonProperty("openid")
		private String openId;

		private int amount;

		private String status;

		@JsonProperty("rcv_time")
		@JsonDeserialize(using = DateDeserializer.class)
		@JsonSerialize(using = DateSerializer.class)
		private Date receivedTime;

		public String getOpenId() {
			return openId;
		}

		public void setOpenId(String openId) {
			this.openId = openId;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getReceivedTime() {
			return receivedTime;
		}

		public void setReceivedTime(Date receivedTime) {
			this.receivedTime = receivedTime;
		}
	}
}
