package community.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import community.entity.RankingEntity;
import community.repository.RankingRepository;

@Service
public class RankingService {

	@Autowired
	RankingRepository rankingRepository;
	
	public void processQueueMessage(String message) {
		try {
			// String testMsg = "[{\"id\":1,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMTI5/MDAxNTc0MzA2OTQxNjI2.vX11nZcVlA0ZQ-SPrFb4NOI9zckN_w-Ek6hKYOBZTcMg.i4vpZtxCSkR2AogiWObKqXRF5W_yoxeUbaXJyDDntZIg.PNG.gussud48ahmn/SK.png?type\\u003dw580\",\"team\":\"SK\",\"victory\":\"88\",\"defeat\":\"55\",\"draw\":\"1\",\"odds\":\".615\",\"gamesBehind\":\"-\"},{\"id\":2,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMjY5/MDAxNTc0MzA2OTQxNjI5.5sv60f0VRRtnZIZ5u3EQxUOQqOKwuyeCyksE4AdN2RYg.QhGBWH7Rk1If-5ps6s3AD2vTeTONLaVJqY-rxPSlM2gg.PNG.gussud48ahmn/%EB%91%90%EC%82%B0.png?type\\u003dw580\",\"team\":\"두산\",\"victory\":\"88\",\"defeat\":\"55\",\"draw\":\"1\",\"odds\":\".615\",\"gamesBehind\":\"-\"},{\"id\":3,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMTE1/MDAxNTc0MzA2OTQxNzc0.ksetNNS4YxN_v99iWQL8BzrQ9OVjeSu9FmVYU4nZxHsg.Uhx4_OWZWCU3Kzo78MWYbwzZ4V7B261RbRSsKvQ2Encg.PNG.gussud48ahmn/%ED%82%A4%EC%9B%80.png?type\\u003dw580\",\"team\":\"키움\",\"victory\":\"86\",\"defeat\":\"57\",\"draw\":\"1\",\"odds\":\".601\",\"gamesBehind\":\"2.0\"},{\"id\":4,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMTE1/MDAxNTc0MzA2OTQxNjE5.042J59_9hSAlFZSxHU6NGAnP5oQqgrWNzr94WQsohEsg.UVzM2GojIVqNz-kxy_yD96UgmeyovBrAOHehpvJuGpcg.PNG.gussud48ahmn/LG.png?type\\u003dw580\",\"team\":\"LG\",\"victory\":\"79\",\"defeat\":\"64\",\"draw\":\"1\",\"odds\":\".552\",\"gamesBehind\":\"9.0\"},{\"id\":5,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMjkz/MDAxNTc0MzA2OTQxNjI1.DUkvRYPFx5RvTWC-6oRw3wS-o6yFet6wJSa5jvCBevEg.OILJEcHlrINAjHNP0rUzpkFvm18GwEDBAeI_D6HSiVkg.PNG.gussud48ahmn/NC.png?type\\u003dw580\",\"team\":\"NC\",\"victory\":\"73\",\"defeat\":\"71\",\"draw\":\"2\",\"odds\":\".500\",\"gamesBehind\":\"14.5\"},{\"id\":6,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMzAg/MDAxNTc0MzA2OTQxNjE4.5edn3X2LDg5OREgv_N9VUKP8-jgsPpj8gZUucQbC3pQg.LXKKibvf-EKz2VyLZmyKXi95QVVT9fxy_7W8niFeYe8g.PNG.gussud48ahmn/KT.png?type\\u003dw580\",\"team\":\"KT\",\"victory\":\"71\",\"defeat\":\"71\",\"draw\":\"2\",\"odds\":\".500\",\"gamesBehind\":\"16.5\"},{\"id\":7,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMjYx/MDAxNTc0MzA2OTQxNjIy.TT_wreVpz9UmX-lafWmk7aBOZgH1D-3DZPJ_8tAI4mwg.NitGS2IyjHsmuFxVKcXFcVlAWUfLPD7ycRRTeRwqsakg.PNG.gussud48ahmn/KIA.png?type\\u003dw580\",\"team\":\"KIA\",\"victory\":\"62\",\"defeat\":\"80\",\"draw\":\"2\",\"odds\":\".437\",\"gamesBehind\":\"25.5\"},{\"id\":8,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMjkz/MDAxNTc0MzA2OTQxNzcy.guwzHmXyiBClfVyzAENAWKSDw8ea9mPRAB_4CKD8fDYg.ATa22khu03ARaEBTqa0c9jTvd0LPyAmyg0PYfWlzlVcg.PNG.gussud48ahmn/%EC%82%BC%EC%84%B1.png?type\\u003dw580\",\"team\":\"삼성\",\"victory\":\"60\",\"defeat\":\"83\",\"draw\":\"1\",\"odds\":\".420\",\"gamesBehind\":\"28.0\"},{\"id\":9,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfODQg/MDAxNTc0MzA2OTQxODI4.9YBse4IIawsPFTUNCpeA0QYqCUxhU3MH-pzxs3h8Uigg.S2Ly6sph9pHAfWVR4p9R2ouwBMwB-fo3zbvMFIIsnlkg.PNG.gussud48ahmn/%ED%95%9C%ED%99%94.png?type\\u003dw580\",\"team\":\"한화\",\"victory\":\"58\",\"defeat\":\"86\",\"draw\":\"0\",\"odds\":\".403\",\"gamesBehind\":\"30.5\"},{\"id\":10,\"teamLogo\":\"https://postfiles.pstatic.net/MjAxOTExMjFfMTMg/MDAxNTc0MzA2OTQxNzcw.0HlyKze_mFsP7UCs6BwgmzAVGLoY-iV7BIGj8leRnOAg.MVvafaoJWb34DKH8yDbsseNjWdKWSO17NTO8s0S6Nacg.PNG.gussud48ahmn/%EB%A1%AF%EB%8D%B0.png?type\\u003dw580\",\"team\":\"롯데\",\"victory\":\"48\",\"defeat\":\"93\",\"draw\":\"3\",\"odds\":\".340\",\"gamesBehind\":\"39.0\"}]";
			//JSON 형태로 For문을 사용하여 String 형태로 변환후 rankingRepository에 저장  db에 저장한다
			JSONParser jsonParser = new JSONParser();
						
			Object obj = jsonParser.parse(message);
			
			JSONArray jsonArray = (JSONArray) obj;
			Gson gson = new Gson();

			List<RankingEntity> lst = gson.fromJson( jsonArray.toString() , new TypeToken<ArrayList<RankingEntity>>(){}.getType() );
			rankingRepository.saveAll(lst);


			
			
			
			
//			for(int i=0; i<jsonArray.size(); i++) {
//				
//				RankingEntity rankingEntity = new RankingEntity();
//				Object obj2 = jsonParser.parse(jsonArray.get(i).toString());			
//				JSONObject jsonObj = (JSONObject) obj2;
//				String teamLogo = (String) jsonObj.get("teamLogo");
//				String defeat = (String) jsonObj.get("defeat");
//				String gamesBehind = (String) jsonObj.get("gamesBehind");
//				String victory = (String) jsonObj.get("victory");
//				String team = (String) jsonObj.get("team");
//				String odds = (String) jsonObj.get("odds");
//				String draw = (String) jsonObj.get("draw");
//				
//				rankingEntity.setId(i+1);
//				rankingEntity.setTeamLogo(teamLogo);
//				rankingEntity.setDefeat(defeat);
//				rankingEntity.setGamesBehind(gamesBehind);
//				rankingEntity.setVictory(victory);
//				rankingEntity.setTeam(team);
//				rankingEntity.setOdds(odds);
//				rankingEntity.setDraw(draw);
//				 				
//				rankingRepository.save(rankingEntity);
//			}
		} catch (Exception e)  {
			e.printStackTrace();
		}
	}
}
