package com.main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DacadooResponseModel {

	@JsonProperty("rqy")
	String relativeQltyYears;
	HealthSubScores subscores;
	ComponentsModel components;
	@JsonProperty("lcl")
	public String lowerConfidenceLmt;
	@JsonProperty("scr")
	public String overallHealthScore;
	@JsonProperty("ucl")
	public String upperConfidenceLimit;

	public String getRelativeQltyYears() {
		return relativeQltyYears;
	}

	public void setRelativeQltyYears(String relativeQltyYears) {
		this.relativeQltyYears = relativeQltyYears;
	}

	public HealthSubScores getSubscores() {
		return subscores;
	}

	public void setSubscores(HealthSubScores subscores) {
		this.subscores = subscores;
	}

	public ComponentsModel getComponents() {
		return components;
	}

	public void setComponents(ComponentsModel components) {
		this.components = components;
	}

	public String getLowerConfidenceLmt() {
		return lowerConfidenceLmt;
	}

	public void setLowerConfidenceLmt(String lowerConfidenceLmt) {
		this.lowerConfidenceLmt = lowerConfidenceLmt;
	}

	public String getOverallHealthScore() {
		return overallHealthScore;
	}

	public void setOverallHealthScore(String overallHealthScore) {
		this.overallHealthScore = overallHealthScore;
	}

	public String getUpperConfidenceLimit() {
		return upperConfidenceLimit;
	}

	public void setUpperConfidenceLimit(String upperConfidenceLimit) {
		this.upperConfidenceLimit = upperConfidenceLimit;
	}

}
