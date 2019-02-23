package com.main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthSubScores {
	@JsonProperty("dep")
	String anitDepressionScore;
	@JsonProperty("slp")
	String sleepScore;
	@JsonProperty("wel")
	String wellnessScore;
	@JsonProperty("str")
	String antiStressScore;
	@JsonProperty("smk")
	String antiSmokingScore;
	@JsonProperty("nut")
	String nutritionScore;
	@JsonProperty("obe")
	String antiObesityScore;
	@JsonProperty("mvm")
	String movementScore;

	public String getAnitDepressionScore() {
		return anitDepressionScore;
	}

	public void setAnitDepressionScore(String anitDepressionScore) {
		this.anitDepressionScore = anitDepressionScore;
	}

	public String getSleepScore() {
		return sleepScore;
	}

	public void setSleepScore(String sleepScore) {
		this.sleepScore = sleepScore;
	}

	public String getWellnessScore() {
		return wellnessScore;
	}

	public void setWellnessScore(String wellnessScore) {
		this.wellnessScore = wellnessScore;
	}

	public String getAntiStressScore() {
		return antiStressScore;
	}

	public void setAntiStressScore(String antiStressScore) {
		this.antiStressScore = antiStressScore;
	}

	public String getAntiSmokingScore() {
		return antiSmokingScore;
	}

	public void setAntiSmokingScore(String antiSmokingScore) {
		this.antiSmokingScore = antiSmokingScore;
	}

	public String getNutritionScore() {
		return nutritionScore;
	}

	public void setNutritionScore(String nutritionScore) {
		this.nutritionScore = nutritionScore;
	}

	public String getAntiObesityScore() {
		return antiObesityScore;
	}

	public void setAntiObesityScore(String antiObesityScore) {
		this.antiObesityScore = antiObesityScore;
	}

	public String getMovementScore() {
		return movementScore;
	}

	public void setMovementScore(String movementScore) {
		this.movementScore = movementScore;
	}

}
