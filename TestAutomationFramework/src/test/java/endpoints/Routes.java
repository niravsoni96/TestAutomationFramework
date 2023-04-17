package endpoints;


/*/employee	GET	JSON	https://dummy.restapiexample.com/api/v1/employees	Get all employee data	Details
2	/employee/{id}	GET	JSON	https://dummy.restapiexample.com/api/v1/employee/1	Get a single employee data	Details
3	/create	POST	JSON	https://dummy.restapiexample.com/api/v1/create
*/
public class Routes {
//
//	public static String base_url= "https://dummy.restapiexample.com/api/v1";
//	
//	public static String post_url=base_url+"/create"; 
//	
//	public static String get_all_emp=base_url+"/employees"; 
//	public static String get_onlyone_emp=base_url+"/employee/{id}"; 

	public static String base_url= "https://petstore.swagger.io/v2";
	
	public static String post_url=base_url+"/user"; 
	
	public static String get_all_emp=base_url+"/user/{username}"; 
	
}
