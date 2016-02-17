package us.daveread.skidmore.webapps.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import us.ncleves.sorts.Bubble;
import us.ncleves.sorts.Heap;
import us.ncleves.sorts.Insertion;
import us.ncleves.sorts.Merge;
import us.ncleves.sorts.Quick;
import us.ncleves.sorts.Radix;
import us.ncleves.sorts.Selection;
import us.ncleves.sorts.SortingAlgorithm;

@MultipartConfig()
public class ControllerServlet extends HttpServlet {


	private static final long serialVersionUID = 19620501L;


	private static final String VERSION = "01.00.00";

	/**
	 * Logger Instance
	 */
	private static Logger LOGGER = Logger.getLogger(ControllerServlet.class);

	/**
	 * Called by container when servlet instance is created. This method sets-up
	 * the logger and DB connection properties.
	 *
	 * @param config
	 *            The servlet configuration
	 */
	public void init(ServletConfig config) {
		LOGGER.warn("Servlet init.  Version: " + VERSION);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Throwable throwable) {
			LOGGER.error("Cannot load the database driver", throwable);
		}
	}

	/**
	 * The constructor - no operations carried out here
	 */
	public ControllerServlet() {
	}

	/**
	 * This method calls the controller method
	 *
	 * @see #controller
	 *
	 * @param req
	 *            The request
	 * @param resp
	 *            The response
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		controller(req, resp);

	}

	/**
	 * This method calls the controller method
	 *
	 * @see #controller
	 *
	 * @param req
	 *            The request
	 * @param resp
	 *            The response
	 *
	 * @throws ServletException
	 * @throws IOException
	 */public void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		 controller(req, resp);

	 }

	 /**
	  * This method (controller) determines the requested mode and sets-up the
	  * proper beans (model) before forwarding to the appropriate JSP (view).
	  *
	  * @param req
	  *            The request
	  * @param resp
	  *            The response
	  *
	  * @throws ServletException
	  * @throws IOException
	  */
	 private void controller(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		 String algorithmName = null;
		 SortingAlgorithm sorting = null;
		 ArrayList<Integer> list = null;
		 PrintWriter out;
		 Part rawUploadedFile = null;
		 BufferedReader fileIn = null;

		 // Log some information about the request
		 LOGGER.debug("Context path = " + req.getContextPath());
		 LOGGER.debug("Servlet path = " + req.getServletPath());
		 LOGGER.info("Request from: " + req.getRemoteAddr() + " "
				 + req.getRemoteHost());

		 resp.setStatus(200);
		 resp.setContentType("text/html");

		 out = resp.getWriter();

		 out.println("<html>\n<head><title>Parameters Received</title></head>");

		 out.println("<body>");
		 
		 out.println("<h1>Sorted Data: </h1>");
		 
		 out.println("<a href=http://localhost:8080/Runtimes/>Sort another file</a>");

		 if(req.getMethod().equalsIgnoreCase("get")){
			 out.println("<p>Please do not send a GET request, thanks.</p>");
		 }

		 try {
			 // This assumes that the <input type="file"> uses a name of fileUpload
			 rawUploadedFile = req.getPart("fileUpload");
		 } catch (Throwable throwable) {
			 LOGGER.error("Error retrieving file", throwable);
			 rawUploadedFile = null;
		 }

		 if (rawUploadedFile != null) {
			 //out.println("<table border=\"1\"><tr><th>Attribute</th><th>Value</th></tr>");
			  //output headers from file part
			 //for (String header : rawUploadedFile.getHeaderNames()) {
				 //out.println("<tr><td>" + header + "</td><td>"
						// + rawUploadedFile.getHeader(header) + "</td></tr>");
			// }
			 //out.println("</table>");

			 try {
				 //out.println("<h2>:</h2><hr/>");
				 fileIn = new BufferedReader(new InputStreamReader(
						 rawUploadedFile.getInputStream()));

				 String oneLine;								//this is variable where each line  
				 out.println("<pre>");						//of the text file will be handled

				 list = new ArrayList<Integer>(); //create the array list to put each line of the text file
				 									//into the array	
				 while ((oneLine = fileIn.readLine()) != null) {
					 list.add(Integer.parseInt(oneLine));	//adds each line of text from the textfile to list
				 }


				 out.println("</pre><hr/>");
			 } catch(NumberFormatException nfe){
				 //put error page
			 }catch (Throwable throwable) {
				 LOGGER.error("Unable to process the uploaded file", throwable);
			 } finally {
				 if (fileIn != null) {
					 try {
						 fileIn.close();
					 } catch (Throwable throwable) {
						 LOGGER.warn("Failed to close input stream from request part",
								 throwable);
					 }
				 }
			 }
		 } else {
			 out.println("<strong>No File Uploaded</strong><br/>");
		 }


		 String sorts = req.getParameter("sorts"); 
		 LOGGER.info("here: " + sorts);
		 try{
			 switch(sorts){
			 //----------------------------------Selection-------------------------------
			 case "1":
				 algorithmName = "Selection";
				 sorting = new Selection();
				 break;
				 //----------------------------------Insertion-------------------------------
			 case "2":
				 algorithmName = "Insertion";
				 sorting = new Insertion();
				 break;
				 //----------------------------------Merge-----------------------------------
			 case "3":
				 algorithmName = "Merge";
				 sorting = new Merge();
				 break;
				 //----------------------------------Quick-----------------------------------
			 case "4":
				 algorithmName = "Quick";
				 sorting = new Quick();
				 break;
				 //----------------------------------Heap------------------------------------
			 case "5":
				 algorithmName = "Heap";
				 sorting = new Heap();
				 break;
				 //----------------------------------Radix-----------------------------------
			 case "6":
				 algorithmName = "Radix";
				 sorting = new Radix();
				 break;
				 //----------------------------------Bubble----------------------------------
			 case "7":
				 algorithmName = "Bubble";
				 sorting = new Bubble();
				 break;
			 }

			 out.println("<p><strong>" + algorithmName +" Sort! :</strong><br>");

			 long startTime = System.nanoTime();

			 sorting.sortList(list); //run the selected sort on the uploaded file

			 long endTime = System.nanoTime();
			 double raw = endTime - startTime;
			 double timeInMilli = raw/1000000;

			 int fileSize = list.size();
			 dbTimes(timeInMilli, algorithmName, fileSize);

			 out.println("<b>Runtime in millisec: " + timeInMilli + "</b>");
			 out.println("</br>");
			 out.println(list);
			 out.println("</p>");
			 
			 getTimes(req);

		 }
		 catch(Throwable throwable){
			 LOGGER.error("Sort failed: ", throwable);
		 }
		 out.close();
	 }

	 public void dbTimes(double algorithm_time, String algorithm_name, long file_size){
		 Connection conn = null;
		 PreparedStatement stmt = null;
		 String sql = "insert into times (time, algorithm_name, char_count) values (?, ?, ?)";

		 try{
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/runtimes", 
					 "runtimeswebapp", "runtimeswebapp");
			 stmt = conn.prepareStatement(sql);
			 stmt.setDouble(1, algorithm_time);
			 stmt.setString(2, algorithm_name);
			 stmt.setLong(3, file_size);
			 stmt.execute();
		 }catch(Throwable throwable){
			 LOGGER.error("Unable to add time [" + algorithm_time + "]", throwable);
		 } finally {
			 if (stmt != null) {
				 try {
					 stmt.close();
				 } catch (Throwable throwable) {
					 LOGGER.error("Unable to close statement", throwable);
				 }
			 }
			 if (conn != null) {
				 try {
					 conn.close();
				 } catch (Throwable throwable) {
					 LOGGER.error("Unable to close connection", throwable);
				 }
			 }

		 }

	 }

	 public void getTimes(HttpServletRequest req){
		 Connection conn = null;
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 ArrayList<RuntimeBean> runtimeBean = new ArrayList<RuntimeBean>();
		 String sql = "select * from times";

		 try{
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/runtimes", 
					 "runtimeswebapp", "runtimeswebapp");
			 stmt = conn.prepareStatement(sql);
			 rs = stmt.executeQuery();

			 while(rs.next()){
				 runtimeBean.add(new RuntimeBean(rs.getDouble("time"), rs.getString("algorithm_name"), rs.getLong("char_count")));
			 }
			 
			 req.setAttribute("runtimebean", runtimeBean);

		 }catch(Throwable throwable){
			 LOGGER.error("Unable to load runtimes", throwable);
		 } finally {
			 if (rs != null) {
				 try {
					 rs.close();
				 } catch (Throwable throwable) {
					 LOGGER.error("Unable to close rs", throwable);
				 }
			 }
			 if (stmt != null) {
				 try {
					 stmt.close();
				 } catch (Throwable throwable) {
					 LOGGER.error("Unable to close statement", throwable);
				 }
			 }
			 if (conn != null) {
				 try {
					 conn.close();
				 } catch (Throwable throwable) {
					 LOGGER.error("Unable to close connection", throwable);
				 }
			 }


		 }
	 }

}
