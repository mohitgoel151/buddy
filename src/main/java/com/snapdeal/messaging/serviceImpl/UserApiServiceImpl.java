package com.snapdeal.messaging.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snapdeal.hack.model.rr.AddFriendRequest;
import com.snapdeal.hack.model.rr.AddFriendsResponse;
import com.snapdeal.hack.model.rr.AddPurchaseRequest;
import com.snapdeal.hack.model.rr.ProductDetailedReviewsResponse;
import com.snapdeal.hack.model.rr.PurchaseResponse;
import com.snapdeal.hack.model.rr.SimilarCategoryPurchaseResponse;
import com.snapdeal.hack.neo4j.NeoAdapterInterface;
import com.snapdeal.hack.util.Utils;
import com.snapdeal.messaging.service.UserApiService;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
@PropertySource("classpath:userQuery.properties")
public class UserApiServiceImpl implements UserApiService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	@Resource
	private Environment environment;
	
	@Autowired
	private NeoAdapterInterface neo4j;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private static int idi = 106;

	public PurchaseResponse addPurchaseEntry() {
		System.out.println("addPurchaseEntry");
		
		
		List<String> queryList = new ArrayList<String>();
		queryList.add("create (a:Buyer {name:'Abdul Rahman',fbid:'1',emailId:'shaik.rahman@snapdeal.com',lastupdatedfb:'04/09/2015',imageurl:'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xfp1/v/t1.0-1/c0.0.50.50/p50x50/10347480_1055452904482373_4246244140302870523_n.jpg?oh=a7b269676c69cb47550d507f5e5304c4&oe=56685836&__gda__=1449605663_a0fa917077bba325c94536469ad737dc'});");
		queryList.add("CREATE (x:Product {name:'Celkon',supcCode : "+idi+",title:'Celkon',detailpageurl:'http://www.snapdeal.com/product/celkon-q405-dual-sim-mobile/667476228758#bcrumbSearch:Celkon%20Q405',image:'http://n2.sdlcdn.com/imgs/a/y/h/small/Celkon-Q405-Dual-SIM-Mobile-SDL024708671-1-9cb89.jpg'});");
		queryList.add("create (c:Category {name : 'Mobiles'});");
		StringBuilder sb = new  StringBuilder();
		sb.append("match (x:Product {supcCode:"+idi+"}) ");
		sb.append("match (c:Category {name:'Mobiles'}) ");
		sb.append("match (a:Buyer {fbid:'1'}) ");
		sb.append("create (x)-[:oftype]->c ");
		sb.append("create (a)-[:Purchase {date:'10/09/2015',visibility:'true', isReturned:'false'}]->(x) ");
		sb.append("create (a)-[:ReviewRatings {reviewComments:'Average',rating:3,isRecommended:'true'}]->(x);");
		queryList.add(sb.toString());
		Iterator result1 = queryList.iterator(); 
		while(result1.hasNext()) {
			try{
				String result = neo4j.sendTransactionalCypherQuery((String)result1.next());
				System.out.println(result);
			}catch(Exception e){

			}
		}

		return new PurchaseResponse();

	}


	public ProductDetailedReviewsResponse getProductDetailedReviews(final String fbid, final String supcCode, final String bol) {
		System.out.println("getSimilarCategoryPurchase");

		String query = "";
		if(StringUtils.equalsIgnoreCase("true", bol) == true) {
			query =	"match(x:Product {supcCode:"+supcCode+"})-[r:ReviewRatings]-(u:Buyer)-[f:friend]-(us:Buyer {fbid:'" + fbid + "'}) return distinct {Product: x, User: u , Review: r}";
		} else {
			query =	"match(x:Product {supcCode:"+supcCode+"})-[r:ReviewRatings]-(u:Buyer)-[f:friend]-(us:Buyer {fbid:'" + fbid + "'}) return distinct {Product: x, User: u , Review: r}";
				//query = "match(x:Product {supcCode:"+supcCode+"})-[r:Purchase]-(u:Buyer)-[f:friend]-(us:Buyer {fbid:'" + fbid + "'}) return distinct {Product: x, User: u , Review: r}";
		}
				String result = neo4j.sendTransactionalCypherQuery(query);
				System.out.println(query);
		System.out.println(result);
		
		ProductDetailedReviewsResponse productReview = Utils.parseProductDetailedReviewsResponse(result);

		return productReview;
	}
	
	public SimilarCategoryPurchaseResponse getSimilarCategoryPurchase(final String fbid, final String supcCode) {
		System.out.println("getSimilarCategoryPurchase");
		
		String query = "match(c:Category {name:'Mobiles'})-[r:oftype]-(p:Product)-[rr:ReviewRatings]-(us:Buyer)-[f:friend]-(u:Buyer {fbid:'" + fbid + "'}) return distinct {Product : p, User: us, Review: rr}";
		//String query = "match(x:Product {supcCode:"+supcCode+"})-[r:ReviewRatings]-(u:Buyer)-[f:friend]-(us:Buyer {fbid:'" + fbid + "'}) return {Product: x, User: u , Review: r}";
		String result = neo4j.sendTransactionalCypherQuery(query);
		System.out.println(result);
		
		SimilarCategoryPurchaseResponse categoryReview = Utils.parseSimilarCategoryPurchaseResponse(result);
		return categoryReview;
	}

	



//	@Override
//	public boolean createUser(User user) {
//		boolean status=true;
//		try{
//			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
//			namedParameterTemplate.update(environment.getProperty("userInsertQuery"), namedParameters);
//		}
//		catch(Exception e){
//			status=false;
//		}
//		return status;	
//	}
//
//
//	@Override
//	public PaginatedUserDetails getListOfUser() {
//		PaginatedUserDetails pud= new PaginatedUserDetails();
//		pud.setCurrent_page(1);
//		pud.setPer_page(10);
//		pud.setTotal_entries(8);
//		List<User> listOfItems= new ArrayList<User>();
//		listOfItems=jdbcTemplate.query(environment.getProperty("queryForUserList"), 
//				new BeanPropertyRowMapper(User.class));
//		pud.setItems(listOfItems);
//		return pud;
//	}


}
