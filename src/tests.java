import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class tests {

	//Tests: 
	//1. Print No of courses returned by API
	//2.Print Purchase Amount
	//3. Print Title of the first course
	//4. Print All course titles and their respective Prices
	//5. Print no of copies sold by RPA Course
	//6. Verify if Sum of all Course prices matches with Purchase Amount
	
	JsonPath js; 
	int courseCount;

	@BeforeMethod
	public void initialize()
	{
		js = new JsonPath(payload.CoursePrices());
	}
	
	@Test(priority=1)
	public void course_number()
	{
	    courseCount = js.getInt("courses.size()");
		System.out.println("No of courses returned by API are = "+courseCount);
	}
	
	@Test(priority=2)
	public void purchase_amount()
	{
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amount is = "+purchaseAmount);
	}
	
	@Test(priority=3)
	public void first_course_title()
	{
		String first_course_title = js.get("courses[0].title");
		System.out.println("Title of the first course is = "+first_course_title);
	}
	
	@Test(priority=4)
	public void all_course_titles_and_prices()
	{
		for(int i=0;i<courseCount;i++)
		{
			String CoursesTitle= js.get("courses["+i+"].title");
			String CoursesPrice = js.get("courses["+i+"].price").toString();
			System.out.println("Course price of "+CoursesTitle +" is = "+ CoursesPrice);
			
		}
	}
	
	@Test(priority=5)
	public void copies_sold_by_RPA_course()
	{
		for(int i=0;i<courseCount;i++)
		{
			String CoursesTitle= js.get("courses["+i+"].title");
			
			if(CoursesTitle.equalsIgnoreCase("RPA"))
			{
				String copies_sold = js.get("courses["+i+"].copies").toString();
				System.out.println("no of copies sold by RPA Course are = "+copies_sold);
			}
		}
	}
	
	//Verify if Sum of all Course prices matches with Purchase Amount
	@Test(priority=6)
	public void validate_purchase_amount()
	{
		int sum = 0;
		for(int i=0;i<courseCount;i++)
		{
			int coursesPrice= js.get("courses["+i+"].price");
			int coursesCopies = js.get("courses["+i+"].copies");
			int amount  = coursesPrice * coursesCopies;
			sum = sum + amount;
		}
		System.out.println("Sum of all course prices is= "+sum);
		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		System.out.println("Sum of all Course prices are matching with the Purchase Amount");
	}
	
	
	
	
	
	
	

}
