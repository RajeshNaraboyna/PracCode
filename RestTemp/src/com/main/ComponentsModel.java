package com.main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComponentsModel {
	@JsonProperty("lfs")
	String lifeStyleScore;
	@JsonProperty("bdy")
	String bodyScore;
	@JsonProperty("fee")
	String feelingScore;

	public String getLifeStyleScore() {
		return lifeStyleScore;
	}

	public void setLifeStyleScore(String lifeStyleScore) {
		this.lifeStyleScore = lifeStyleScore;
	}

	public String getBodyScore() {
		return bodyScore;
	}

	public void setBodyScore(String bodyScore) {
		this.bodyScore = bodyScore;
	}

	public String getFeelingScore() {
		return feelingScore;
	}

	public void setFeelingScore(String feelingScore) {
		this.feelingScore = feelingScore;
	}

}
