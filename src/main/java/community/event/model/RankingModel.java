package community.event.model;

import java.util.List;

import javax.persistence.Column;

import community.event.model.RankingModel;

import lombok.Data;

@Data
public class RankingModel {
	private int id;

	private String teamLogo;

	private String team;

	private String victory;

	private String defeat;

	private String draw;

	private String odds;

	private String gamesBehind;
}